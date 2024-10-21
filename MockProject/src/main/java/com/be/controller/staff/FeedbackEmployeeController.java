package com.be.controller.staff;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import com.be.model.FeedbackEmployee;
import com.be.service.FeedbackEmployeeService;
import java.util.List;






@RestController
public class FeedbackEmployeeController {
    private final FeedbackEmployeeService feedbackEmployeeServiece;

    public FeedbackEmployeeController(FeedbackEmployeeService feedbackEmployeeServiece) {
        this.feedbackEmployeeServiece = feedbackEmployeeServiece;
    }

    @GetMapping("/staff/show_feedbacks")
    public List<FeedbackEmployee> getFeedback(){
        List<FeedbackEmployee> feedbackEmployees = this.feedbackEmployeeServiece.getAllFeedbacks();
        return feedbackEmployees;
    }
    @PostMapping("/staff/create_feedbacks")
    public FeedbackEmployee createFeedback(@RequestBody FeedbackEmployee feedbackEmployee ) {
        FeedbackEmployee createdFeedback = feedbackEmployeeServiece.createFeedbacks(feedbackEmployee);
        return createdFeedback;
    }
    
    @PostMapping("/staff/update_feedbacks")
    public FeedbackEmployee postUpdatefeedback(@RequestBody FeedbackEmployee feedbackEmployee) {
        Optional<FeedbackEmployee> feedbackOptional = this.feedbackEmployeeServiece.getFeedbackById(feedbackEmployee.getFeedbackEmployee_id());
        if (feedbackOptional.isPresent()) {
            FeedbackEmployee currentFeedback = feedbackOptional.get();

            currentFeedback.setRating(feedbackEmployee.getRating()); 
            currentFeedback.setFeedback(feedbackEmployee.getFeedback());  
            currentFeedback.setCreatedDateTime(feedbackEmployee.getCreatedDateTime());
            currentFeedback.setDeleteAt(feedbackEmployee.getDeleteAt());
            this.feedbackEmployeeServiece.handleSaveFeedback(currentFeedback);
        }

        return feedbackEmployee;

    }
    
    @PostMapping("/staff/delete_feedbacks")
    public String postDeleteFeedback(@RequestBody FeedbackEmployee feedbackEmployee) {
        this.feedbackEmployeeServiece.deleteFeedback(feedbackEmployee.getFeedbackEmployee_id());
        return "Delete successfull";
    }



    
}
