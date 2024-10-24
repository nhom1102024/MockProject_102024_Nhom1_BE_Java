package com.be.service.service.dtos;

import com.be.model.Provider;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceSearchDTO {
    private Provider providerName;

    private String serviceName;

    private String description;

    private String categoryService;

    private BigDecimal price;

    private String duration;

    private String contactInformation;

    private String scopeOfServices;

    private String qualityStandards;

    private String implementationSchedule;
}
