package com.lease_master.service.provider;

import com.lease_master.model.Provider;
import com.lease_master.repository.ProviderRepository;
import com.lease_master.service.provider.dtos.ProviderSearchDTO;
import com.lease_master.specification.ProviderSpecification;
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
 * Service class for managing providers.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProviderService {
    private final ProviderRepository providerRepository;

    /**
     * Saves a new provider or updates an existing one.
     *
     * @param provider the provider to save or update
     * @return the saved or updated provider
     */
    public Provider save(Provider provider) {
        log.info("Saving provider: {}", provider);

        // Ensure deletedAt is set to null when creating a new provider
        if (provider.getProviderId() == null) {
            provider.setDeletedAt(null);
        }

        return providerRepository.save(provider);
    }

    /**
     * Finds a provider by ID.
     *
     * @param id the ID of the provider
     * @return an optional containing the provider if found, otherwise empty
     */
    public Optional<Provider> findById(Long id) {
        log.info("Fetching provider with id: {}", id);
        return providerRepository.findById(id);
    }

    /**
     * Retrieves all providers that are not softly deleted.
     *
     * @return a list of providers
     */
    public List<Provider> findAll() {
        log.info("Fetching all providers");
        return providerRepository.findAll();
    }

    /**
     * Soft deletes a provider by setting the deletedAt field to the current time.
     *
     * @param id the ID of the provider to softly delete
     */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting provider with id: {}", id);
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("provider with id {} not found", id);
                    return new RuntimeException("provider not found");
                });
        provider.setDeletedAt(LocalDateTime.now());
        providerRepository.save(provider);
        log.info("provider with id {} soft deleted successfully", id);
    }

    /**
     * Checks if a provider exists by ID.
     *
     * @param id the ID of the provider
     * @return true if the provider exists, false otherwise
     */
    public boolean existsById(Long id) {
        log.info("Checking existence of provider with id: {}", id);
        return providerRepository.existsById(id);
    }

    /**
     * Searches for providers based on given criteria.
     *
     * @param searchDTO the DTO containing search criteria
     * @param pageable pagination information
     * @return a page of providers matching the criteria
     */
    public Page<Provider> search(ProviderSearchDTO searchDTO, Pageable pageable) {
        log.info("Searching providers with filters: {}, Pagination info - page: {}, size: {}",
                searchDTO, pageable.getPageNumber(), pageable.getPageSize());
        Specification<Provider> spec = ProviderSpecification.search(searchDTO);
        return providerRepository.findAll(spec, pageable);
    }
}