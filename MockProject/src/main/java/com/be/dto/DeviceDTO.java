package com.be.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeviceDTO {
     private String nameDevice;
     private String description;
     private BigDecimal price;
     private Long providerId;
     private Long categoryDeviceId;
}
