package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Service")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    private String serviceName;

    private String description;

    private String serviceType;

    private BigDecimal price;

    private String duration;

    private String contactInformation;

    private String scopeOfServices;

    private String qualityStandards;

    private String implementationSchedule;

    private String status;

    private LocalDateTime deletedAt;
}
