package com.be.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.model.Candidate;
import com.be.response.CandidateResponse;
import com.be.response.ResponseObject;
import com.be.service.CandidateService;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("")
    public ResponseEntity<List<CandidateResponse>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();

        List<CandidateResponse> candidateResponses = candidates.stream()
                .map(CandidateResponse::getCandidate)
                .collect(Collectors.toList());

        return ResponseEntity.ok(candidateResponses);
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<ResponseObject> getCandidateById(@PathVariable Integer candidateId) {
        try {
            Optional<Candidate> candidateResponse = candidateService.getCandidateByID(candidateId);
            if (candidateResponse.isEmpty()) {
                return ResponseEntity.ok(
                    ResponseObject.builder()
                            .code(1)
                            .message("Candidate not found!")
                            .data(candidateResponse)
                            .build());
            }
            return ResponseEntity.ok(
                    ResponseObject.builder()
                            .code(0)
                            .message("Get user successfully")
                            .data(candidateResponse)
                            .build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    ResponseObject.builder()
                            .code(1)
                            .message(e.getMessage())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    ResponseObject.builder()
                            .code(1)
                            .message("An unexpected error occurred.")
                            .build());
        }
    }
}
