package com.lease_master.controller;

import com.lease_master.service.contract.ContractService;
import com.lease_master.model.Contract;
import com.lease_master.service.contract.dtos.ContractListDTO;
import com.lease_master.service.contract.dtos.ContractSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    @Operation(tags = "Contract", description = "Get all contracts")
    public ResponseEntity<List<Contract>> getAllContracts() {
        List<Contract> contracts = contractService.findAll();
        return ResponseEntity.ok(contracts);
    }

    @PostMapping("/contracts/search")
    @Operation(tags = "Contract", description = "Search contracts")
    public Page<ContractListDTO> searchContracts(
            @ModelAttribute ContractSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return contractService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    @Operation(tags = "Contract", description = "Get contract by ID")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = contractService.findById(id);
        return contract.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(tags = "Contract", description = "Create new contract")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        Contract savedContract = contractService.save(contract);
        return ResponseEntity.ok(savedContract);
    }

    @PutMapping("/{id}")
    @Operation(tags = "Contract", description = "Update contract by ID")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        if (!contractService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Contract updatedContract = contractService.save(contract);
        return ResponseEntity.ok(updatedContract);
    }

    @DeleteMapping("/{id}")
    @Operation(tags = "Contract", description = "Soft delete contract by ID")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        if (!contractService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contractService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
