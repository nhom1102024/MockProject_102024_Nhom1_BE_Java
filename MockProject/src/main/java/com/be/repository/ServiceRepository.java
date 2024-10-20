package com.be.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.be.model.Service;


public interface ServiceRepository extends JpaRepository<Service, Integer> {
    public Service findByNameService(String name);
}
