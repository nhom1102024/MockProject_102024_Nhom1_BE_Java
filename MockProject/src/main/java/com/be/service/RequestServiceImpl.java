package com.be.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.be.model.Role;
import com.be.model.RoleDTO;

import com.be.repository.RoleRepository;

@Service
public class RequestServiceImpl implements RequestService {
    private final RoleRepository roleRepository;
   
    public RequestServiceImpl( RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
       @Override
    public List<RoleDTO> getAllProducts() {
        return roleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RoleDTO convertToDTO(Role product) {
        return new RoleDTO(product.getRoleId(), product.getRoleName(), product.getDescription());
    }

    // Convert ProductDTO to Product Entity
    private Role convertToEntity(RoleDTO productDTO) {
        Role product = new Role();
        product.setRoleName(productDTO.roleName());
        product.setDescription(productDTO.description());
       
        return product;
    }
}
