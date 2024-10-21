package com.lease_master.service.contract.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ContractListDTO {
    private Long contractId;

    private Long customerId;

    private Long serviceId;

    private String fullName;

    private String avatar;

    private Date dateOfBirth;

    private Character gender;

    private String address;

    private String phoneNumber;

    private String occupation;

    private String email;

    private String status;

    private String serviceName;

    private String description;

    private String serviceType;

    private BigDecimal price;

    private String duration;

    private String contactInformation;

    private String scopeOfServices;

    private String qualityStandards;

    private String implementationSchedule;

    private String customerName;

    private String roomNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    private String contractTerms;

    private String specialTerms;

    private BigDecimal amount;
}
