package com.lease_master.service.service.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceDTO {
    private Long serviceId;

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
}
