package com.be.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int id;

    private double amount;

    @Column(name = "duedatetime")
    private LocalDateTime dueDateTime;

    @Column(name = "createddatetime")
    private LocalDateTime createdDateTime;

    @Column(name = "latefee")
    private double lateFee;

    private String status;


    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_bill_customer"))


    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(mappedBy = "bill")
    private List<PaymentHistory> paymentHistories;

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<PaymentHistory> getPaymentHistories() {
        return paymentHistories;
    }

    public void setPaymentHistories(List<PaymentHistory> paymentHistories) {
        this.paymentHistories = paymentHistories;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBill_id() {
        return id;
    }

    public void setBill_id(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bill [id=" + id + ", amount=" + amount + ", dueDateTime=" + dueDateTime + ", createdDateTime="
                + createdDateTime + ", lateFee=" + lateFee + ", status=" + status + ", customer=" + customer
                + ", service=" + service + ", paymentHistories=" + paymentHistories + "]";
    }

    

}
