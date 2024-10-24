package com.be.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.be.dto.candidate.CandidateStatusDTO;
import com.be.dto.candidate.CandidateUpdateDTO;
import com.be.model.Candidate;
import com.be.response.CandidateResponse;
import com.be.response.ResponseObject;
import com.be.service.candidate.CandidateService;

/**
 * CandidateController
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
 */
@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    /**
     * get all candidates in table candidates
     *
     * @param searchString
     * @param page
     * @param limit
     * @return ResponseObject
     */
    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllCandidate(
            @RequestParam(required = false) String searchString,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        List<Candidate> candidates = candidateService.getAllCandidates(searchString, page, limit);
        int totalCandidates = candidateService.getTotalCandidates(searchString);
        List<CandidateResponse> candidateResponses = candidates.stream()
                .map(CandidateResponse::getAllCandidates)
                .collect(Collectors.toList());

        Map<String, Object> pagination = new HashMap<>();
        pagination.put("page", page);
        pagination.put("limit", limit);
        pagination.put("total", totalCandidates);

        return ResponseEntity.ok().body(
                ResponseObject.builder()
                        .status(200)
                        .message("Success")
                        .data(Map.of("candidates", candidateResponses, "pagination",
                                pagination))
                        .build());
    }

    /**
     * get candidate by candidatesId
     *
     * @param candidateId
     * @return ResponseObject
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
     * update candidate status to "processed"
     *
     * @param candidateId
     * @param candidateStatusDTO
     * @param bindingResult
     * @return ResponseObject
     */
    @PostMapping("/{candidateId}/status")
    public ResponseEntity<ResponseObject> updateCandidateStatus(
            @PathVariable Integer candidateId,
            @RequestBody @Valid CandidateStatusDTO candidateStatusDTO,
            BindingResult bindingResult) {
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
     * @param candidateId
     * @param candidateUpdateDTO
     * @param bindingResult
     * @return ResponseObject
     */
    @PutMapping("/{candidateId}")
    public ResponseEntity<ResponseObject> updateCandidate(
            @PathVariable Integer candidateId,
            @RequestBody @Valid CandidateUpdateDTO candidateUpdateDTO,
            BindingResult bindingResult) {
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

    /**
     * delete candidate
     *
     * @param candidateId
     * @return ResponseObject
     */
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
