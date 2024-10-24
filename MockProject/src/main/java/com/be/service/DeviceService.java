package com.be.service;

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.dto.DeviceDTO;
import com.be.exception.CustomRuntimeException;
import com.be.model.CategoryDevice;
import com.be.model.Device;
import com.be.model.Provider;
import com.be.repository.CategoryDeviceRepository;
import com.be.repository.DeviceRepository;
import com.be.repository.ProviderRepository;

/**			
 * DeviceService			
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
@Service
public class DeviceService {
     @Autowired
     private DeviceRepository deviceRepository;

     @Autowired
     private CategoryDeviceRepository categoryDeviceRepository;
     
     @Autowired
     private ProviderRepository providerRepository;

     /**
     * get data for List Device with deleteAt is null
     * @return
     */
     public List<Device> getNonDeletedDevices() {
         return deviceRepository.findByDeletedAtIsNull();
     }

     /**
     * Get data for Device lits deleted
     * @return
     */
     public List<Device> getDeletedDevices() {
         return deviceRepository.findByDeletedAtIsNotNull();
     }

     /**
     * Get data for Device Detail with device_id
     * @param id
     * @return
     */  
     public Device getDeviceById(Long id) {
         return deviceRepository.findById(id).orElseThrow(() -> new CustomRuntimeException("Device not found"));
     }

     /**
     * Create a new device with data from request 
     * @param deviceDTO
     * @return
     */
     public Device createDevice(DeviceDTO deviceDTO) {
         try {
             Provider provider = providerRepository.findById(deviceDTO.getProviderId())
                 .orElseThrow(() -> new CustomRuntimeException("Provider not found"));
             CategoryDevice categoryDevice = categoryDeviceRepository.findById(deviceDTO.getCategoryDeviceId())
                 .orElseThrow(() -> new CustomRuntimeException("CategoryDevice not found"));

             Device device = new Device();
             device.setNameDevice(deviceDTO.getNameDevice());
             device.setDescription(deviceDTO.getDescription());
             device.setPrice(deviceDTO.getPrice());
             device.setProvider(provider);
             device.setCategoryDevice(categoryDevice);

             return deviceRepository.save(device);
         } catch (Exception e) {
            throw new CustomRuntimeException("Failed to create device: " + e.getMessage());
         }
     }

     /**
     * Update device with id and data from request
     * @param id 
     * @param deviceDetails
     * @return
     */
     public Device updateDevice(Long id, Map<String, Object> updates) {
         Device device = deviceRepository.findById(id)
             .orElseThrow(() -> new CustomRuntimeException("Device not found with Id: "+ id));
         updates.forEach((key, value) -> {
             switch (key) {
                 case "name":
                     device.setNameDevice((String)value);
                     break;
                 case "category":
                     CategoryDevice categoryDevice = categoryDeviceRepository.findByNameCategoryDevice((String)value)
                         .orElseThrow(() -> new CustomRuntimeException("CategoryDevice not found"));
                     device.setCategoryDevice(categoryDevice);
                     break;
                 case "status":
                     device.setStatus((String)value);
                     break;
                 default:
                     throw new IllegalArgumentException("Invalid field: " + key);
             }
         });

         return deviceRepository.save(device);
     }

     /**
     * Delete the device with softDelete technique
     * @param id
     * @return
     */
     public Device deleteDevice(Long id) {
         Device device = deviceRepository.findById(id)
             .orElseThrow(() -> new CustomRuntimeException("Device not found"));
         device.setDeleteAt(LocalDateTime.now());
         deviceRepository.save(device);
         return device;
     }

     /**
     * Restore the device deleted
     * @param id
     * @return
     */
     public Device restorDevice(Long id){
         Device device = deviceRepository.findById(id)
             .orElseThrow(() -> new CustomRuntimeException("Device not found with id: "+ id));
         device.setDeleteAt(null);
         deviceRepository.save(device);
         return device;
     }

     public List<Device> searchDevice(String nameDevice){
         List<Device> devices = deviceRepository.findByNameDeviceContainingIgnoreCase(nameDevice);
         return devices;
     }
}   
