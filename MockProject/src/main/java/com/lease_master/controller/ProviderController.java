package com.lease_master.controller;

import com.lease_master.service.provider.ProviderService;
import com.lease_master.model.Provider;
import com.lease_master.service.provider.dtos.ProviderSearchDTO;
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
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping
    @Operation(tags = "Provider", description = "Get all providers")
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = providerService.findAll();
        return ResponseEntity.ok(providers);
    }

    @PostMapping("/providers/search")
    @Operation(tags = "Provider", description = "Search providers")
    public Page<Provider> searchProviders(
            @ModelAttribute ProviderSearchDTO searchDTO,
            @PageableDefault(size = 10) Pageable pageable) {
        return providerService.search(searchDTO, pageable);
    }

    @GetMapping("/{id}")
    @Operation(tags = "Provider", description = "Get provider by ID")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        Optional<Provider> provider = providerService.findById(id);
        return provider.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(tags = "Provider", description = "Create new provider")
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider savedProvider = providerService.save(provider);
        return ResponseEntity.ok(savedProvider);
    }

    @PutMapping("/{id}")
    @Operation(tags = "Provider", description = "Update provider by ID")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id, @RequestBody Provider provider) {
        if (!providerService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Provider updatedProvider = providerService.save(provider);
        return ResponseEntity.ok(updatedProvider);
    }

    @DeleteMapping("/{id}")
    @Operation(tags = "Provider", description = "Soft delete provider by ID")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        if (!providerService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        providerService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
}
