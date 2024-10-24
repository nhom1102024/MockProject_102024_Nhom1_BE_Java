package com.be.repository;

import com.be.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ServiceRepository extends JpaRepository<Services, Long>, JpaSpecificationExecutor<Services> {
}

