package com.be.model;

import java.math.BigDecimal;
import java.sql.Date; // Consider using java.time.LocalDate for better date handling
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
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id") // Maps to the database column
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false) // Ensure Role entity has role_id field
    private Role role;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id", nullable = false) // Ensure Apartment entity has apartment_id field
    private Apartment apartment;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dayOfBirth; // Consider changing to LocalDate for better handling

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "start_date") // Corrected from 'starDate' to 'startDate'
    private Date startDate; // Consider changing to LocalDate for better handling

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted_at")
    private LocalDateTime deleteAt; // Consider using LocalDateTime for better date handling
}
