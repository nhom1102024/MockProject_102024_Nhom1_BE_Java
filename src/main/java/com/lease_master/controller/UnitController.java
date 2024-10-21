package com.lease_master.controller;

import com.lease_master.service.unit.UnitService;
import com.lease_master.model.Unit;
import com.lease_master.service.unit.dtos.UnitDTO;
import com.lease_master.service.unit.dtos.UnitSearchDTO;
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
@RequestMapping("/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    @Operation(tags = "Unit", description = "Get all units")
    public ResponseEntity<List<UnitDTO>> getAllUnits() {
        List<UnitDTO> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    @PostMapping("/units/search")
    @Operation(tags = "Unit", description = "Search units")
    public Page<UnitDTO> searchUnits(
            @ModelAttribute UnitSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return unitService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    @Operation(tags = "Unit", description = "Get unit by ID")
    public ResponseEntity<UnitDTO> getUnitById(@PathVariable Long id) {
        Optional<UnitDTO> unit = unitService.findById(id);
        return unit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(tags = "Unit", description = "Create new unit")
    public ResponseEntity<UnitDTO> createUnit(@RequestBody UnitDTO unit) {
        UnitDTO savedUnit = unitService.save(unit);
        return ResponseEntity.ok(savedUnit);
    }

    @PutMapping("/{id}")
    @Operation(tags = "Unit", description = "Update unit by ID")
    public ResponseEntity<UnitDTO> updateUnit(@PathVariable Long id, @RequestBody UnitDTO unit) {
        if (!unitService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        UnitDTO updatedUnit = unitService.save(unit);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    @Operation(tags = "Unit", description = "Soft delete unit by ID")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        if (!unitService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        unitService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
