package com.example.feedbackapp.controllers; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.beans.factory.annotation.Autowired; 
import com.example.feedbackapp.services.FeedbackService; 
import com.example.feedbackapp.models.Feedback; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@RestController 
@RequestMapping("/feedback") 
public class FeedbackController { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class); 
    @Autowired 
    private FeedbackService feedbackService; 
    @GetMapping("/form") 
    public ModelAndView showFeedbackForm() { 
        logger.info("Rendering feedback form."); 
        return new ModelAndView("feedback_form"); 
    } 
    @PostMapping("/submit") 
    public ModelAndView submitFeedback(Feedback feedback) { 
        try { 
            logger.info("Submitting feedback: {}", feedback); 
            feedbackService.saveFeedback(feedback); 
            logger.info("Feedback submitted successfully."); 
            return new ModelAndView("redirect:/feedback/list"); 
        } catch (Exception e) { 
            logger.error("Error submitting feedback: ", e); 
            return new ModelAndView("error").addObject("message", "An error occurred while submitting feedback."); 
        } 
    } 
    @GetMapping("/list") 
    public ModelAndView listFeedback() { 
        try { 
            logger.info("Listing feedback entries."); 
            return new ModelAndView("feedback_list").addObject("feedbackEntries", feedbackService.getAllFeedback()); 
        } catch (Exception e) { 
            logger.error("Error listing feedback: ", e); 
            return new ModelAndView("error").addObject("message", "An error occurred while retrieving feedback list."); 
        } 
    } 
} 