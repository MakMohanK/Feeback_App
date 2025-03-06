package com.makmohank.feedbackapp.controller; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.ui.Model; 
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 
import com.makmohank.feedbackapp.service.FeedbackService; 
import com.makmohank.feedbackapp.model.Feedback; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@RestController 
@RequestMapping("/feedback") 
public class FeedbackController { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class); 
    @Autowired 
    private FeedbackService feedbackService; 
    @GetMapping("/form") 
    public ModelAndView showFeedbackForm(Model model) { 
        logger.info("Displaying feedback form."); 
        model.addAttribute("feedback", new Feedback()); 
        return new ModelAndView("feedback_form"); 
    } 
    @PostMapping("/submit") 
    public ModelAndView submitFeedback(Feedback feedback, RedirectAttributes redirectAttributes) { 
        try { 
            logger.info("Submitting feedback: {}", feedback); 
            feedbackService.saveFeedback(feedback); 
            redirectAttributes.addFlashAttribute("success", "Feedback submitted successfully!"); 
            return new ModelAndView("redirect:/feedback/list"); 
        } catch (Exception e) { 
            logger.error("Error submitting feedback: {}", e.getMessage(), e); 
            redirectAttributes.addFlashAttribute("error", "An error occurred while submitting feedback."); 
            return new ModelAndView("redirect:/feedback/form"); 
        } 
    } 
    @GetMapping("/list") 
    public ModelAndView listFeedback(Model model) { 
        try { 
            logger.info("Listing feedback entries."); 
            model.addAttribute("feedbackEntries", feedbackService.getAllFeedback()); 
            return new ModelAndView("feedback_list"); 
        } catch (Exception e) { 
            logger.error("Error listing feedback: {}", e.getMessage(), e); 
            model.addAttribute("error", "An error occurred while retrieving feedback."); 
            return new ModelAndView("feedback_list"); 
        } 
    } 
} 