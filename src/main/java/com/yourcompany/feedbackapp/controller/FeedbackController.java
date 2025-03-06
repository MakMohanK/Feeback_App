package com.yourcompany.feedbackapp.controller; 
import com.yourcompany.feedbackapp.model.Feedback; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 
import javax.validation.Valid; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@Controller 
public class FeedbackController { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class); 
    @GetMapping("/feedback-form") 
    public String showFeedbackForm(Model model) { 
        logger.info("Rendering feedback form page."); 
        model.addAttribute("feedback", new Feedback()); 
        return "feedback_form"; 
    } 
    @PostMapping("/feedback-form") 
    public String submitFeedbackForm(@Valid @ModelAttribute("feedback") Feedback feedback, 
                                     BindingResult bindingResult, 
                                     RedirectAttributes redirectAttributes) { 
        logger.info("Submitting feedback form."); 
        if (bindingResult.hasErrors()) { 
            logger.warn("Feedback form submission has errors: {}", bindingResult.getAllErrors()); 
            return "feedback_form"; 
        } 
        try { 
            // Here, you would typically save the feedback to the database 
            // For now, we'll just simulate a successful submission 
            logger.info("Feedback submitted successfully: {}", feedback); 
            redirectAttributes.addFlashAttribute("successMessage", "Feedback submitted successfully!"); 
        } catch (Exception e) { 
            logger.error("Error processing feedback submission: ", e); 
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while submitting feedback."); 
            return "feedback_form"; 
        } 
        return "redirect:/feedback-list"; 
    } 
} 