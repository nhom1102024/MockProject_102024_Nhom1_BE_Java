package com.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    public List<Bill> findAll();
   
}
