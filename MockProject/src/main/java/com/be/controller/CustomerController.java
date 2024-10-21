package com.be.controller;

import com.be.dto.customer.RequestMaintenanceDTO;
import com.be.response.ResponseObject;
import com.be.service.customer.RequestMaintenance;
import jakarta.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private RequestMaintenance requestMaintenance;

    @PostMapping("{customerId}/maintenances")
    public ResponseEntity<ResponseObject> requestMaintenance(
            @PathVariable Integer customerId,
            @RequestParam @NotBlank(message = "nameMaintenance must not be blank") String nameMaintenance,
            @RequestParam @NotBlank(message = "description must not be blank") String description,
            @RequestParam MultipartFile fileLinkReport) {
        try {
            RequestMaintenanceDTO requestMaintenanceDTO = new RequestMaintenanceDTO(nameMaintenance, description,
                    fileLinkReport);
            requestMaintenance.createMaintenanceRequest(customerId, requestMaintenanceDTO);
            return ResponseEntity.ok().body(
                    ResponseObject.builder()
                            .status(201)
                            .message("Success")
                            .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseObject.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build());
        }
    }
}
