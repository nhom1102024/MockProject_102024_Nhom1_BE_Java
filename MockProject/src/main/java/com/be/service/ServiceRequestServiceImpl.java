package com.be.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.model.ServiceRequest;
import com.be.repository.ServiceRequestRespository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    private final ServiceRequestRespository serviceRequestRepository;

    @Autowired
    public ServiceRequestServiceImpl(ServiceRequestRespository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @Override
    public List<ServiceRequest> getAllService() {
        return serviceRequestRepository.findAll();  
    }

    @Override
    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    @Override
    public ServiceRequest getServiceRequestById(Integer id) {
        return serviceRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service request not found with id: " + id));
    }

    @Override
    public ServiceRequest updateServiceRequest(Integer id, ServiceRequest updatedServiceRequest) {
        if (!serviceRequestRepository.existsById(id)) {
            throw new EntityNotFoundException("Service request not found with id: " + id);
        }
        updatedServiceRequest.setServiceRequestId(id);
        return serviceRequestRepository.save(updatedServiceRequest);
    }

    @Override
    public void deleteServiceRequest(Integer id) {
        if (!serviceRequestRepository.existsById(id)) {
            throw new RuntimeException("Service request not found with id: " + id);
        }
        serviceRequestRepository.deleteById(id);
    }
}
