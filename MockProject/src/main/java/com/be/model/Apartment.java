package com.be.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Apartment")
public class Apartment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private int id;

    @Column(name = "apartmentname")
    private String apartmentName;
    private String location;
    @Column(name = "buildyear")
    private int buildYear;
    @Column(name = "numberoffloors")
    private int numberOfFloors;
    @Column(name = "numberofunits")
    private int numberOfUnits;
    private String status;

    @OneToMany(mappedBy = "apartment")
    private List<Unit> units;

    public int getApartment_id() {
        return id;
    }
    public void setApartment_id(int id) {
        this.id = id;
    }
    public String getApartmentName() {
        return apartmentName;
    }
    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getBuildYear() {
        return buildYear;
    }
    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public int getNumberOfUnits() {
        return numberOfUnits;
    }
    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Customer [id=" + id + ", apartmentName=" + apartmentName + ", location=" + location
                + ", buildYear=" + buildYear + ", numberOfFloors=" + numberOfFloors + ", numberOfUnits=" + numberOfUnits
                + ", status=" + status + "]";
    }
}
