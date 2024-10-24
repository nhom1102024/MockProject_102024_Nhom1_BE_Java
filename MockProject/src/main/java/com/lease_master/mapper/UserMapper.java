package com.lease_master.mapper;

import com.lease_master.model.User;
import com.lease_master.security.dto.AuthenticatedUserDto;
import com.lease_master.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	@Mapping(source = "role.roleName", target = "roleName")
	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	@Mapping(target = "role.roleName", source = "roleName")
	User convertToUser(AuthenticatedUserDto authenticatedUserDto);
}