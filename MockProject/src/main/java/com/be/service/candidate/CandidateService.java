package com.be.service.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.be.dto.candidate.CandidateStatusDTO;
import com.be.dto.candidate.CandidateUpdateDTO;
import com.be.model.Candidate;
import com.be.repository.CandidateRepository;

/**
 * CandidateService
 * 
 * Version: 1.0
 * 
 * Date: 15-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 15-10-2024 thuyhang Create
 */
@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    /**
     * get all candidates in table candidates
     * 
     * @param searchString
     * @param page
     * @param limit
     * @return List<Candidate>
     */
    public List<Candidate> getAllCandidates(String searchString, Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        Page<Candidate> candidatePage;
        if (searchString == null || searchString.isBlank()) {
            candidatePage = candidateRepository.findAllActive(pageable);
        } else {
            candidatePage = candidateRepository.searchCandidates(searchString, pageable);
        }
        return candidatePage.getContent();
    }

    /**
     * get total of candidates
     * 
     * @param searchString
     * @return total
     */
    public int getTotalCandidates(String searchString) {
        if (searchString != null && !searchString.isBlank()) {
            return candidateRepository.countBySearchString(searchString);
        }
        return candidateRepository.countCandidate(searchString);
    }

    /**
     * get candidate by candidatesId
     * 
     * @param candidatesId
     * @return Optional<Candidate>
     */
    @Override
    public Optional<Candidate> getCandidateByID(Integer candidatesId) {
        return candidateRepository.findAllActiveById(candidatesId);
    }

    /**
     * update candidate status to "processed"
     * 
     * @param candidatesId
     * @param candidateStatusDTO
     */
    @Override
    public void updateCandidateStatus(Integer candidatesId, CandidateStatusDTO candidateStatusDTO) {
        Candidate candidate = candidateRepository.findById(candidatesId).get();
        candidate.setStatus(candidateStatusDTO.getStatus());
        candidateRepository.save(candidate);
    }

    /**
     * update candidate at candidatesId
     * 
     * @param candidatesId
     * @param candidateStatusDTO
     */
    @Override
    public void updateCandidate(Integer candidatesId, CandidateUpdateDTO candidateUpdateDTO) {
        Candidate candidate = candidateRepository.findById(candidatesId).get();

        String[] dob = candidateUpdateDTO.getDateOfBirth().split("/");
        String dateFormat = String.format("%s-%s-%s", dob[2], dob[1], dob[0]);
        candidate.setDateOfBirth(Date.valueOf(dateFormat));

        candidate.setFullName(candidateUpdateDTO.getFullName());
        candidate.setGender(candidateUpdateDTO.getGender().charAt(0));
        candidate.setPhoneNumber(candidateUpdateDTO.getPhoneNumber());
        candidate.setEmail(candidateUpdateDTO.getEmail());
        candidate.setIdentifier(candidateUpdateDTO.getIdentifier());
        candidate.setAddress(candidateUpdateDTO.getAddress());
        candidate.setWorkExperience(candidateUpdateDTO.getWorkExperience());
        candidate.setEducationalStatus(candidateUpdateDTO.getFullName());
        candidateRepository.save(candidate);
    }

    /**
     * soft delete candidate at candidatesId
     * 
     * @param candidatesId
     */
    public void softDeteleCandidate(Integer candidatesId) {
        Candidate candidate = candidateRepository.findById(candidatesId).get();
        candidate.setDeleteAt(LocalDateTime.now());
        candidateRepository.save(candidate);
    }
}
