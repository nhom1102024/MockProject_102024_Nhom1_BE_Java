package com.be.service; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.dto.EmployeeDTO;
import com.be.exception.CustomRuntimeException;
import com.be.model.Employee;
import com.be.repository.EmployeeRepository;

/**			
 * EmployeeService
 *			
 * Version 1.0			
 *			
 * Date: 20-10-2024			
 *			
 * Copyright 			
 *			
 * Modification Logs:			
 * DATE                 AUTHOR          DESCRIPTION			
 * -----------------------------------------------------------------------			
 * 20-10-2024         ThanhGiang            Create			
 */
@Service
public class EmployeeService {
     @Autowired
     private  EmployeeRepository employeeRepository;
     
     /**
     * Update data for profile Employee with id and data from request
     * @param id
     * @param employeeDTO
     * @return
     */  
     public Employee updatEmployeeProfile(Integer id, EmployeeDTO employeeDTO){
         Employee employee = employeeRepository.findById(id)
             .orElseThrow(() -> new CustomRuntimeException("Employ not found"));
             employee.setUserName(employeeDTO.getUsername());
             employee.setEmail(employeeDTO.getEmail());
             if (employeeDTO.getFirstName() != null && employeeDTO.getLastName() != null) {
                 String fullName = employeeDTO.getFirstName() + " " + employeeDTO.getLastName();
                 employee.setFullName(fullName);
             }
    
             employee.setPassword(employeeDTO.getPassword());
             employee.setDateOfBirth(employeeDTO.getDayOfBirth());
             employee.setAddress(employeeDTO.getAddress());
             employee.setPhoneNumber(employeeDTO.getPhoneNumber());

             return employeeRepository.save(employee);
     } 
