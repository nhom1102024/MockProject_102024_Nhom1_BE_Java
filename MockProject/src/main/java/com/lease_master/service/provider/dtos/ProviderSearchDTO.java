package com.lease_master.service.provider.dtos;

import lombok.Data;

@Data
public class ProviderSearchDTO {
    private String providerName;

    private String contactPerson;

    private String phoneNumber;

    private String email;

    private String address;

    private String status;
}
