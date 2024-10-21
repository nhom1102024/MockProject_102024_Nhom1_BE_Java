package com.be.model;

import java.time.LocalDateTime;

public record ServiceRequestDTO(Integer serviceRequestId,Customer customer,Employee employee,Service service,LocalDateTime requestDateTime,String description,String status,LocalDateTime completionDateTime,LocalDateTime deleteAt) {

}
