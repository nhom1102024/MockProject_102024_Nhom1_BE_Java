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
@Table(name = "UnitDevice")
public class UnitDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitDeviceId;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    private LocalDate installationDate;

    private String location;

    private LocalDate maintenanceDate;

    private LocalDate status;

    private LocalDateTime deletedAt;
}
