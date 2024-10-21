package com.be.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.model.ServiceRequest;
import com.be.service.ServiceRequestService;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ServiceRequestController {

    @Autowired
    private final ServiceRequestService serviceRequestService;


   
    public ServiceRequestController(ServiceRequestService serviceRequestService){
        this.serviceRequestService = serviceRequestService;
    }
    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllService() {
        List<ServiceRequest> serviceRequests = serviceRequestService.getAllService();
        return new ResponseEntity<>(serviceRequests, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getServiceRequestById(@PathVariable Integer id) {
        Optional<ServiceRequest> serviceRequest = serviceRequestService.getServiceRequestById(id);
        return serviceRequest.map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable Integer id, 
                                                               @RequestBody ServiceRequest updatedServiceRequest) {
        Optional<ServiceRequest> updatedRequest = serviceRequestService.updateServiceRequest(id, updatedServiceRequest);
        return updatedRequest.map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable Integer id) {
        serviceRequestService.deleteServiceRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
