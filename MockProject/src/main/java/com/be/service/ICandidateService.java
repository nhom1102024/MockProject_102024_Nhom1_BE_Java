package com.be.service;

import java.util.Optional;

import com.be.model.Candidate;

public interface ICandidateService {
    Optional<Candidate> getCandidateByID(Integer candidates_id) throws Exception;
}
