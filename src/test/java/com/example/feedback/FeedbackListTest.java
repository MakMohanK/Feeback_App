package com.example.feedback; 
import org.junit.Before; 
import org.junit.Test; 
import static org.junit.Assert.*; 
import java.util.List; 
import java.util.ArrayList; 
public class FeedbackListTest { 
    private List<Feedback> feedbackList; 
    @Before 
    public void setUp() { 
        feedbackList = new ArrayList<>(); 
        feedbackList.add(new Feedback("John Doe", "john.doe@example.com", "Great service!", 5)); 
        feedbackList.add(new Feedback("Jane Smith", "jane.smith@example.com", "Could be better.", 3)); 
    } 
    @Test 
    public void testFeedbackListNotEmpty() { 
        assertFalse("Feedback list should not be empty", feedbackList.isEmpty()); 
    } 
    @Test 
    public void testFeedbackListSize() { 
        assertEquals("Feedback list should contain 2 entries", 2, feedbackList.size()); 
    } 
    @Test 
    public void testFeedbackContent() { 
        Feedback feedback = feedbackList.get(0); 
        assertEquals("Username should be 'John Doe'", "John Doe", feedback.getUsername()); 
        assertEquals("Email should be 'john.doe@example.com'", "john.doe@example.com", feedback.getEmail()); 
        assertEquals("Comments should be 'Great service!'", "Great service!", feedback.getComments()); 
        assertEquals("Rating should be 5", 5, feedback.getRating()); 
    } 
    @Test 
    public void testInvalidFeedbackRating() { 
        Feedback feedback = new Feedback("Invalid User", "invalid@example.com", "Invalid rating", 6); 
        assertFalse("Feedback rating should be between 1 and 5", feedback.isValidRating()); 
    } 
    // Feedback class for testing purposes 
    class Feedback { 
        private String username; 
        private String email; 
        private String comments; 
        private int rating; 
        public Feedback(String username, String email, String comments, int rating) { 
            this.username = username; 
            this.email = email; 
            this.comments = comments; 
            this.rating = rating; 
        } 
        public String getUsername() { 
            return username; 
        } 
        public String getEmail() { 
            return email; 
        } 
        public String getComments() { 
            return comments; 
        } 
        public int getRating() { 
            return rating; 
        } 
        public boolean isValidRating() { 
            return rating >= 1 && rating <= 5; 
        } 
    } 
} 