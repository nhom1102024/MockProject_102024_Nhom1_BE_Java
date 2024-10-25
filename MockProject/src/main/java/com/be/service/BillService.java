package com.be.service;

import java.util.List;
import java.util.Optional;

import com.be.model.Bill;
import com.be.model.Customer;
import com.be.model.CustomerEntity;
import com.be.model.PaymentHistory;
import com.be.model.Service;
import com.be.repository.BillRepository;
import com.be.repository.CustomerRepository;
import com.be.repository.PaymentHistoryRepository;
import com.be.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class BillService {

    private final BillRepository billRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;

    public BillService(BillRepository billRepository, PaymentHistoryRepository paymentHistoryRepository,
            CustomerRepository customerRepository, ServiceRepository serviceRepository) {
        this.billRepository = billRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    // Retrieves a list of all bills
    public List<Bill> getAllBills() {
        return this.billRepository.findAll();
    }

    // Deletes a bill by its ID and also removes associated payment histories
    public void deleteABill(int id) {
        Optional<Bill> optionalBill = this.billRepository.findById(id);
        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            List<PaymentHistory> paymentHistories = bill.getPaymentHistories();
            if (paymentHistories != null) {
                for (PaymentHistory paymentHistory : paymentHistories) {
                    this.paymentHistoryRepository.deleteById(paymentHistory.getPaymentHistory_id());
                }
            }
            this.billRepository.deleteById(id);
        }
    }

    // Fetches a specific bill by its ID
    public Optional<Bill> getABill(int id) {
        return this.billRepository.findById(id);
    }

    // Saves or updates a bill in the database
    public Bill handleSaveBill(Bill bill) {
        return this.billRepository.save(bill);
    }

    // Retrieves a specific customer by their ID
    public Optional<CustomerEntity> getACustomer(int id) {
        return this.customerRepository.findById(id);
    }

    // Retrieves a specific service by its ID
    public Optional<Service> getAService(int id) {
        return this.serviceRepository.findById(id);
    }

    // Fetches a service by its name
    public Service getServiceByName(String name) {
        return this.serviceRepository.findByNameService(name);
    }

    // Fetches a customer by their full name
    public CustomerEntity getCustomerByName(String name) {
        return this.customerRepository.findByFullName(name);
    }

    // Retrieves a list of all customers
    public List<CustomerEntity> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    // Retrieves a list of all services
    public List<Service> getAllServices() {
        return this.serviceRepository.findAll();
    }
}
