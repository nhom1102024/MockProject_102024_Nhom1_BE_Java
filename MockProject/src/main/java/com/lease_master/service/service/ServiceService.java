package com.lease_master.service.service;


import com.lease_master.model.Services;
import com.lease_master.repository.ServiceRepository;
import com.lease_master.service.service.dtos.ServiceSearchDTO;
import com.lease_master.specification.ServiceSpecification;
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
 * Service class for managing service.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    /**
     * Saves a new service or updates an existing one.
     *
     * @param service the service to save or update
     * @return the saved or updated service
     */
    public Services save(Services service) {
        log.info("Saving service: {}", service);

        // Ensure deletedAt is set to null when creating a new service
        if (service.getServiceId() == null) {
            service.setDeletedAt(null);
        }

        return serviceRepository.save(service);
    }

    /**
     * Finds a service by ID.
     *
     * @param id the ID of the service
     * @return an optional containing the service if found, otherwise empty
     */
    public Optional<Services> findById(Long id) {
        log.info("Fetching service with id: {}", id);
        return serviceRepository.findById(id);
    }

    /**
     * Retrieves all service that are not softly deleted.
     *
     * @return a list of service
     */
    public List<Services> findAll() {
        log.info("Fetching all service");
        return serviceRepository.findAll();
    }

    /**
     * Soft deletes a service by setting the deletedAt field to the current time.
     *
     * @param id the ID of the service to softly delete
     */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting service with id: {}", id);
        Services service = serviceRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("service with id {} not found", id);
                    return new RuntimeException("service not found");
                });
        service.setDeletedAt(LocalDateTime.now());
        serviceRepository.save(service);
        log.info("service with id {} soft deleted successfully", id);
    }

    /**
     * Checks if a service exists by ID.
     *
     * @param id the ID of the service
     * @return true if the service exists, false otherwise
     */
    public boolean existsById(Long id) {
        log.info("Checking existence of service with id: {}", id);
        return serviceRepository.existsById(id);
    }

    /**
     * Searches for service based on given criteria.
     *
     * @param searchDTO the DTO containing search criteria
     * @param pageable pagination information
     * @return a page of service matching the criteria
     */
    public Page<Services> search(ServiceSearchDTO searchDTO, Pageable pageable) {
        log.info("Searching service with filters: {}, Pagination info - page: {}, size: {}",
                searchDTO, pageable.getPageNumber(), pageable.getPageSize());
        Specification<Services> spec = ServiceSpecification.search(searchDTO);
        return serviceRepository.findAll(spec, pageable);
    }
}