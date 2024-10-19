package com.be.response;

import com.be.model.Candidate;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CandidateResponse
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
 * 18-10-2024 thuyhang Update
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateResponse {
    private Integer candidatesId;
    private String fullName;
    private Character gender;
    private String email;
    private String phoneNumber;
    private String nameCandidates;
    private String dateOfBirth;
    private String address;
    private String candidatePosition;
    private String identifier;
    private String workExperience;
    private String educationalStatus;
    private String status;

    public static CandidateResponse getAllCandidates(Candidate candidate) {
        return CandidateResponse.builder()
                .candidatesId(candidate.getCandidatesId())
                .nameCandidates(candidate.getNameCandidates())
                .email(candidate.getEmail())
                .phoneNumber(candidate.getPhoneNumber())
                .candidatePosition(candidate.getCandidatePosition())
                .status(candidate.getStatus())
                .build();
    }

    public static CandidateResponse getCandidate(Candidate candidate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = candidate.getDateOfBirth();

        return CandidateResponse.builder()
                .candidatesId(candidate.getCandidatesId())
                .fullName(candidate.getFullName())
                .gender(candidate.getGender())
                .phoneNumber(candidate.getPhoneNumber())
                .email(candidate.getEmail())
                .identifier(candidate.getIdentifier())
                .dateOfBirth(dateFormat.format(dob))
                .address(candidate.getAddress())
                .workExperience(candidate.getWorkExperience())
                .educationalStatus(candidate.getEducationalStatus())
                .build();
    }
}
