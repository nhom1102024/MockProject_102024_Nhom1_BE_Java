package com.be.dto.customer;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMaintenanceDTO {
    private String nameMaintenance;
    private String description;
    private MultipartFile fileLinkReport;

    public RequestMaintenanceDTO(String nameMaintenance, String description, MultipartFile fileLinkReport) {
        this.nameMaintenance = nameMaintenance;
        this.description = description;
        this.fileLinkReport = fileLinkReport;
    }
}
