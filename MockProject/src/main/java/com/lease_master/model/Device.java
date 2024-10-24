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
@Table(name = "Device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "device_type_id", nullable = false)
    private DeviceType deviceType;

    private String nameDevice;

    private String description;

    private BigDecimal price;

    private String warrantyPeriod;

    private LocalDate status;

    private LocalDateTime deletedAt;
}
