package com.lease_master.service.apartment.dtos;

import lombok.Data;

@Data
public class ApartmentSearchDTO {
    private String apartmentName;

    private String location;

    private Integer buildYear;

    private Integer numberOfFloors;

    private Integer numberOfUnits;

    private String status;
}
