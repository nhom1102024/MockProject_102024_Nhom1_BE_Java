package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OutcomeType")
public class OutcomeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outcomeTypeId;

    private String outcomeTypeName;

    private String description;
}
