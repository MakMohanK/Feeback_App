package com.example.feedbackapp.repositories; 
import com.example.feedbackapp.model.Feedback; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
@Repository 
public interface FeedbackRepository extends JpaRepository<Feedback, Long> { 
    // Additional query methods if needed 
} 