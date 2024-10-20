package com.be.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {
    
}
