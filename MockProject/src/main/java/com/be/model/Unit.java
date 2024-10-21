package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer unitId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id", nullable = false) // Added nullable = false to enforce foreign key constraint
    private Apartment apartment; // Ensure the Apartment class is defined correctly

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "area")
    private Integer area;

    @Column(name = "bedrooms") // Corrected field name to match database
    private Integer bedrooms; // Updated to match "bedrooms" in the table

    @Column(name = "bathrooms") // Corrected field name to match database
    private Integer bathrooms; // Updated to match "bathrooms" in the table

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt; // Ensure the type matches the database column type
}
