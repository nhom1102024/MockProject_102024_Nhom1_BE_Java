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
@Table(name = "UnitAmenity")
public class UnitAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitAmenityId;

    @ManyToOne
    @JoinColumn(name = "unit_id", nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "amenities_id", nullable = false)
    private Amenity amenity;

    private String status;

    private LocalDateTime deletedAt;
}
