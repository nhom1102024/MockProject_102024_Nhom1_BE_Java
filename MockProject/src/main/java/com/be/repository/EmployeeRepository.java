package com.be.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Employee;


public interface EmployeeRepository extends JpaRepository <Employee, Integer>{
    
}
