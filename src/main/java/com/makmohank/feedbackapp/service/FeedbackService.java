package com.makmohank.feedbackapp.service; 
import com.makmohank.feedbackapp.model.Feedback; 
import com.makmohank.feedbackapp.repository.FeedbackRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import java.util.List; 
import java.util.Optional; 
@Service 
public class FeedbackService { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackService.class); 
    @Autowired 
    private FeedbackRepository feedbackRepository; 
    /** 
     * Save feedback to the database. 
     * 
     * @param feedback the feedback to save 
     * @return the saved feedback 
     */ 
    public Feedback saveFeedback(Feedback feedback) { 
        try { 
            logger.info("Attempting to save feedback: {}", feedback); 
            Feedback savedFeedback = feedbackRepository.save(feedback); 
            logger.info("Feedback saved successfully with ID: {}", savedFeedback.getId()); 
            return savedFeedback; 
        } catch (Exception e) { 
            logger.error("Error saving feedback: {}", e.getMessage(), e); 
            throw e; 
        } 
    } 
    /** 
     * Retrieve all feedback entries from the database. 
     * 
     * @return a list of feedback entries 
     */ 
    public List<Feedback> getAllFeedback() { 
        try { 
            logger.info("Retrieving all feedback entries from the database."); 
            List<Feedback> feedbackList = feedbackRepository.findAll(); 
            logger.info("Retrieved {} feedback entries.", feedbackList.size()); 
            return feedbackList; 
        } catch (Exception e) { 
            logger.error("Error retrieving feedback entries: {}", e.getMessage(), e); 
            throw e; 
        } 
    } 
    /** 
     * Retrieve a feedback entry by its ID. 
     * 
     * @param id the ID of the feedback entry 
     * @return an Optional containing the feedback entry if found, or empty if not found 
     */ 
    public Optional<Feedback> getFeedbackById(Long id) { 
        try { 
            logger.info("Retrieving feedback entry with ID: {}", id); 
            Optional<Feedback> feedback = feedbackRepository.findById(id); 
            if (feedback.isPresent()) { 
                logger.info("Feedback entry found: {}", feedback.get()); 
            } else { 
                logger.info("No feedback entry found with ID: {}", id); 
            } 
            return feedback; 
        } catch (Exception e) { 
            logger.error("Error retrieving feedback entry by ID: {}", e.getMessage(), e); 
            throw e; 
        } 
    } 
} package com.makmohank.feedbackapp.service; 
import com.makmohank.feedbackapp.dao.FeedbackDAO; 
import com.makmohank.feedbackapp.model.Feedback; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class FeedbackService { 
    private static final Logger LOGGER = Logger.getLogger(FeedbackService.class.getName()); 
    private final FeedbackDAO feedbackDAO = new FeedbackDAO(); 
    public void submitFeedback(Feedback feedback) { 
        try { 
            LOGGER.info("Submitting feedback."); 
            feedbackDAO.saveFeedback(feedback); 
            LOGGER.info("Feedback submitted successfully."); 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error submitting feedback: {0}", e.getMessage()); 
            LOGGER.log(Level.SEVERE, "Stack Trace: ", e); 
        } 
    } 
    public List<Feedback> listFeedback() { 
        try { 
            LOGGER.info("Retrieving list of feedback."); 
            List<Feedback> feedbackList = feedbackDAO.getAllFeedback(); 
            LOGGER.info("Feedback list retrieved successfully."); 
            return feedbackList; 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error retrieving feedback list: {0}", e.getMessage()); 
            LOGGER.log(Level.SEVERE, "Stack Trace: ", e); 
            return null; 
        } 
    } 
} 