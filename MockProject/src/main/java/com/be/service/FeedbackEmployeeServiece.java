package com.be.service;

import java.util.Optional;
import com.be.model.FeedbackEmployee;
import com.be.repository.CustomerRepository;
import com.be.repository.EmployeeRepository;
import com.be.repository.FeedbackEmployeeRepository;

// import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackEmployeeServiece {

    private final FeedbackEmployeeRepository feedbackEmployeeRepository;
   
    

    public FeedbackEmployeeServiece(FeedbackEmployeeRepository feedbackEmployeeRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.feedbackEmployeeRepository = feedbackEmployeeRepository;
    }


    public List<FeedbackEmployee> getAllFeedbacks() {
        return feedbackEmployeeRepository.findAll();
    }

    public FeedbackEmployee createFeedbacks(FeedbackEmployee feedbackEmployee) {
        return feedbackEmployeeRepository.save(feedbackEmployee);
    }

    public Optional<FeedbackEmployee> getFeedbackById(Integer id) {
        return this.feedbackEmployeeRepository.findById(id);
    }

    public FeedbackEmployee handleSaveFeedback(FeedbackEmployee feedbackEmployee) {
        return this.feedbackEmployeeRepository.save(feedbackEmployee);
    }

    public void deleteFeedback(int id) {
        Optional<FeedbackEmployee> optionalFeedback = this.feedbackEmployeeRepository.findById(id);
        if (optionalFeedback.isPresent()) {
            this.feedbackEmployeeRepository.deleteById(id);
        }
    }

}
