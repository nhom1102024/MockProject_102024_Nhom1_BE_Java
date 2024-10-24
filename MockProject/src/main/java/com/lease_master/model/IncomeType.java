package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IncomeType")
public class IncomeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeTypeId;

    private String incomeTypeName;

    private String description;
}
