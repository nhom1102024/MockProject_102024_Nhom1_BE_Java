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
@Table(name = "FeedbackEmployee")
public class FeedbackEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackEmployeeId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Integer rating;

    private String feedback;

    private LocalDateTime createdDateTime;

    private LocalDateTime deletedAt;
}
