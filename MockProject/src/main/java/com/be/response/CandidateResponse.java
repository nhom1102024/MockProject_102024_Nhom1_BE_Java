package com.be.response;

import com.be.model.Candidate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateResponse {
    private Integer candidates_id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String nameCandidates;
    private String status;

    public static CandidateResponse getCandidate(Candidate candidate) {
        return CandidateResponse.builder()
                .candidates_id(candidate.getCandidates_id())
                .fullName(candidate.getFullName())
                .email(candidate.getEmail())
                .phoneNumber(candidate.getPhoneNumber())
                .nameCandidates(candidate.getNameCandidates())
                .status(candidate.getStatus())
                .build();
    }
}
