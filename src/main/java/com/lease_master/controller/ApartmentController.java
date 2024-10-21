package com.lease_master.controller;

import com.lease_master.service.apartment.ApartmentService;
import com.lease_master.model.Apartment;
import com.lease_master.service.apartment.dtos.ApartmentSearchDTO;
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
@RequestMapping("/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    @GetMapping
    @Operation(tags = "Apartment", description = "Get all apartments")
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> apartments = apartmentService.findAll();
        return ResponseEntity.ok(apartments);
    }

    @PostMapping("/apartments/search")
    @Operation(tags = "Apartment", description = "Search apartments")
    public Page<Apartment> searchApartments(
            @ModelAttribute ApartmentSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return apartmentService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    @Operation(tags = "Apartment", description = "Get apartment by ID")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable Long id) {
        Optional<Apartment> apartment = apartmentService.findById(id);
        return apartment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(tags = "Apartment", description = "Create new apartment")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        Apartment savedApartment = apartmentService.save(apartment);
        return ResponseEntity.ok(savedApartment);
    }

    @PutMapping("/{id}")
    @Operation(tags = "Apartment", description = "Update apartment by ID")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody Apartment apartment) {
        if (!apartmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Apartment updatedApartment = apartmentService.save(apartment);
        return ResponseEntity.ok(updatedApartment);
    }

    @DeleteMapping("/{id}")
    @Operation(tags = "Apartment", description = "Soft delete apartment by ID")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        if (!apartmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        apartmentService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
