package com.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
}
