package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private Provider provider;

    @Column(name = "name_service")
    private String nameService;

    private String description;

    @Column(name = "category_service")
    private String categoryService;

    private BigDecimal price;

    private String duration;

    @Column(name = "contact_information") 
    private String contactInformation;

    @Column(name = "scope_of_services") 
    private String scopeOfServices;

    @Column(name = "quality_standards") 
    private String qualityStandards;

    @Column(name = "implementation_schedule")
    private String implementationSchedule;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @Column(name = "status")
    private String status;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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
}
