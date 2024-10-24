package com.be.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.model.Complaint;

/**			
 * ComplaintRepository			
 *			
 * Version 1.0			
 *			
 * Date: 24-10-2024			
 *		
 * Copyright 			
 *			
 * Modification Logs:			
 * DATE                 AUTHOR          DESCRIPTION			
 * -----------------------------------------------------------------------			
 * 24-10-2024         Thanh Hai            Create			
 */
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    @Query("SELECT c.customerName FROM Complaint c WHERE c.id = :id")
    String getCustomerName(@Param("id") Long id);

    @Query("SELECT c.complaintType FROM Complaint c WHERE c.id = :id")
    String getComplaintType(@Param("id") Long id);

    @Query("SELECT c.dateSubmitted FROM Complaint c WHERE c.id = :id")
    Date getDateSubmitted(@Param("id") Long id);

    @Query("SELECT c.address FROM Complaint c WHERE c.id = :id")
    String getAddress(@Param("id") Long id);

    @Query("SELECT c.status FROM Complaint c WHERE c.id = :id")
    String getStatus(@Param("id") Long id);
}
