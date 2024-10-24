package com.lease_master.service.unit;

import com.lease_master.mapper.UnitMapper;
import com.lease_master.model.Unit;
import com.lease_master.repository.UnitRepository;
import com.lease_master.service.unit.dtos.UnitDTO;
import com.lease_master.service.unit.dtos.UnitSearchDTO;
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
import java.util.stream.Collectors;

/**
 * Service class for managing units.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;

    /**
     * Saves a new unit or updates an existing one.
     *
     * @param unitDTO the unit to save or update
     * @return the saved or updated unit
     */
    @Transactional
    public UnitDTO save(UnitDTO unitDTO) {
        log.info("Saving unit: {}", unitDTO);
        Unit unit = UnitMapper.INSTANCE.toEntity(unitDTO);
        if (unit.getUnitId() == null) {
            unit.setDeletedAt(null);
        }
        Unit savedUnit = unitRepository.save(unit);
        return UnitMapper.INSTANCE.toDto(savedUnit);
    }


    /**
     * Finds a unit by ID.
     *
     * @param id the ID of the unit
     * @return an optional containing the unit if found, otherwise empty
     */
    public Optional<UnitDTO> findById(Long id) {
        log.info("Fetching unit with id: {}", id);
        Optional<Unit> unit = unitRepository.findById(id);
        return unit.map(UnitMapper.INSTANCE::toDto);
    }

    /**
     * Retrieves all units that are not softly deleted.
     *
     * @return a list of units
     */
    public List<UnitDTO> findAll() {
        log.info("Fetching all units");
        List<Unit> units = unitRepository.findAll();
        return units.stream()
                .map(UnitMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Soft deletes a unit by setting the deletedAt field to the current time.
     *
     * @param id the ID of the unit to softly delete
     */
    @Transactional
    public void softDelete(Long id) {
        log.info("Soft deleting unit with id: {}", id);
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("unit with id {} not found", id);
                    return new RuntimeException("unit not found");
                });
        unit.setDeletedAt(LocalDateTime.now());
        unitRepository.save(unit);
        log.info("unit with id {} soft deleted successfully", id);
    }

    /**
     * Checks if a unit exists by ID.
     *
     * @param id the ID of the unit
     * @return true if the unit exists, false otherwise
     */
    public boolean existsById(Long id) {
        log.info("Checking existence of unit with id: {}", id);
        return unitRepository.existsById(id);
    }

    /**
     * Searches for units based on given criteria.
     *
     * @param searchDTO the DTO containing search criteria
     * @param pageable pagination information
     * @return a page of units matching the criteria
     */
    public Page<UnitDTO> search(UnitSearchDTO searchDTO, Pageable pageable) {
        log.info("Searching units with filters: {}, Pagination info - page: {}, size: {}", searchDTO, pageable.getPageNumber(), pageable.getPageSize());
        Specification<Unit> spec = UnitSpecification.search(searchDTO);
        Page<Unit> unitsPage = unitRepository.findAll(spec, pageable);
        return unitsPage.map(UnitMapper.INSTANCE::toDto);
    }
}