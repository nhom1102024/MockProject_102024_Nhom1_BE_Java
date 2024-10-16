package com.be.response;

import com.be.model.Candidate;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class CandidateResponse {
    private Integer candidates_id;
    private String fullName;
    private Character gender;
    private String email;
    private String phoneNumber;
    private String nameCandidates;
    private Date dateOfBirth;
    private String address;
    private String identifier;
    private String workExperience;
    private String educationalStatus;
    private String status;

    public static CandidateResponse getAllCandidates(Candidate candidate) {
        return CandidateResponse.builder()
                .candidates_id(candidate.getCandidates_id())
                .fullName(candidate.getFullName())
                .email(candidate.getEmail())
                .phoneNumber(candidate.getPhoneNumber())
                .nameCandidates(candidate.getNameCandidates())
                .status(candidate.getStatus())
                .build();
    }

    public static CandidateResponse getCandidate(Candidate candidate) {
        return CandidateResponse.builder()
        .candidates_id(candidate.getCandidates_id())
        .fullName(candidate.getFullName())
        .gender(candidate.getGender())
        .phoneNumber(candidate.getPhoneNumber())
        .email(candidate.getEmail())
        .identifier(candidate.getIdentifier())
        .dateOfBirth(candidate.getDateOfBirth())
        .address(candidate.getAddress())
        .workExperience(candidate.getWorkExperience())
        .educationalStatus(candidate.getEducationalStatus())
        .build();
    }
}
