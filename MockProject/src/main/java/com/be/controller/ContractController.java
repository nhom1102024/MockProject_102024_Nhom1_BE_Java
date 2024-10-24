package com.be.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.model.Contract;
import com.be.repository.ContractRepository;

/**			
 * ContractController			
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
 * 24-10-2024         Thanh Hai            Create			
 */
@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    /**
     * Create a new contract
     * @param contract
     * @return Contract
     */
    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

    /**
     * Get all contracts
     * @return List of Contract
     */
    @GetMapping
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    /**
     * Get a contract by ID
     * @param id
     * @return ResponseEntity<Contract>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        return contract.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update a contract
     * @param id
     * @param contractDetails
     * @return ResponseEntity<Contract>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract contractDetails) {
        Optional<Contract> contract = contractRepository.findById(id);
        if (contract.isPresent()) {
            Contract updatedContract = contract.get();
            updatedContract.setTenantName(contractDetails.getTenantName());
            updatedContract.setApartmentNumber(contractDetails.getApartmentNumber());
            updatedContract.setStartDate(contractDetails.getStartDate());
            updatedContract.setEndDate(contractDetails.getEndDate());
            contractRepository.save(updatedContract);
            return ResponseEntity.ok(updatedContract);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a contract by ID
     * @param id
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
