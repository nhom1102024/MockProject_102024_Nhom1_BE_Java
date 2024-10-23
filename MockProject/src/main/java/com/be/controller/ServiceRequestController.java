package com.be.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.be.dto.ServiceRequestResponseDTO; // Đảm bảo import DTO
import com.be.service.ServiceRequestService;

@RestController
@RequestMapping("/api/requests")
public class ServiceRequestController {

    @Autowired
    private final ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequestResponseDTO>> getAllService() {
        List<ServiceRequestResponseDTO> serviceRequests = serviceRequestService.getAllService();
        return new ResponseEntity<>(serviceRequests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestResponseDTO> getServiceRequestById(@PathVariable Integer id) {
        Optional<ServiceRequestResponseDTO> serviceRequest = serviceRequestService.getServiceRequestById(id);
        return serviceRequest.map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ServiceRequestResponseDTO> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequestResponseDTO createdRequest = serviceRequestService.createServiceRequest(serviceRequest);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequestResponseDTO> updateServiceRequest(@PathVariable Integer id, 
                                                                         @RequestBody ServiceRequest updatedServiceRequest) {
        Optional<ServiceRequestResponseDTO> updatedRequest = serviceRequestService.updateServiceRequest(id, updatedServiceRequest);
        return updatedRequest.map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable Integer id) {
        serviceRequestService.deleteServiceRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
