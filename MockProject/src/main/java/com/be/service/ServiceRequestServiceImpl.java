package com.be.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.model.ServiceRequest;
import com.be.repository.ServiceRequestRespository;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private final ServiceRequestRespository serviceRequestRepository;

    
    public ServiceRequestServiceImpl(ServiceRequestRespository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @Override
    public List<ServiceRequest> getAllService() {
        return serviceRequestRepository.findAll();
    }
    @Override
    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest); // Sử dụng instance để gọi phương thức save
    }

    @Override
    public Optional<ServiceRequest> getServiceRequestById(Integer id) {
        return serviceRequestRepository.findById(id);
    }

    @Override
    public Optional<ServiceRequest> updateServiceRequest(Integer id, ServiceRequest updatedServiceRequest) {
        if (serviceRequestRepository.existsById(id)) {
            updatedServiceRequest.setServiceRequestId(id); // Set ID cho đối tượng mới
            return Optional.of(serviceRequestRepository.save(updatedServiceRequest));
        }
        return Optional.empty();
    }

    @Override
    public void deleteServiceRequest(Integer id) {
        serviceRequestRepository.deleteById(id);
    }
}
