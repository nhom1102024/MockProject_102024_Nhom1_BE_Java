package com.be.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDateTime;

import com.be.dto.customer.RequestMaintenanceDTO;
import com.be.model.Customer;
import com.be.model.Report;
import com.be.repository.CustomerRepository;
import com.be.repository.ReportRepository;

/**
 * RequestMaintenanceService
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
@Service
public class RequestMaintenanceService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * request a maintenance
     * 
     * @param customerId
     * @param requestMaintenanceDTO
     */
    public void createMaintenanceRequest(Integer customerId, RequestMaintenanceDTO requestMaintenanceDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Report newReport = new Report();
        newReport.setCustomer(customer);
        newReport.setTitle(requestMaintenanceDTO.getNameMaintenance());
        newReport.setInformation(requestMaintenanceDTO.getDescription());
        newReport.setFileLinkReport(requestMaintenanceDTO.getFileLinkReport());
        newReport.setCreatedDateTime(LocalDateTime.now());
        newReport.setStatus("open");
        reportRepository.save(newReport);
    }
}
