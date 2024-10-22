package com.be.service;

import org.springframework.stereotype.Service;

import com.be.dto.request.RoleRequest;
import com.be.dto.response.RoleResponse;
import com.be.model.RoleEntity;
import com.be.repository.RoleReponsitory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleReponsitory roleReponsitory;

    public RoleResponse create(RoleRequest request) {
        RoleEntity roleEntity = RoleEntity.builder()
                .roleName(request.getRoleName())
                .description(request.getDescription())
                .build();
        roleReponsitory.save(roleEntity);
        RoleResponse roleResponse = RoleResponse.builder()
                .roleName(roleEntity.getRoleName())
                .description(roleEntity.getDescription())
                .build();
        return roleResponse;
    }

}
