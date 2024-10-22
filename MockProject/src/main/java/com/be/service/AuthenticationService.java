package com.be.service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.be.dto.request.EmployeeCreateRequest;
import com.be.dto.request.LoginRequest;
import com.be.dto.request.ReFreshTokenRequest;
import com.be.dto.response.AuthenticationResponse;
import com.be.enums.Role;
import com.be.model.CustomerEntity;
import com.be.model.EmployeeEntity;
import com.be.model.RoleEntity;
import com.be.repository.CustomerRepository;
import com.be.repository.EmployeeRepository;
import com.be.repository.RoleReponsitory;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    EmployeeRepository employeeRepository;
    CustomerRepository customerRepository;
    RoleReponsitory roleReponsitory;
    PasswordEncoder passwordEncoder;

    @NonFinal
    @Value("${app.SECRET_KEY}")
    protected String SECRET_KEY;

    public AuthenticationResponse refreshToken(ReFreshTokenRequest request) {
        try {
            // Verify và decode refresh token
            SignedJWT signedJWT = SignedJWT.parse(request.getAccessToken());
            String userName = signedJWT.getJWTClaimsSet().getSubject();

            // Tìm user trong cả 2 repository
            Optional<EmployeeEntity> employee = employeeRepository.findByUserName(userName);
            if (employee.isPresent() && isTokenValid(request.getAccessToken(), employee.get())) {
                var newToken = generateToken(employee.get().getUserName(), employee.get().getRole().getRoleName());
                return AuthenticationResponse.builder()
                        .accessToken(request.getAccessToken()) // giữ nguyên refresh token cũ
                        .refreshToken(newToken)
                        .build();
            }

            Optional<CustomerEntity> customer = customerRepository.findByUserName(userName);
            if (customer.isPresent() && isTokenValid(request.getAccessToken(), customer.get())) {
                var newToken = generateToken(customer.get().getUserName(), customer.get().getRole().getRoleName());
                return AuthenticationResponse.builder()
                        .accessToken(request.getAccessToken()) // giữ nguyên refresh token cũ
                        .refreshToken(newToken)
                        .build();
            }

            throw new RuntimeException("ErrorCode.INVALID_REFRESH_TOKEN");
        } catch (ParseException e) {
            throw new RuntimeException("Error processing token", e);
        }
    }

    // register employee
    public AuthenticationResponse register(EmployeeCreateRequest request) {

        if (employeeRepository.existsByUserName(request.getUserName())) {
            throw new RuntimeException("ErrorCode.USER_EXISTED");
        }

        if (customerRepository.existsByUserName(request.getUserName())) {
            throw new RuntimeException("ErrorCode.USER_EXISTED");
        }

        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new IllegalArgumentException("Password and Repeat Password not match!");
        }

        RoleEntity defaultRoleEntity = RoleEntity.builder()
                .roleName(Role.STAFF.name())
                .description("Default Role STAFF description")
                .build();
        roleReponsitory.save(defaultRoleEntity);

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .role(defaultRoleEntity)
                .build();

        employeeRepository.save(employeeEntity);

        LoginRequest loginRequest = LoginRequest.builder().userName(request.getUserName())
                .password(request.getPassword()).build();
        AuthenticationResponse authenticationResponse = login(loginRequest);
        return authenticationResponse;
    }

    // register customer
    public AuthenticationResponse registerCustomer(EmployeeCreateRequest request) {

        if (employeeRepository.existsByUserName(request.getUserName())) {
            throw new RuntimeException("ErrorCode.USER_EXISTED");
        }

        if (customerRepository.existsByUserName(request.getUserName())) {
            throw new RuntimeException("ErrorCode.USER_EXISTED");
        }

        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new IllegalArgumentException("Password and Repeat Password not match!");
        }

        RoleEntity defaultRoleEntity = RoleEntity.builder()
                .roleName(Role.CUSTOMER.name())
                .description("Default Role CUSTOMER description")
                .build();
        roleReponsitory.save(defaultRoleEntity);

        CustomerEntity customerEntity = CustomerEntity.builder()
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .role(defaultRoleEntity)
                .build();

        customerRepository.save(customerEntity);

        LoginRequest loginRequest = LoginRequest.builder().userName(request.getUserName())
                .password(request.getPassword()).build();
        AuthenticationResponse authenticationResponse = login(loginRequest);
        return authenticationResponse;
    }

    public AuthenticationResponse login(LoginRequest request) {
        // Tìm trong employeeRepository trước
        Optional<EmployeeEntity> employee = employeeRepository.findByUserName(request.getUserName());
        if (employee.isPresent()) {
            boolean authenticated = passwordEncoder.matches(request.getPassword(), employee.get().getPassword());
            if (!authenticated) {
                throw new RuntimeException("ErrorCode.UNAUTHENTICATED");
            }

            var token = generateToken(employee.get().getUserName(), employee.get().getRole().getRoleName());
            return AuthenticationResponse.builder()
                    .accessToken(token)
                    .refreshToken(token)
                    .build();
        }

        // Nếu không tìm thấy trong employeeRepository, tìm trong customerRepository
        Optional<CustomerEntity> customer = customerRepository.findByUserName(request.getUserName());
        if (customer.isPresent()) {
            boolean authenticated = passwordEncoder.matches(request.getPassword(), customer.get().getPassword());
            if (!authenticated) {
                throw new RuntimeException("ErrorCode.UNAUTHENTICATED");
            }

            var token = generateToken(customer.get().getUserName(), customer.get().getRole().getRoleName());
            return AuthenticationResponse.builder()
                    .accessToken(token)
                    .refreshToken(token)
                    .build();
        }

        // Nếu không tìm thấy ở cả hai nơi
        throw new RuntimeException("ErrorCode.USER_NOT_EXISTED");
    }

    // isTokenValid, isTokenValidInternal, isTokenExpired dùng để hỗ trợ refresh token
    private boolean isTokenValid(String token, EmployeeEntity employee) {
        return isTokenValidInternal(token, employee.getUserName());
    }

    private boolean isTokenValid(String token, CustomerEntity customer) {
        return isTokenValidInternal(token, customer.getUserName());
    }

    private boolean isTokenValidInternal(String token, String username) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET_KEY);

            if (signedJWT.verify(verifier)) {
                String tokenUsername = signedJWT.getJWTClaimsSet().getSubject();
                Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
                return (tokenUsername.equals(username) && !isTokenExpired(expirationTime));
            }
            return false;
        } catch (ParseException | JOSEException e) {
            throw new RuntimeException("Error validating token", e);
        }
    }

    private boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }

    private String generateToken(String userName, String role) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .issuer("MockProject.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", buildScope(role))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private String buildScope(String role) {
        if (role != null) {
            return "ROLE_" + role;
        }
        return "";
    }

}
