package com.be.service.candidate;

import java.util.Optional;

import com.be.dto.candidate.CandidateStatusDTO;
import com.be.dto.candidate.CandidateUpdateDTO;
import com.be.model.Candidate;

public interface ICandidateService {
    Optional<Candidate> getCandidateByID(Integer candidatesId);

    void updateCandidateStatus(Integer candidatesId, CandidateStatusDTO candidateStatusDTO);

    void updateCandidate(Integer candidatesId, CandidateUpdateDTO candidateUpdateDTO);
}
