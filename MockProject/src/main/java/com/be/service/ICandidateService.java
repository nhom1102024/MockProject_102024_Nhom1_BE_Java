package com.be.service;

import java.util.List;
import java.util.Optional;

import com.be.dto.CandidateStatusDTO;
import com.be.model.Candidate;
import com.be.response.CandidateResponse;

public interface ICandidateService {
    Optional<Candidate> getCandidateByID(Integer candidates_id) throws Exception;

    List<Candidate> searchCandidates(String query, Integer page, Integer limit);

    CandidateResponse updateCandidateStatus(Integer candidates_id, CandidateStatusDTO candidateStatusDTO) throws Exception;
}
