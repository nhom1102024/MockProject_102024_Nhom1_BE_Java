package com.be.security.service;

import com.be.model.User;
import com.be.security.dto.AuthenticatedUserDto;
import com.be.security.dto.RegistrationRequest;
import com.be.security.dto.RegistrationResponse;


public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
