package com.be.model;

import java.time.LocalDate;
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
@Table(name = "Candidates")
public class Candidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidates_id")
    private int  candidates_id;

    private String nameCandidates;

    private String phoneNumber;

    private String email;

    private String status;

    private String fullName;

    private LocalDate dateOfBirth;

    private Character gender;

    private String address;

    private LocalDateTime deleteAt;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

     @OneToMany(mappedBy = "candidate")
    private List<Customer> customers;

    public int getCandidates_id() {
        return candidates_id;
    }

    public void setCandidates_id(int candidates_id) {
        this.candidates_id = candidates_id;
    }

    public String getNameCandidates() {
        return nameCandidates;
    }

    public void setNameCandidates(String nameCandidates) {
        this.nameCandidates = nameCandidates;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "Candidates [candidates_id=" + candidates_id + ", nameCandidates=" + nameCandidates + ", phoneNumber="
                + phoneNumber + ", email=" + email + ", status=" + status + ", fullName=" + fullName + ", dateOfBirth="
                + dateOfBirth + ", gender=" + gender + ", address=" + address + ", deleteAt=" + deleteAt + "]";
    }

    

}
