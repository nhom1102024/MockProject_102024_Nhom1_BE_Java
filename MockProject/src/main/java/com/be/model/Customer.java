package com.be.model;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;
    
    @Column(name = "username")
    private String userName;

    private String password;

    private String avata;

    @Column(name = "fullname")
    private String fullName;

    private String role;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    private Character gender;

    private String address;
    @Column(name = "phonenumber")
    private String phoneNumber;

    private String email;

    private String occupation;

    private String status;
    @Column(name = "deletedat")
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "candidates_id")
    private Candidates candidate;

  

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Customer [customer_id=" + customer_id + ", userName=" + userName + ", password=" + password + ", avata="
                + avata + ", fullName=" + fullName + ", role=" + role + ", dateOfBirth=" + dateOfBirth + ", gender="
                + gender + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", occupation=" + occupation + ", status=" + status + ", deletedAt=" + deletedAt + "]";
    }

    
    
=======
import java.sql.Date; // Consider using java.time.LocalDate for better date handling
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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id", nullable = false) // Ensure unit is required
    private Unit unit; // Ensure Unit class is defined

    @ManyToOne
    @JoinColumn(name = "candidates_id", referencedColumnName = "candidates_id", nullable = false) // Ensure candidates is required
    private Candidates candidates; // Ensure Candidates class is defined

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "role")
    private String role;

    @Column(name = "date_of_birth")
    private Date dateOfBirth; // Consider changing to LocalDate for better handling

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt; // Consider using LocalDateTime for better date handling
>>>>>>> 0b5ae80 (Request Service API 21.10.2024)
}
