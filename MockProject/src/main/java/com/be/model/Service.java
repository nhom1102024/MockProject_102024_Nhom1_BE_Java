package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int service_id;

     private String nameService;

    private String description;

    private String categoryService;

    private BigDecimal price;

    private String duration;

    private String contactInformation;

    private String scopeOfServices;

    private String qualityStandards;

    private String implementationSchedule;

    private LocalDateTime deleteAt;

    private String status;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @OneToMany(mappedBy = "service")
    private List<Bill> bills;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(String categoryService) {
        this.categoryService = categoryService;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getScopeOfServices() {
        return scopeOfServices;
    }

    public void setScopeOfServices(String scopeOfServices) {
        this.scopeOfServices = scopeOfServices;
    }

    public String getQualityStandards() {
        return qualityStandards;
    }

    public void setQualityStandards(String qualityStandards) {
        this.qualityStandards = qualityStandards;
    }

    public String getImplementationSchedule() {
        return implementationSchedule;
    }

    public void setImplementationSchedule(String implementationSchedule) {
        this.implementationSchedule = implementationSchedule;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service [service_id=" + service_id + ", nameService=" + nameService + ", description=" + description
                + ", categoryService=" + categoryService + ", price=" + price + ", duration=" + duration
                + ", contactInformation=" + contactInformation + ", scopeOfServices=" + scopeOfServices
                + ", qualityStandards=" + qualityStandards + ", implementationSchedule=" + implementationSchedule
                + ", deleteAt=" + deleteAt + ", status=" + status + "]";
    }

    
    
}
