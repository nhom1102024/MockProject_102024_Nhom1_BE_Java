package com.be.service;
import java.util.Optional;

import com.be.model.Amenities;
import com.be.repository.AmenitiesRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AmenitiesService {
    private final AmenitiesRepository amenitiesRepository;

    public AmenitiesService(AmenitiesRepository amenitiesRepository) {
        this.amenitiesRepository = amenitiesRepository;
    }
    // Show Amenities
    public List<Amenities> getAllAmenities() {
        return amenitiesRepository.findAll();
    }
    // Create Amenities
    public Amenities createAmenities(Amenities amenities) {
        return amenitiesRepository.save(amenities);
    }
    // Update Amenities
    public Optional<Amenities> getAmenitiesById(Integer id) {
        return this.amenitiesRepository.findById(id);
    }

    public Amenities handleSaveAmenities(Amenities amenities) {
        return this.amenitiesRepository.save(amenities);
    }
    // Delete Amenities
    public void deleteAmenities(int id) {
        Optional<Amenities> optionalAmenities = this.amenitiesRepository.findById(id);
        if (optionalAmenities.isPresent()) {
            this.amenitiesRepository.deleteById(id);
        }
    }
}
