package com.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

}
