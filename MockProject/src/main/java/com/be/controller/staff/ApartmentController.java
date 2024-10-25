package com.be.controller.staff;

import com.be.dto.apartment.ApartmentSearchDTO;
import com.be.service.apartment.ApartmentService;
import com.be.model.Apartment;
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
    public ResponseEntity<List<Apartment>> getAllApartments() {
        List<Apartment> apartments = apartmentService.findAll();
        return ResponseEntity.ok(apartments);
    }

    @PostMapping("/search")
    public Page<Apartment> searchApartments(
            @ModelAttribute ApartmentSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return apartmentService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable Integer id) {
        Optional<Apartment> apartment = apartmentService.findById(id);
        return apartment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        Apartment savedApartment = apartmentService.save(apartment);
        return ResponseEntity.ok(savedApartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Integer id, @RequestBody Apartment apartment) {
        if (!apartmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Apartment updatedApartment = apartmentService.save(apartment);
        return ResponseEntity.ok(updatedApartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Integer id) {
        if (!apartmentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        apartmentService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
