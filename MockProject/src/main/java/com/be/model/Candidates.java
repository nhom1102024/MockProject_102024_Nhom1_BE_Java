package com.be.model;

<<<<<<< HEAD
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
    @Column(name = "namecandidates")
    private String nameCandidates;
    @Column(name = "phonenumber")
    private String phoneNumber;

    private String email;

    private String status;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    private Character gender;

    private String address;
    @Column(name = "deleteat")
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

    

=======
import java.sql.Date; // Consider using java.time.LocalDate if possible for better date handling
import java.time.LocalDateTime;

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
@Table(name = "candidates")
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidates_id")
    private Integer candidatesId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false) // Added nullable = false to enforce foreign key constraint
    private Employee employee; 

    @Column(name = "name_candidates")
    private String nameCandidates;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;
>>>>>>> 0b5ae80 (Request Service API 21.10.2024)
}
