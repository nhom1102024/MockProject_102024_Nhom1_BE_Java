package com.be.service;

import com.be.model.Payment;
import com.be.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getPaymentHistory(Long customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }
}
