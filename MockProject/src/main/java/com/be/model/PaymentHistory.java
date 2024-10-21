package com.be.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paymenthistory")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymenthistory_id")
    private int id;

    @Column(name = "paymentdatetime")
    private LocalDateTime paymentDateTime;

    @Column(name = "amountpaid")
    private double amountPaid;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "latefee")
    private double lateFee;

    private String note;

    @Column(name = "deleteat")
    private LocalDateTime deleteAt;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public int getPaymentHistory_id() {
        return id;
    }

    public void setPaymentHistory_id(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "PaymentHistory [id=" + id + ", paymentDateTime=" + paymentDateTime
                + ", amountPaid=" + amountPaid + ", paymentMethod=" + paymentMethod + ", lateFee=" + lateFee + ", note="
                + note + ", deleteAt=" + deleteAt + "]";
    }

    

}
