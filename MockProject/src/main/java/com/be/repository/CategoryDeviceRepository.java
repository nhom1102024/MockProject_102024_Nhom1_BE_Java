package com.be.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.be.model.CategoryDevice;

/**			
 * CategoryDeviceRepository			
 *			
 * Version 1.0			
 *			
 * Date: 20-10-2024			
 *			
 * Copyright 			
 *			
 * Modification Logs:			
 * DATE                 AUTHOR          DESCRIPTION			
 * -----------------------------------------------------------------------			
 * 20-10-2024         ThanhGiang            Create			
 */	
@Repository
public interface CategoryDeviceRepository extends JpaRepository<CategoryDevice, Long>{
    Optional<CategoryDevice> findByNameCategoryDevice (String categoryName);
}
