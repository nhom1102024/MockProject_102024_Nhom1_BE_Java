package com.be.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Income;

public interface IncomeRepository extends JpaRepository<Income,Integer> {

}
