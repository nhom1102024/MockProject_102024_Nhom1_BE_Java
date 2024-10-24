package com.lease_master.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String fullName;

	private String username;

	private String password;

	private String roleName;

}
