package com.be.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseDto{
    private Integer incomeId;
    private Integer employeeId;
    private Integer incomeTypeId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime receivedDateTime;




}
