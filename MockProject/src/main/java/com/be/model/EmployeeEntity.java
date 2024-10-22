package com.be.model;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Employee")
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Integer employeeId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Column(name = "apartment_id")
    Integer apartmentId;

    @Column(name = "userName", length = 255)
    String userName;

    @Column(name = "password", length = 255)
    String password;

    @Column(name = "avata", length = 255)
    String avata;

    @Column(name = "fullName", length = 255)
    String fullName;

    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    Date dateOfBirth;

    @Column(name = "gender", length = 1)
    String gender;

    @Column(name = "address", length = 255)
    String address;

    @Column(name = "phoneNumber", length = 16)
    String phoneNumber;

    @Column(name = "socialSecurityNumber", length = 255)
    String socialSecurityNumber;

    @Column(name = "email", length = 255)
    String email;

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    Date startDate;

    @Column(name = "salary")
    BigDecimal salary;

    @Column(name = "status", length = 255)
    String status;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;
}
