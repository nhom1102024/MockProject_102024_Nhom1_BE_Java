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
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentId;

    private String apartmentName;

    private String location;

    private Integer buildYear;

    private Integer numberOfFloors;

    private Integer numberOfUnits;

    private String status;

    private LocalDateTime deletedAt;
}
