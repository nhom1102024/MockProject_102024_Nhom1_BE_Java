package com.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

import com.be.dto.customer.RequestMaintenanceDTO;
import com.be.response.ResponseObject;
import com.be.service.customer.RequestMaintenanceService;

/**
 * CustomerController
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
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private RequestMaintenanceService requestMaintenance;

    /**
     * request a maintenance
     * 
     * @param customerId
     * @param requestMaintenanceDTO
     * @param bindingResult
     * @return ResponseObject
     */
    @PostMapping("{customerId}/maintenances")
    public ResponseEntity<ResponseObject> requestMaintenance(
            @PathVariable Integer customerId,
            @RequestBody @Valid RequestMaintenanceDTO requestMaintenanceDTO,
            BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(
                        ResponseObject.builder()
                                .status(400)
                                .message("Validation error: " + errorMessages)
                                .build());
            }
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
