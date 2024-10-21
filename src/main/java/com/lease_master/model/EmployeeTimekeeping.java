package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EmployeeTimekeeping")
public class EmployeeTimekeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeTimekeepingId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "timekeeping_id", nullable = false)
    private Timekeeping timekeeping;

    private LocalDateTime checkinTime;

    private LocalDateTime checkoutTime;

    private String image;

    private Integer overtimeHours;

    private String status;
}
