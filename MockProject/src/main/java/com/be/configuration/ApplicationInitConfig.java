package com.be.configuration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.be.enums.Role;
import com.be.model.EmployeeEntity;
import com.be.model.RoleEntity;
import com.be.repository.EmployeeRepository;
import com.be.repository.RoleReponsitory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(EmployeeRepository employeeRepository, RoleReponsitory roleReponsitory) {
        return args -> {
            if (employeeRepository.findByUserName("admin").isEmpty()) {
                RoleEntity adminRoleEntity = RoleEntity.builder()
                        .roleName(Role.ADMIN.name())
                        .description("Default Admin Role Description")
                        .build();
                roleReponsitory.save(adminRoleEntity);
                EmployeeEntity employeeEntity = EmployeeEntity.builder()
                        .userName("admin")
                        .password(passwordEncoder.encode("admin"))
                        .role(adminRoleEntity)
                        .build();
                employeeRepository.save(employeeEntity);
                log.warn("admin has been created with default password: admin, please change it");
            }
        };
    }
}
