package com.be.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.be.model.FeedbackEmployee;

public interface FeedbackEmployeeRepository extends JpaRepository <FeedbackEmployee, Integer>{
    public List<FeedbackEmployee> findAll();
}
