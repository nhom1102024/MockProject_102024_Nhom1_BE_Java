package com.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.be.model.Device;
import com.be.service.DeviceService;

@RestController
@RequestMapping("/api/equipment")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    
    @GetMapping
    public List<Device> getNonDeletedDevices() {
        return deviceService.getNonDeletedDevices();
    }
    @GetMapping("/deleted")
    public List<Device> getDeletedDevices() {
        return deviceService.getDeletedDevices();
    }   
    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }
    @PostMapping("/create")
    public Device createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }
    @PutMapping("/update/{id}")
    public Device updateDevice(@PathVariable Long id, @RequestBody Device deviceDetails) {
        return deviceService.updateDevice(id, deviceDetails);
    }

    @DeleteMapping("/{id}")
    public void softDeleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }
}
