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
@Table(name = "Provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private int id;

    @Column(name = "nameprovider")
    private String nameProvider;

    @Column(name = "contactperson")
    private String contactPerson;

    @Column(name = "phonenumber")
    private String phoneNumber;

    private String email;

    private String address;

    private String status;

    @OneToMany(mappedBy = "provider")
    private List<Service> services;

    public int getProvider_id() {
        return id;
    }

    public void setProvider_id(int id) {
        this.id = id;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Provider [id=" + id + ", nameProvider=" + nameProvider + ", contactPerson="
                + contactPerson + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
                + ", status=" + status + "]";
    }

    
    
}
