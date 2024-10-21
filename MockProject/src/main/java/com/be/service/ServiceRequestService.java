package com.be.service;

import java.util.List;
import java.util.Optional;



import com.be.model.ServiceRequest;

public interface ServiceRequestService {
    List<ServiceRequest> getAllService();
    ServiceRequest createServiceRequest(ServiceRequest serviceRequest);
    

    Optional<ServiceRequest> getServiceRequestById(Integer id);
    
   
    Optional<ServiceRequest> updateServiceRequest(Integer id, ServiceRequest updatedServiceRequest);
    
    
    void deleteServiceRequest(Integer id);
}




