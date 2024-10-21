package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private int unit_id;
    @Column(name = "roomnumber")
    private String roomNumber;

    private Integer floor;

    private Integer area;
    @Column(name = "bedrooms")
    private Integer bedRooms;
    @Column(name = "bathrooms")
    private Integer bathRooms;

    private String status;

    private BigDecimal price;

    private String description;
    @Column(name = "deleteat")
    private LocalDateTime deleteAt;

 

    @OneToMany(mappedBy = "unit")
    private List<Customer> customers;

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(Integer bedRooms) {
        this.bedRooms = bedRooms;
    }

    public Integer getBathRooms() {
        return bathRooms;
    }

    public void setBathRooms(Integer bathRooms) {
        this.bathRooms = bathRooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "Unit [unit_id=" + unit_id + ", roomNumber=" + roomNumber + ", floor=" + floor + ", area=" + area
                + ", bedRooms=" + bedRooms + ", bathRooms=" + bathRooms + ", status=" + status + ", price=" + price
                + ", description=" + description + ", deleteAt=" + deleteAt + "]";
    }

    
    

=======

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer unitId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id", nullable = false) // Added nullable = false to enforce foreign key constraint
    private Apartment apartment; // Ensure the Apartment class is defined correctly

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "area")
    private Integer area;

    @Column(name = "bedrooms") // Corrected field name to match database
    private Integer bedrooms; // Updated to match "bedrooms" in the table

    @Column(name = "bathrooms") // Corrected field name to match database
    private Integer bathrooms; // Updated to match "bathrooms" in the table

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt; // Ensure the type matches the database column type
>>>>>>> 0b5ae80 (Request Service API 21.10.2024)
}
