package com.be.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer
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
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "candidates_id", referencedColumnName = "candidates_id")
    private Candidate candidate;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String avata;

    @Column(name = "full_name")
    private String fullName;

    @Column(nullable = true)
    private String role;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Column(nullable = true)
    private Character gender;

    @Column(nullable = true)
    private String address;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String occupation;

    @Column(nullable = true)
    private String status;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime deleteAt;
}
