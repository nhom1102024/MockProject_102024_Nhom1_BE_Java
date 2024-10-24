package com.be.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Employee
 * 
 * Version: 1.0
 * 
 * Date: 15-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 15-10-2024 thuyhang Create
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
    private Integer employee_id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String avata;

    @Column(name = "full_name", nullable = true)
    private String fullName;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Column(nullable = true)
    private Character gender;

    @Column(nullable = true)
    private String address;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "social_security_number", nullable = true)
    private String socialSecurityNumber;

    @Column(nullable = true)
    private String email;

    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Column(nullable = true)
    private BigDecimal salary;

    @Column(nullable = true)
    private String status;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime deleteAt;
}
