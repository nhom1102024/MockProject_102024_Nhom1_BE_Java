package com.be.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Employee;
import com.be.model.FeedbackEmployee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    
}
