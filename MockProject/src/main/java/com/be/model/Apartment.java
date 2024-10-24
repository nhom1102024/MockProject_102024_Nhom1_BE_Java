package com.be.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Apartment
 * 
 * Version: 1.0
 * 
 * Date: 21-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 21-10-2024 thuyhang Create
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

    @Column(name = "apartment_name")
    private String apartmentName;

    private String location;

    @Column(name = "build_year")
    private Integer buildYear;

    @Column(name = "number_of_floor")
    private Integer numberOfFloor;

    @Column(name = "number_of_unit")
    private Integer numberOfUnit;

    @Column(nullable = true)
    private String status;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime deleteAt;
}
