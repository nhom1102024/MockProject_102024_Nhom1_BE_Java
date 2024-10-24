package com.lease_master.controller;

import com.lease_master.service.service.ServiceService;
import com.lease_master.model.Services;
import com.lease_master.service.service.dtos.ServiceSearchDTO;
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
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    @Operation(tags = "Service", description = "Get all services")
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> services = serviceService.findAll();
        return ResponseEntity.ok(services);
    }

    @PostMapping("/services/search")
    @Operation(tags = "Service", description = "Search services")
    public Page<Services> searchServices(
            @ModelAttribute ServiceSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return serviceService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    @Operation(tags = "Service", description = "Get service by ID")
    public ResponseEntity<Services> getServiceById(@PathVariable Long id) {
        Optional<Services> service = serviceService.findById(id);
        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(tags = "Service", description = "Create new service")
    public ResponseEntity<Services> createService(@RequestBody Services service) {
        Services savedService = serviceService.save(service);
        return ResponseEntity.ok(savedService);
    }

    @PutMapping("/{id}")
    @Operation(tags = "Service", description = "Update service by ID")
    public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services service) {
        if (!serviceService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Services updatedService = serviceService.save(service);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{id}")
    @Operation(tags = "Service", description = "Soft delete service by ID")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        if (!serviceService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        serviceService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
