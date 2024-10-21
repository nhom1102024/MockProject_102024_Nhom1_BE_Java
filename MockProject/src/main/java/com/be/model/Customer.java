package com.be.model;

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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false) // Ensure unit is required
    private Unit unit; // Ensure Unit class is defined

    @ManyToOne
    @JoinColumn(name = "candidates_id", referencedColumnName = "candidates_id", nullable = false) // Ensure candidates is required
    private Candidates candidates; // Ensure Candidates class is defined

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "role")
    private String role;

    @Column(name = "date_of_birth")
    private Date dateOfBirth; // Consider changing to LocalDate for better handling

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // Consider using LocalDateTime for better date handling
}
