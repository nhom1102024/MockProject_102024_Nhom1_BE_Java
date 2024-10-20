package com.be.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Customer;
import com.be.model.FeedbackEmployee;

public interface CustomerRepository extends JpaRepository <Customer, Integer>{
    
}
