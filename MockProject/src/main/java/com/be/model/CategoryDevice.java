package com.be.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CategoryDevice")
public class CategoryDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryDeviceId;

    private String nameCategoryDevice;
    private String description;

    @OneToMany(mappedBy = "categoryDevice")
    private List<Device> devices;
    
    public Long getCategoryDeviceId() {
        return categoryDeviceId;
    }

    public String getNameCategoryDevice() {
        return nameCategoryDevice;
    }

    public String getDescription() {
        return description;
    }

    public void setCategoryDeviceId(Long categoryDeviceId) {
        this.categoryDeviceId = categoryDeviceId;
    }

    public void setNameCategoryDevice(String nameCategoryDevice) {
        this.nameCategoryDevice = nameCategoryDevice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
