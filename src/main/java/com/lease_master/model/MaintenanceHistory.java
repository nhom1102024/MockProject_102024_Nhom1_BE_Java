package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MaintenanceHistory")
public class MaintenanceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceHistoryId;

    @ManyToOne
    @JoinColumn(name = "unit_device_id", nullable = false)
    private UnitDevice unitDevice;

    @ManyToOne
    @JoinColumn(name = "maintenance_id", nullable = false)
    private Maintenance maintenance;

    private String technicianName;

    private String description;

    private String note;

    private BigDecimal cost;

    private String status;

    private LocalDate nextMaintenanceDate;
}
