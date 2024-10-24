package com.be.service;

import java.util.List;


import com.be.model.ServiceRequest;

public interface ServiceRequestService {
    List<ServiceRequest> getAllService();
    ServiceRequest createServiceRequest(ServiceRequest serviceRequest);
    ServiceRequest getServiceRequestById(Integer id); 
    ServiceRequest updateServiceRequest(Integer id, ServiceRequest updatedServiceRequest); 
    void deleteServiceRequest(Integer id);
}
