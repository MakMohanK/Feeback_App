package com.example.feedback; 
import org.junit.Before; 
import org.junit.Test; 
import static org.junit.Assert.*; 
public class FeedbackFormTest { 
    private FeedbackForm feedbackForm; 
    @Before 
    public void setUp() { 
        feedbackForm = new FeedbackForm(); 
    } 
    @Test 
    public void testFormValidation() { 
        feedbackForm.setUsername("John Doe"); 
        feedbackForm.setEmail("john.doe@example.com"); 
        feedbackForm.setPhone("1234567890"); 
        feedbackForm.setComments("Great service!"); 
        feedbackForm.setRating(5); 
        assertTrue(feedbackForm.isValid()); 
    } 
    @Test 
    public void testInvalidEmail() { 
        feedbackForm.setUsername("John Doe"); 
        feedbackForm.setEmail("invalid-email"); 
        feedbackForm.setPhone("1234567890"); 
        feedbackForm.setComments("Great service!"); 
        feedbackForm.setRating(5); 
        assertFalse(feedbackForm.isValid()); 
    } 
    // Add more tests for other validation rules 
} 