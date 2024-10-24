package com.be.controller;

import com.be.dto.ServiceRequestResponseDto;
import com.be.model.ServiceRequest;
import com.be.service.ServiceRequestService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @PostMapping
    public ResponseEntity<ServiceRequestResponseDto> createServiceRequest(@Valid @RequestBody ServiceRequest serviceRequest) {
        ServiceRequest createdServiceRequest = serviceRequestService.createServiceRequest(serviceRequest);
    
        ServiceRequestResponseDto createdRequest = createResponseDto(createdServiceRequest);
        
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<ServiceRequestResponseDto>> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests = serviceRequestService.getAllService();
        List<ServiceRequestResponseDto> responseDtos = serviceRequests.stream()
                .map(this::createResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestResponseDto> getServiceRequestById(@PathVariable Integer id) {
        try {
            ServiceRequest serviceRequest = serviceRequestService.getServiceRequestById(id);
            ServiceRequestResponseDto responseDto = createResponseDto(serviceRequest);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequestResponseDto> updateServiceRequest(@PathVariable Integer id, 
                                                                         @Valid @RequestBody ServiceRequest updatedServiceRequest) {
        try {
            ServiceRequest updatedRequest = serviceRequestService.updateServiceRequest(id, updatedServiceRequest);
            ServiceRequestResponseDto responseDto = createResponseDto(updatedRequest);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable Integer id) {
        serviceRequestService.deleteServiceRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private ServiceRequestResponseDto createResponseDto(ServiceRequest serviceRequest) {
        Integer customerId = (serviceRequest.getCustomer() != null) ? serviceRequest.getCustomer().getCustomerId() : null;
        Integer employeeId = (serviceRequest.getEmployee() != null) ? serviceRequest.getEmployee().getEmployee_id() : null;
        Integer serviceId = (serviceRequest.getService() != null) ? serviceRequest.getService().getServiceId() : null;

        return new ServiceRequestResponseDto(
            serviceRequest.getServiceRequestId(),
            customerId,
            employeeId,
            serviceId,
            serviceRequest.getRequestDateTime(),
            serviceRequest.getDescription(),
            serviceRequest.getStatus(),
            serviceRequest.getCompletionDateTime()
        );
    }
}
