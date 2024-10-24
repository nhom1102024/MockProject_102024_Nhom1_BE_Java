package com.be.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.be.model.Contract;

/**			
 * ContractRepository			
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
 * 24-10-2024         ThanhHai            Create			
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Query("SELECT c.tenantName FROM Contract c WHERE c.id = :id")
    String getTenantName(@Param("id") Long id);

    @Query("SELECT c.apartmentNumber FROM Contract c WHERE c.id = :id")
    String getApartmentNumber(@Param("id") Long id);

    @Query("SELECT c.startDate FROM Contract c WHERE c.id = :id")
    Date getStartDate(@Param("id") Long id);

    @Query("SELECT c.endDate FROM Contract c WHERE c.id = :id")
    Date getEndDate(@Param("id") Long id);
}
