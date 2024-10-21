package com.lease_master.service.contract;

import com.lease_master.mapper.ContractMapper;
import com.lease_master.mapper.UnitMapper;
import com.lease_master.model.Contract;
import com.lease_master.model.Unit;
import com.lease_master.repository.ContractRepository;
import com.lease_master.service.contract.dtos.ContractListDTO;
import com.lease_master.service.contract.dtos.ContractSearchDTO;
import com.lease_master.service.unit.dtos.UnitDTO;
import com.lease_master.service.unit.dtos.UnitSearchDTO;
import com.lease_master.specification.ContractSpecification;
import com.lease_master.specification.UnitSpecification;
import org.springframework.data.jpa.domain.Specification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing contracts.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;

    /**
     * Saves a new contract or updates an existing one.
     *
     * @param contract the contract to save or update
     * @return the saved or updated contract
     */
    public Contract save(Contract contract) {
        log.info("Saving contract: {}", contract);

        // Ensure deletedAt is set to null when creating a new contract
        if (contract.getContractId() == null) {
            contract.setDeletedAt(null);
        }

        return contractRepository.save(contract);
    }

    /**
     * Finds a contract by ID.
     *
     * @param id the ID of the contract
     * @return an optional containing the contract if found, otherwise empty
     */
    public Optional<Contract> findById(Long id) {
        log.info("Fetching contract with id: {}", id);
        return contractRepository.findById(id);
    }

    /**
     * Retrieves all contracts that are not softly deleted.
     *
     * @return a list of contracts
     */
    public List<Contract> findAll() {
        log.info("Fetching all contracts");
        return contractRepository.findAll();
    }

    /**
     * Soft deletes a contract by setting the deletedAt field to the current time.
     *
     * @param id the ID of the contract to softly delete
     */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting contract with id: {}", id);
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("contract with id {} not found", id);
                    return new RuntimeException("contract not found");
                });
        contract.setDeletedAt(LocalDateTime.now());
        contractRepository.save(contract);
        log.info("contract with id {} soft deleted successfully", id);
    }

    /**
     * Checks if a contract exists by ID.
     *
     * @param id the ID of the contract
     * @return true if the contract exists, false otherwise
     */
    public boolean existsById(Long id) {
        log.info("Checking existence of contract with id: {}", id);
        return contractRepository.existsById(id);
    }

    /**
     * Searches for contracts based on given criteria.
     *
     * @param searchDTO the DTO containing search criteria
     * @param pageable pagination information
     * @return a page of ContractListDTOs matching the criteria
     */
    public Page<ContractListDTO> search(ContractSearchDTO searchDTO, Pageable pageable) {
        log.info("Searching units with filters: {}, Pagination info - page: {}, size: {}", searchDTO, pageable.getPageNumber(), pageable.getPageSize());
        Specification<Contract> spec = ContractSpecification.search(searchDTO);
        Page<Contract> contractsPage = contractRepository.findAll(spec, pageable);
        return contractsPage.map(ContractMapper.INSTANCE::convertToContractListDto);
    }
}