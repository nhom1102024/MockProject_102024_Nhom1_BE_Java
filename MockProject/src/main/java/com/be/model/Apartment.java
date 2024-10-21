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
    private String apartmentName; // Corrected the spelling here

    private String location;

    @Column(name = "build_year")
    private Integer buildYear;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @Column(name = "number_of_units")
    private Integer numberOfUnits;

    private String status;

    @Column(name = "delete_at")
    private Date deleteAt; // Ensure the type matches the database column type
}
