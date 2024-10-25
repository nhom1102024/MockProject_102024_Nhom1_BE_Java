package com.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.model.Customer;
import com.be.model.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    boolean existsByUserName(String userName);

    Optional<CustomerEntity> findByUserName(String userName);

    public CustomerEntity findByFullName(String name);
}
