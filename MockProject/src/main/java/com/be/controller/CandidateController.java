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
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<CandidateResponse>> getAllCandidates(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        List<Candidate> candidates = candidateService.getAllCandidates(page, limit);

        List<CandidateResponse> candidateResponses = candidates.stream()
                .map(CandidateResponse::getAllCandidates)
                .collect(Collectors.toList());

        return ResponseEntity.ok(candidateResponses);
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<?> getCandidateById(@PathVariable Integer candidateId) {
        try {
            Optional<Candidate> candidate = candidateService.getCandidateByID(candidateId);
            if (candidate.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        ResponseObject.builder()
                                .code(1)
                                .message("Candidate not found!")
                                .build());
            }

            CandidateResponse candidateResponse = CandidateResponse.getCandidate(candidate.get());
            return ResponseEntity.ok(candidateResponse);
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
