package com.be.service;

import java.util.List;
import java.util.Optional;


import com.be.model.Bill;
import com.be.model.Customer;
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

    public BillService(BillRepository billRepository, PaymentHistoryRepository paymentHistoryRepository, CustomerRepository customerRepository, ServiceRepository serviceRepository) {
        this.billRepository = billRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    public List<Bill> getAllBills () {
        return this.billRepository.findAll();
    }

    public void deleteABill(int id) {
       Optional <Bill> optionalBill = this.billRepository.findById(id);
       if(optionalBill.isPresent()) {
        Bill bill = optionalBill.get();
        List<PaymentHistory> paymentHistories = bill.getPaymentHistories();
        if (paymentHistories != null) {
            for(PaymentHistory paymentHistory : paymentHistories) {
                this.paymentHistoryRepository.deleteById(paymentHistory.getPaymentHistory_id());
            }  
        }
        this.billRepository.deleteById(id);
       }
    }

    public Optional <Bill> getABill(int id) {
        return this.billRepository.findById(id);
    }

    public Bill handleSaveBill(Bill bill) {
        return this.billRepository.save(bill);
    }

    public Optional<Customer> getACustomer(int id) {
        return this.customerRepository.findById(id);
    }

    public Optional<Service> getAService(int id) {
        return this.serviceRepository.findById(id);
    }

    public Service getServiceByName(String name) {
        return this.serviceRepository.findByNameService(name);
    }

    public Customer getCustomerByName(String name) {
        return this.customerRepository.findByFullName(name);
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public List<Service> getAllServices() {
        return this.serviceRepository.findAll();
    }
}
