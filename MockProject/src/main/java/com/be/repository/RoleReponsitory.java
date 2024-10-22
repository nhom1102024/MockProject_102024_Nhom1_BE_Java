package com.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.model.RoleEntity;

@Repository
public interface RoleReponsitory extends JpaRepository<RoleEntity, Integer>{
    
}

