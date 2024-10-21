package com.lease_master.repository;

import com.lease_master.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByRoleName(String roleName);

    Role findByRoleName(String roleName);
}
