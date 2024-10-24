package com.be.controller;

import com.be.model.Complaint;
import com.be.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**			
 * ComplaintController			
 *			
 * Version 1.0			
 *			
 * Date: 24-10-2024			
 *			
 * Copyright 			
 *			
 * Modification Logs:			
 * DATE                 AUTHOR          DESCRIPTION			
 * -----------------------------------------------------------------------			
 * 24-10-2024         ThanhHai            Create			
 */
@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    /**
     * Create a new complaint
     * @param complaint
     * @return Complaint
     */
    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    /**
     * Get all complaints
     * @return List of Complaint
     */
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    /**
     * Get a complaint by ID
     * @param id
     * @return ResponseEntity<Complaint>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        Optional<Complaint> complaint = complaintRepository.findById(id);
        return complaint.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update a complaint
     * @param id
     * @param complaintDetails
     * @return ResponseEntity<Complaint>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable Long id, @RequestBody Complaint complaintDetails) {
        Optional<Complaint> complaint = complaintRepository.findById(id);
        if (complaint.isPresent()) {
            Complaint updatedComplaint = complaint.get();
            updatedComplaint.setCustomerName(complaintDetails.getCustomerName());
            updatedComplaint.setComplaintType(complaintDetails.getComplaintType());
            updatedComplaint.setDateSubmitted(complaintDetails.getDateSubmitted());
            updatedComplaint.setAddress(complaintDetails.getAddress());
            updatedComplaint.setStatus(complaintDetails.getStatus());
            complaintRepository.save(updatedComplaint);
            return ResponseEntity.ok(updatedComplaint);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a complaint by ID
     * @param id
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
