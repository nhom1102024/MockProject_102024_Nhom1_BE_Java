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
@Table(name = "Timekeeping")
public class Timekeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timekeepingId;

    private LocalDateTime checkinTime;

    private LocalDate workDate;
}
