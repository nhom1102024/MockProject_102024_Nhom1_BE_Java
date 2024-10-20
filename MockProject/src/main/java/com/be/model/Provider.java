package com.be.model;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    private String nameProvider;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private String address;
    private String status;

    @OneToMany(mappedBy = "provider")
    private List<Device> devices;

    public Long getProviderId() {
        return providerId;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

}
