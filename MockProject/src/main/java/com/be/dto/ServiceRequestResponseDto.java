package com.be.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceRequestResponseDto {
    private Integer serviceRequestId;
    private Integer customerId; 
    private Integer employeeId; 
    private Integer serviceId;
    private LocalDateTime requestDateTime;
    private String description;
    private String status;
    private LocalDateTime completionDateTime;
}

