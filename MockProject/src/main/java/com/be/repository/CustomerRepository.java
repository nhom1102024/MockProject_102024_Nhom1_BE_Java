package com.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
