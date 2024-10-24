package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ClassTraining")
public class ClassTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classTrainingId;

    @ManyToOne
    @JoinColumn(name = "training_catalog_id", nullable = false)
    private TrainingCatalog trainingCatalog;

    private String nameClassTraining;

    private String status;

    private String description;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime deletedAt;
}
