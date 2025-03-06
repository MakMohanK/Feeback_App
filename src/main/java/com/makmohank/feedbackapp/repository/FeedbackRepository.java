package com.makmohank.feedbackapp.repository; 
import com.makmohank.feedbackapp.model.Feedback; 
import org.springframework.data.jpa.repository.JpaRepository; 
public interface FeedbackRepository extends JpaRepository<Feedback, Long> { 
    // Additional query methods if needed 
} 