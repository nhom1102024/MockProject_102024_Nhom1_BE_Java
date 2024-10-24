package com.be.model;

import jakarta.persistence.*;
import lombok.Getter;

/**
 * Role
 * 
 * Version: 1.0
 * 
 * Date: 15-10-2024
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE AUTHOR DESCRIPTION
 * -------------------------------------
 * 15-10-2024 thuyhang Create
 */
@Getter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Column(name = "roleName", nullable = true, unique = true)
    private String roleName;

    @Column(nullable = true)
    private String description;
}