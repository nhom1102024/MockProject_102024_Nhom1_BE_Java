package com.be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.be.model.Candidate;
import com.be.repository.CandidateRepository;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        Page<Candidate> candidatePage = candidateRepository.findAll(pageable);
        return candidatePage.getContent();
    }

    @Override
    public Optional<Candidate> getCandidateByID(Integer candidates_id) throws Exception {
        return candidateRepository.findById(candidates_id);
    }

}
