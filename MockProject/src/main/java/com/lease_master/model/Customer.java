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
@Table(name = "Customer")
public class Customer {

    @Id
    private Long customerId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "customer_id")
    private User user;

    private String occupation;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
