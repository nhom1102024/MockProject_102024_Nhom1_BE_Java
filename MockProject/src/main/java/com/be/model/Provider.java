package com.be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Integer providerId;

    @Column(name = "name_provider") // Maps to the database column
    private String nameProvider;

    @Column(name = "contact_person") // Maps to the database column
    private String contactPerson;

    @Column(name = "phone_number") // Maps to the database column
    private String phoneNumber;

    @Column(name = "email") // Maps to the database column
    private String email;

    @Column(name = "address") // Maps to the database column
    private String address;

    @Column(name = "status") // Maps to the database column
    private String status;
}
