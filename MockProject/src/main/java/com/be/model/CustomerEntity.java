package com.be.model;

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
@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "unit_id")
    private Integer unitId;

    @Column(name = "candidates_id")
    private Integer candidatesId;

    @Column(name = "userName", length = 255)
    private String userName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "avata", length = 255)
    private String avata;

    @Column(name = "fullName", length = 255)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "phoneNumber", length = 16)
    private String phoneNumber;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "occupation", length = 255)
    private String occupation;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "deletedAt")
    private LocalDateTime deletedAt;
}
