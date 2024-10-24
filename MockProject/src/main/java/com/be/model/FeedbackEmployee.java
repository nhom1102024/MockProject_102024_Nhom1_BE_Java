package com.be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Feedbackemployee")
public class FeedbackEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedbackemployee_id")
    private int feedbackEmployee_id;

    // Many-to-One relation with Customer
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    // Many-to-One relation with Employee
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    private int rating;

    private String feedback;
    @Column(name = "createddatetime")
    private LocalDateTime createdDateTime;
    @Column(name = "deleteat")
    private LocalDateTime deleteAt;

    // Getters and Setters
    public int getFeedbackEmployee_id() {
        return feedbackEmployee_id;
    }

    public void setFeedbackEmployee_id(int feedbackEmployee_id) {
        this.feedbackEmployee_id = feedbackEmployee_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "FeedbackEmployee [feedbackEmployee_id=" + feedbackEmployee_id + ", customer=" + customer + ", employee="
                + employee + ", rating=" + rating + ", feedback=" + feedback + ", createdDateTime=" + createdDateTime
                + ", deleteAt=" + deleteAt + "]";
    }
    
}

