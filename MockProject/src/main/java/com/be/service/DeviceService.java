package com.be.service;

import java.util.List;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.exception.ResourceNotFoundException;
import com.be.model.Device;
import com.be.repository.DeviceRepository;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getNonDeletedDevices() {
        return deviceRepository.findAll();
    }

    public List<Device> getDeletedDevices() {
        return deviceRepository.findByDeletedAtIsNotNull();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
    }
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device updateDevice(Long id, Device deviceDetails) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        device.setNameDevice(deviceDetails.getNameDevice());
        device.setDescription(deviceDetails.getDescription());
        device.setPrice(deviceDetails.getPrice());
        device.setWarrantyPeriod(deviceDetails.getWarrantyPeriod());
        device.setStatus(deviceDetails.getStatus());
        device.setDeleteAt(deviceDetails.getDeleteAt());
        return deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        device.setDeleteAt(LocalDateTime.now());
        deviceRepository.save(device);
    }
}   
