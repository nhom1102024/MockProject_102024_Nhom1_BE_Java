package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Unit
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
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer unitId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id")
    private Apartment apartment;

    @Column(name = "room_number")
    private String roomNumber;

    private Integer floor;
    private Integer area;

    @Column(name = "bed_rooms")
    private Integer bedRooms;

    @Column(name = "bath_rooms")
    private Integer bathRooms;

    @Column(nullable = true)
    private String status;

    private BigDecimal price;
    private String description;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime deleteAt;
}
