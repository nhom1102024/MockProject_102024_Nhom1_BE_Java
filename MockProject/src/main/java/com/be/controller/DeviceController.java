package com.be.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.dto.DeviceDTO;
import com.be.model.Device;
import com.be.service.DeviceService;

/**			
 * DeviceController			
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
@RestController
@RequestMapping("/api/equipment")
public class DeviceController {
     @Autowired
     private DeviceService deviceService;
    
     /**
     * Get data for Device list where deleteAt is null
     * @return
     */
     @GetMapping
     public List<Device> getNonDeletedDevices() {
         return deviceService.getNonDeletedDevices();
     }

     /**
     * Get data for Device lits deleted
     * @return
     */
     @GetMapping("/deleted")
     public List<Device> getDeletedDevices() {
         return deviceService.getDeletedDevices();
     } 
     /**
     * Get data for Device Detail with device_id
     * @param id
     * @return
     */  
     @GetMapping("/{id}")
     public Device getDeviceById(@PathVariable Long id) {
         return deviceService.getDeviceById(id);
     }

     /**
     * Create a new device with data from request
     * @param device
     * @return
     */
     @PostMapping("/create")
     public Device createDevice(@RequestBody DeviceDTO deviceDTO) {
        return deviceService.createDevice(deviceDTO);
     }

     /**
     * Update device with id and data from request
     * @param id 
     * @param deviceDetails
     * @return
     */
     @PutMapping("/update/{id}")
     public Device updateDevice(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
         return deviceService.updateDevice(id, updates);
     }
     /**
     * Delete the device with softDelete technique
     * @param id
     * @return
     */
     @DeleteMapping("/{id}")
     public Device softDeleteDevice(@PathVariable Long id) {      
         return deviceService.deleteDevice(id);
     }
     /**
     * Restore the device
     * @param id
     * @return
     */
     @PatchMapping("/{id}")
     public Device restoreDeviceDeleted(@PathVariable Long id){        
         return deviceService.restorDevice(id);
     }
}
