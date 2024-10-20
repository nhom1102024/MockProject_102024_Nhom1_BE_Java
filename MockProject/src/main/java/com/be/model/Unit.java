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
@Table(name = "Unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private int id;

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

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @OneToMany(mappedBy = "unit")
    private List<Customer> customers;

    public int getUnit_id() {
        return id;
    }

    public void setUnit_id(int id) {
        this.id = id;
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
        return "Unit [id=" + id + ", roomNumber=" + roomNumber + ", floor=" + floor + ", area=" + area
                + ", bedRooms=" + bedRooms + ", bathRooms=" + bathRooms + ", status=" + status + ", price=" + price
                + ", description=" + description + ", deleteAt=" + deleteAt + "]";
    }

    
    

}
