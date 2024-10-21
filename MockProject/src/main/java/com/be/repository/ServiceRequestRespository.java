package com.be.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.be.model.ServiceRequest;

@Repository
public interface ServiceRequestRespository extends JpaRepository<ServiceRequest,Integer>{

}
