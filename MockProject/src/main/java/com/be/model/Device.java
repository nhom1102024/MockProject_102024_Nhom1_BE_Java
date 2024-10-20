package com.be.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "categoryDevice_id")
    private CategoryDevice categoryDevice;

    private String nameDevice;
    private String description;
    private BigDecimal price;
    private String warrantyPeriod;
    private String status;
    private LocalDateTime deleteAt;

    public Device() {}

    public Device(Provider provider, CategoryDevice categoryDevice, String nameDevice, String description, BigDecimal price, String warrantyPeriod, String status) {
        this.provider = provider;
        this.categoryDevice = categoryDevice;
        this.nameDevice = nameDevice;
        this.description = description;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
        this.status = status;
    }

    public Long getDeviceId() {
        return deviceId;
    }
    public Provider getProvider() {
        return provider;
    }
    public CategoryDevice getCategoryDevice() {
        return categoryDevice;
    }
    public String getNameDevice() {
        return nameDevice;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    public void setCategoryDevice(CategoryDevice categoryDevice) {
        this.categoryDevice = categoryDevice;
    }
    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }
    
    

}
