package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ApartmentAmenity")
public class ApartmentAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentAmenityId;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "amenity_id", nullable = false)
    private Amenity amenity;

    private Integer operatingHours;

    private String status;

    private LocalDateTime deletedAt;
}
