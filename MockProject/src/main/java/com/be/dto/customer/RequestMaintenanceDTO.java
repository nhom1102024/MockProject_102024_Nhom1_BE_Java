package com.be.dto.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * RequestMaintenanceDTO
 * 
 * Version: 1.0
 * 
 * Date: 21-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 21-10-2024 thuyhang Create
 */
@Getter
@Setter
public class RequestMaintenanceDTO {
    @NotBlank(message = "nameMaintenance must not be blank")
    private String nameMaintenance;

    @NotBlank(message = "description must not be blank")
    private String description;

    @NotBlank(message = "fileLinkReport must not be blank")
    private String fileLinkReport;
}
