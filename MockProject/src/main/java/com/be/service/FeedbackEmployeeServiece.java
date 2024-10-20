package com.be.service;

import com.be.model.Customer;
import com.be.model.Employee;
import com.be.model.FeedbackEmployee;
import com.be.repository.CustomerRepository;
import com.be.repository.EmployeeRepository;
import com.be.repository.FeedbackEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackEmployeeServiece {

    private final FeedbackEmployeeRepository feedbackEmployeeRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    

    public FeedbackEmployeeServiece(FeedbackEmployeeRepository feedbackEmployeeRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.feedbackEmployeeRepository = feedbackEmployeeRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }


    public List<FeedbackEmployee> getAllFeedbacks() {
        return feedbackEmployeeRepository.findAll();
    }

    public FeedbackEmployee createFeedbacks(FeedbackEmployee feedbackEmployee) {
        // Customer customer = this.customerRepository.findById(feedbackEmployee.getCustomer().getCustomer_id()).get();
        // Employee employee = this.employeeRepository.findById(feedbackEmployee.getEmployee().getEmployee_id()).get();
        // feedbackEmployee.setCustomer(customer);
        // feedbackEmployee.setEmployee(employee);
        return feedbackEmployeeRepository.save(feedbackEmployee);
    }

    // Các method khác như update, delete complaint
}
