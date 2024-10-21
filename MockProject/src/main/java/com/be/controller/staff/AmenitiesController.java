package com.be.controller.staff;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.be.model.Amenities;

import com.be.service.AmenitiesService;
import java.util.List;

@RestController
public class AmenitiesController {
    private final AmenitiesService amenitiesService;

    public AmenitiesController(AmenitiesService amenitiesService) {
        this.amenitiesService = amenitiesService;
    }

    @GetMapping("/staff/show_amenities")
    public List<Amenities> getAmenities(){
        List<Amenities> amenities = this.amenitiesService.getAllAmenities();
        return amenities;
    }
    @PostMapping("/staff/create_amenities")
    public Amenities createAmenities(@RequestBody Amenities amenities ) {
        Amenities createAmenities = amenitiesService.createAmenities(amenities);
        return createAmenities;
    }
    
    @PostMapping("/staff/update_amenities")
    public Amenities postUpdateAmenities(@RequestBody Amenities amenities) {
        Optional<Amenities> amenitiesOptional = this.amenitiesService.getAmenitiesById(amenities.getAmenities_id());
        if (amenitiesOptional.isPresent()) {
            Amenities currentAmenities = amenitiesOptional.get();

            currentAmenities.setNameAmenities(amenities.getNameAmenities()); 
            currentAmenities.setDescription(amenities.getDescription());  
            
            this.amenitiesService.handleSaveAmenities(currentAmenities);
        }

        return amenities;

    }
    
    @PostMapping("/staff/delete_amenities")
    public String postDeleteAmenities(@RequestBody Amenities amenities) {
        this.amenitiesService.deleteAmenities(amenities.getAmenities_id());
        return "Delete successfull";
    }



    
}
