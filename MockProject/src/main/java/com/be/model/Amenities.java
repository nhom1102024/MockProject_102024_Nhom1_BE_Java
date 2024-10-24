package com.be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "Amenities")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenities_id")
    private int amenities_id;
    @Column(name = "nameamenities")
    private String nameAmenities;
    private String description;

    public int getAmenities_id() {
        return amenities_id;
    }
    public void setAmenities_id(int amenities_id) {
        this.amenities_id = amenities_id;
    }
    public String getNameAmenities() {
        return nameAmenities;
    }
    public void setNameAmenities(String nameAmenities) {
        this.nameAmenities = nameAmenities;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
