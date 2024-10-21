package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrainingCatalog")
public class TrainingCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingCatalogId;

    private String trainingCatalogName;

    private String description;

    private String duration;

    private Boolean certificate;
}
