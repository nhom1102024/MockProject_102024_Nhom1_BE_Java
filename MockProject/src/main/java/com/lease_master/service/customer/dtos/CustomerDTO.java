package com.lease_master.service.customer.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private Long customerId;

    private String fullName;

    private String avatar;

    private Date dateOfBirth;

    private Character gender;

    private String address;

    private String phoneNumber;

    private String occupation;

    private String email;

    private String status;
}
