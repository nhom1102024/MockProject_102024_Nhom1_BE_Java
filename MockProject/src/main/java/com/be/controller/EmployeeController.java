package com.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.dto.EmployeeDTO;
import com.be.model.Employee;
import com.be.service.EmployeeService;

/**			
 * EmployeeController			
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
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
     
     @Autowired     
     private EmployeeService employeeService;
     
     /**
     * Update data for profile Employee with id and data from request
     * @param id
     * @param employeeDTO
     * @return
     */  
     @PutMapping("/profile/{id}")
     public Employee updateEmployee (@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO){
         Employee employee = employeeService.updatEmployeeProfile(id, employeeDTO);
         return employee;
     }
}

