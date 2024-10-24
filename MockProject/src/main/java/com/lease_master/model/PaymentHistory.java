package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PaymentHistory")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentHistoryId;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    private LocalDateTime paymentDateTime;

    private BigDecimal amountPaid;

    private String paymentMethod;

    private BigDecimal lateFee;

    private String note;

    private LocalDateTime deletedAt;
}
