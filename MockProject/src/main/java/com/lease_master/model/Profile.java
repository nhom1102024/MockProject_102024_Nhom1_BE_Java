package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private String profileCategory;

    private String fileName;

    private String link;

    private LocalDateTime deletedAt;

    private String issuedBy;

    private LocalDate issuedDate;

    private LocalDate contractStartDate;

    private LocalDate contractEndDate;
}
