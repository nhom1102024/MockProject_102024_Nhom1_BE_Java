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
@Table(name = "UnitMaintenance")
public class UnitMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitMaintenanceId;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "maintenance_id", nullable = false)
    private Maintenance maintenance;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private BigDecimal cost;

    private String status;

    private LocalDateTime deletedAt;
}
