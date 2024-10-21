package com.lease_master.service.apartment;

import com.lease_master.model.Apartment;
import com.lease_master.repository.ApartmentRepository;
import com.lease_master.service.apartment.dtos.ApartmentSearchDTO;
import com.lease_master.specification.ApartmentSpecification;
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
 * Service class for managing apartments.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    /**
     * Saves a new apartment or updates an existing one.
     *
     * @param apartment the apartment to save or update
     * @return the saved or updated apartment
     */
    public Apartment save(Apartment apartment) {
        log.info("Saving apartment: {}", apartment);

        // Ensure deletedAt is set to null when creating a new apartment
        if (apartment.getApartmentId() == null) {
            apartment.setDeletedAt(null);
        }

        return apartmentRepository.save(apartment);
    }

    /**
     * Finds an apartment by ID.
     *
     * @param id the ID of the apartment
     * @return an optional containing the apartment if found, otherwise empty
     */
    public Optional<Apartment> findById(Long id) {
        log.info("Fetching apartment with id: {}", id);
        return apartmentRepository.findById(id);
    }

    /**
     * Retrieves all apartments that are not softly deleted.
     *
     * @return a list of apartments
     */
    public List<Apartment> findAll() {
        log.info("Fetching all apartments");
        return apartmentRepository.findAll();
    }

    /**
     * Soft deletes an apartment by setting the deletedAt field to the current time.
     *
     * @param id the ID of the apartment to softly delete
     */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting apartment with id: {}", id);
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("apartment with id {} not found", id);
                    return new RuntimeException("apartment not found");
                });
        apartment.setDeletedAt(LocalDateTime.now());
        apartmentRepository.save(apartment);
        log.info("apartment with id {} soft deleted successfully", id);
    }

    /**
     * Checks if an apartment exists by ID.
     *
     * @param id the ID of the apartment
     * @return true if the apartment exists, false otherwise
     */
    public boolean existsById(Long id) {
        log.info("Checking existence of apartment with id: {}", id);
        return apartmentRepository.existsById(id);
    }

    /**
     * Searches for apartments based on given criteria.
     *
     * @param searchDTO the DTO containing search criteria
     * @param pageable pagination information
     * @return a page of apartments matching the criteria
     */
    public Page<Apartment> search(ApartmentSearchDTO searchDTO, Pageable pageable) {
        log.info("Searching apartments with filters: {}, Pagination info - page: {}, size: {}",
                searchDTO, pageable.getPageNumber(), pageable.getPageSize());
        Specification<Apartment> spec = ApartmentSpecification.search(searchDTO);
        return apartmentRepository.findAll(spec, pageable);
    }
}