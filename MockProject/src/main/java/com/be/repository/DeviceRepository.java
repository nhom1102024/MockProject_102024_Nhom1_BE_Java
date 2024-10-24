package com.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.model.Device;

/**			
 * DeviceRepository			
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
public interface DeviceRepository extends JpaRepository<Device, Long>{
      @Query("SELECT d FROM Device d WHERE d.deleteAt IS NULL")
      List<Device> findByDeletedAtIsNull();

      @Query("SELECT d FROM Device d WHERE d.deleteAt IS NOT NULL")
      List<Device> findByDeletedAtIsNotNull();

      @Query("SELECT d FROM Device d WHERE d.provider.nameProvider = :nameProvider")
      List<Device> findByProviderName(@Param("nameProvider") String providerName);
 
      @Query("SELECT d FROM Device d WHERE d.nameDevice = :nameDevice")
      List<Device> findByDeviceName(@Param("nameDevice") String nameDevice);

      List<Device> findByNameDeviceContainingIgnoreCase(String nameDevice);

}
