package com.be.model;

<<<<<<< HEAD
import java.time.LocalDate;
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
@Table(name = "Employee")
=======
import java.math.BigDecimal;
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
@Table(name = "employee")
>>>>>>> 0b5ae80 (Request Service API 21.10.2024)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "employee_id")
    private int employee_id;
    @Column(name = "username")
    private String userName;

    private String password;

    private String avata;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    private Character gender;

    private String address;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "socialsecuritynumber")
    private String socialSecurityNumber;

    private String email;
    @Column(name = "startdate")
    private LocalDate startDate;

    private double salary;

    private String status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "employee")
    private List<Candidates> candidates;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
=======
    @Column(name = "employee_id") // Maps to the database column
    private Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false) // Ensure Role entity has role_id field
    private Role role;

    @ManyToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id", nullable = false) // Ensure Apartment entity has apartment_id field
    private Apartment apartment;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dayOfBirth; // Consider changing to LocalDate for better handling

    @Column(name = "gender")
    private Character gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "start_date") // Corrected from 'starDate' to 'startDate'
    private Date startDate; // Consider changing to LocalDate for better handling

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "status")
    private String status;

    @Column(name = "deleted_at")
    private LocalDateTime deleteAt; // Consider using LocalDateTime for better date handling
>>>>>>> 0b5ae80 (Request Service API 21.10.2024)
}
