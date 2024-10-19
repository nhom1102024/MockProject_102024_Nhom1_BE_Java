package com.be.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.be.dto.CandidateStatusDTO;
import com.be.dto.CandidateUpdateDTO;
import com.be.model.Candidate;
import com.be.response.CandidateResponse;
import com.be.response.ResponseObject;
import com.be.service.CandidateService;

/**
 * CandidateController
 * <p>
 * Version: 1.0
 * <p>
 * Date: 15-10-2024
 * <p>
 * Copyright
 * <p>
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 15-10-2024 thuyhang Create
 */
@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    /**
     * get all candidates in table candidates
     *
     * @param page
     * @param limit
     * @return candidateResponses
     */
    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllCandidate(@RequestParam(defaultValue = "1") int page,
                                                          @RequestParam(defaultValue = "10") int limit) {
        List<Candidate> candidates = candidateService.getAllCandidates(page, limit);
        List<CandidateResponse> candidateResponses = candidates.stream()
                .map(CandidateResponse::getAllCandidates)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .status(200)
                        .message("Success")
                        .data(candidateResponses)
                        .build());
    }

    /**
     * get candidate by candidatesId
     *
     * @param candidateId
     * @return candidateResponse
     */
    @GetMapping("/{candidateId}")
    public ResponseEntity<ResponseObject> getCandidateById(@PathVariable Integer candidateId) {
        try {
            Optional<Candidate> candidate = candidateService.getCandidateByID(candidateId);
            CandidateResponse candidateResponse = CandidateResponse.getCandidate(candidate.get());
            return ResponseEntity.ok().body(
                    ResponseObject.builder()
                            .status(200)
                            .message("Success")
                            .data(candidateResponse)
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseObject.builder()
                            .status(404)
                            .message("Candidate not found!")
                            .build());
        }
    }

    /**
     * search candidates by nameCandidates or candidatePosition
     *
     * @param query
     * @param page
     * @param limit
     * @return candidateResponses
     */
    @GetMapping("/search")
    public ResponseEntity<ResponseObject> searchCandidates(@RequestParam String query,
                                                           @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        List<Candidate> candidates = candidateService.searchCandidates(query, page, limit);
        List<CandidateResponse> candidateResponses = candidates.stream()
                .map(CandidateResponse::getAllCandidates)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .status(200)
                        .message("Success")
                        .data(candidateResponses)
                        .build());
    }

    /**
     * update candidate status to "processed"
     *
     * @return CandidateResponse
     */
    @PostMapping("/{candidateId}/status")
    public ResponseEntity<ResponseObject> updateCandidateStatus(@PathVariable Integer candidateId,
                                                                @RequestBody @Valid CandidateStatusDTO candidateStatusDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(
                        ResponseObject.builder()
                                .status(400)
                                .message("Validation error: " + errorMessages)
                                .build());
            }

            candidateService.updateCandidateStatus(candidateId, candidateStatusDTO);
            return ResponseEntity.ok(
                    ResponseObject.builder()
                            .status(200)
                            .message("Success")
                            .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseObject.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build());
        }
    }

    /**
     * update candidate
     *
     * @return CandidateResponse
     */
    @PutMapping("/{candidateId}")
    public ResponseEntity<ResponseObject> updateCandidate(@PathVariable Integer candidateId,
                                                          @RequestBody @Valid CandidateUpdateDTO candidateUpdateDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors().stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(
                        ResponseObject.builder()
                                .status(400)
                                .message("Validation error: " + errorMessages)
                                .build());
            }

            candidateService.updateCandidate(candidateId, candidateUpdateDTO);
            return ResponseEntity.ok(
                    ResponseObject.builder()
                            .status(200)
                            .message("Success")
                            .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseObject.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build());
        }
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<ResponseObject> softDeteleCandidate(@PathVariable Integer candidateId) {
        Optional<Candidate> candidate = candidateService.getCandidateByID(candidateId);
        if (candidate.isPresent()) {
            candidateService.softDeteleCandidate(candidateId);
            return ResponseEntity.ok().body(
                    ResponseObject.builder()
                            .status(200)
                            .message("Success")
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseObject.builder()
                            .status(404)
                            .message("Candidate not found")
                            .build());
        }
    }
}
