package com.lease_master.service.contract.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContractDTO {
    private Long contractId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String contractTerms;

    private String specialTerms;

    private BigDecimal amount;

    private String status;
}