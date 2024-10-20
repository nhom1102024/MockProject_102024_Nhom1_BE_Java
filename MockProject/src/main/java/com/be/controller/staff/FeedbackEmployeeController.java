package com.be.controller.staff;
import org.springframework.web.bind.annotation.*;
import com.be.model.FeedbackEmployee;
import com.be.service.FeedbackEmployeeServiece;
import java.util.List;





@RestController
public class FeedbackEmployeeController {
    private final FeedbackEmployeeServiece feedbackEmployeeServiece;

    public FeedbackEmployeeController(FeedbackEmployeeServiece feedbackEmployeeServiece) {
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
    
    



    
}
