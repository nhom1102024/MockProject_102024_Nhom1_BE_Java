package com.lease_master.security.service;

import com.lease_master.model.User;
import com.lease_master.security.dto.AuthenticatedUserDto;
import com.lease_master.security.dto.RegistrationRequest;
import com.lease_master.security.dto.RegistrationResponse;


public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
