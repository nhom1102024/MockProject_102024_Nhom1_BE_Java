package com.be.controller;

import com.be.model.Payment;
import com.be.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // API View Payment History
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Payment>> viewPaymentHistory(@PathVariable Long customerId) {
        List<Payment> paymentHistory = paymentService.getPaymentHistory(customerId);
        if (!paymentHistory.isEmpty()) {
            return ResponseEntity.ok(paymentHistory);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}
