package com.be.model;

import java.math.BigDecimal;
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
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private Provider provider;

    @Column(name = "name_service") // Maps to the database column
    private String nameService;

    private String description;

    @Column(name = "category_service") // Maps to the database column
    private String categoryService;

    private BigDecimal price;

    private String duration;

    @Column(name = "contact_information") // Maps to the database column
    private String contactInformation;

    @Column(name = "scope_of_services") // Maps to the database column
    private String scopeOfServices;

    @Column(name = "quality_standards") // Maps to the database column
    private String qualityStandards;

    @Column(name = "implementation_schedule") // Maps to the database column
    private String implementationSchedule;

    @Column(name = "delete_at") // Maps to the database column
    private LocalDateTime deleteAt;
    @Column(name = "status")
    private String status;
}
