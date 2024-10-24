package com.lease_master.service.contract.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ContractSearchDTO {
    private String serviceName;

    private String customerName;

    private String roomNumber;

    private LocalDate startDate;

    private LocalDate endDate;

    private String contractTerms;

    private String specialTerms;

    private BigDecimal amount;

    private String status;
}
