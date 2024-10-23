package com.be.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**			
 * Employee			
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer employeeId;

     @ManyToOne
     @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
     private Role role;

     @ManyToOne
     @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id", nullable = false)
     private Apartment apartment;

     private String userName;
     private String password;
     private String avatar;
     private String fullName;
     private Date dayOfBirth;
     private Character gender;
     private String address;
     private String phoneNumber;
     private String socialSecurityNumber;
     private String email;
     private Date startDate; 
     private BigDecimal salary;
     private String status;
}  
