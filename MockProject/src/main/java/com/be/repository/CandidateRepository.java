package com.be.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.be.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    @Query("SELECT c FROM Candidate c WHERE c.deleteAt IS NULL")
    Page<Candidate> findAllActive(Pageable pageable);

    @Query("SELECT c FROM Candidate c WHERE c.candidatesId = :candidatesId AND c.deleteAt IS NULL")
    Optional<Candidate> findAllActiveById(Integer candidatesId);

    @Query("SELECT c FROM Candidate c WHERE (c.fullName LIKE CONCAT('%', :searchString, '%') OR c.candidatePosition LIKE CONCAT('%', :searchString, '%')) AND c.deleteAt IS NULL")
    Page<Candidate> searchCandidates(String searchString, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Candidate c WHERE c.deleteAt IS NULL")
    int countCandidate(String searchString);
    
    @Query("SELECT COUNT(c) FROM Candidate c WHERE (c.fullName LIKE CONCAT('%', :searchString, '%') OR c.candidatePosition LIKE CONCAT('%', :searchString, '%')) AND c.deleteAt IS NULL")
    int countBySearchString(String searchString);
}
