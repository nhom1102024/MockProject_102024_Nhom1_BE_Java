package com.be.model;

import java.sql.Date; // Consider using java.time.LocalDate if possible for better date handling
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
@Table(name = "candidates")
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidates_id")
    private Integer candidatesId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false) // Added nullable = false to enforce foreign key constraint
    private Employee employee; 

    @Column(name = "name_candidates")
    private String nameCandidates;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;
}
