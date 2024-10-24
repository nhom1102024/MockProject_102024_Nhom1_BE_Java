package com.be.security.service;

import com.be.consts.UserRole;
import com.be.model.User;
import com.be.repository.RoleRepository;
import com.be.repository.UserRepository;
import com.be.security.dto.AuthenticatedUserDto;
import com.be.security.dto.RegistrationRequest;
import com.be.security.dto.RegistrationResponse;
import com.be.service.user.UserValidationService;
import com.be.utils.GeneralMessageAccessor;
import com.be.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		// Fetch the role with name "User" and set it for the user
		var userRole = roleRepository.findByRoleName(UserRole.USER);
		if (userRole == null) {
			throw new IllegalArgumentException("Role 'User' not found");
		}

		user.setRole(userRole);
		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {
		final User user = findByUsername(username);
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
