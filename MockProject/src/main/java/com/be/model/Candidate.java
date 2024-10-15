package com.be.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidates_id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Column(name = "name_candidates", nullable = true)
    private String nameCandidates;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String identifier;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String status;

    @Column(name = "full_name", nullable = true)
    private String fullName;

    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Column(nullable = true)
    private Character gender;

    @Column(nullable = true)
    private String address;

    @Column(name = "work_experience", nullable = true)
    private String workExperience;

    @Column(name = "educational_status", nullable = true)
    private String educationalStatus;

    @Column(name = "delete_at", nullable = true)
    private LocalDateTime deleteAt;
}
