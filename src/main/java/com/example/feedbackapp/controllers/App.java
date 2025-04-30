package com.example.feedbackapp.controllers; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import com.example.feedbackapp.models.Feedback; 
import com.example.feedbackapp.services.FeedbackService; 
import javax.validation.Valid; 
@SpringBootApplication 
public class App { 
    public static void main(String[] args) { 
        SpringApplication.run(App.class, args); 
    } 
} 
@RestController 
@RequestMapping("/feedback") 
class FeedbackController { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class); 
    @Autowired 
    private FeedbackService feedbackService; 
    @GetMapping("/form") 
    public ModelAndView showFeedbackForm(Model model) { 
        logger.info("Rendering feedback form."); 
        model.addAttribute("feedback", new Feedback()); 
        return new ModelAndView("feedback_form"); 
    } 
    @PostMapping("/submit") 
    public ModelAndView submitFeedback(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult result, RedirectAttributes redirectAttributes) { 
        if (result.hasErrors()) { 
            logger.error("Feedback form submission has errors: {}", result.getAllErrors()); 
            return new ModelAndView("feedback_form"); 
        } 
        try { 
            feedbackService.saveFeedback(feedback); 
            logger.info("Feedback submitted successfully."); 
            redirectAttributes.addFlashAttribute("successMessage", "Feedback submitted successfully!"); 
            return new ModelAndView("redirect:/feedback/list"); 
        } catch (Exception e) { 
            logger.error("Error submitting feedback: ", e); 
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while submitting feedback."); 
            return new ModelAndView("redirect:/feedback/form"); 
        } 
    } 
    @GetMapping("/list") 
    public ModelAndView listFeedback(Model model) { 
        try { 
            logger.info("Retrieving feedback list."); 
            model.addAttribute("feedbackEntries", feedbackService.getAllFeedback()); 
            return new ModelAndView("feedback_list"); 
        } catch (Exception e) { 
            logger.error("Error retrieving feedback list: ", e); 
            model.addAttribute("errorMessage", "An error occurred while retrieving feedback list."); 
            return new ModelAndView("feedback_list"); 
        } 
    } 
} 