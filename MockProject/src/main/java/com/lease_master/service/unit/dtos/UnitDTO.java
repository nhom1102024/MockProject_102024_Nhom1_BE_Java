package com.lease_master.service.unit.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UnitDTO {
    private Long unitId;
    private String roomNumber;
    private Integer floor;
    private Integer area;
    private Integer bedRooms;
    private Integer bathRooms;
    private String status;
    private BigDecimal price;
    private String description;
}