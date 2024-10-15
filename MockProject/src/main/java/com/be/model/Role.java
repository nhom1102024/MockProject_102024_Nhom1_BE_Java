package com.be.model;

import jakarta.persistence.*;
import lombok.Getter;

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
