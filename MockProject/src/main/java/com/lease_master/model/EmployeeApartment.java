package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EmployeeApartment")
public class EmployeeApartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeApartmentId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    private String role;

    private LocalDate startDate;

    private BigDecimal salary;

    private String status;

    private LocalDateTime deletedAt;
}
