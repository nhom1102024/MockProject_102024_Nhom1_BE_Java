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
@Table(name = "EmployeeTraining")
public class EmployeeTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeTrainingId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "class_training_id", nullable = false)
    private ClassTraining classTraining;

    private Integer assess;

    private String status;

    private LocalDateTime deletedAt;
}
