package com.be.service;

import java.util.List;
import java.util.Optional;

import com.be.dto.CandidateStatusDTO;
import com.be.dto.CandidateUpdateDTO;
import com.be.model.Candidate;

public interface ICandidateService {
    Optional<Candidate> getCandidateByID(Integer candidatesId);

    List<Candidate> searchCandidates(String query, Integer page, Integer limit);

    void updateCandidateStatus(Integer candidatesId, CandidateStatusDTO candidateStatusDTO);

    void updateCandidate(Integer candidatesId, CandidateUpdateDTO candidateUpdateDTO);
}
