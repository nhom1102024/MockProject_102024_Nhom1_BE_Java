package com.be.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**			
 * Apartment			
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
@Table(name = "apartment")
public class Apartment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "apartment_id")
     private Integer apartmentId;

     private String apartmentName;
     private String location;
     private Integer buildYear;
     private Integer numberOfFloors;
     private Integer numberOfUnits;
     private String status;
     private Date deleteAt;
}
