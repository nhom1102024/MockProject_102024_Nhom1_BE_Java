package com.be.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Amenities;



public interface AmenitiesRepository extends JpaRepository <Amenities, Integer>{
    
}
