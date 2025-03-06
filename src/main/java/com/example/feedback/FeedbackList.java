package com.example.feedback; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class FeedbackList { 
    private static final Logger logger = Logger.getLogger(FeedbackList.class.getName()); 
    private List<FeedbackEntry> feedbackEntries; 
    public FeedbackList() { 
        feedbackEntries = new ArrayList<>(); 
    } 
    public void addFeedback(FeedbackEntry entry) { 
        try { 
            feedbackEntries.add(entry); 
            logger.log(Level.INFO, "Feedback added: {0}", entry); 
        } catch (Exception e) { 
            logger.log(Level.SEVERE, "Error adding feedback: " + e.getMessage(), e); 
        } 
    } 
    public List<FeedbackEntry> getFeedbackEntries() { 
        try { 
            logger.log(Level.INFO, "Retrieving feedback entries."); 
            return new ArrayList<>(feedbackEntries); 
        } catch (Exception e) { 
            logger.log(Level.SEVERE, "Error retrieving feedback entries: " + e.getMessage(), e); 
            return new ArrayList<>(); 
        } 
    } 
    public static class FeedbackEntry { 
        private String username; 
        private String email; 
        private String comments; 
        private int rating; 
        public FeedbackEntry(String username, String email, String comments, int rating) { 
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
        @Override 
        public String toString() { 
            return "FeedbackEntry{" + 
                    "username='" + username + '\'' + 
                    ", email='" + email + '\'' + 
                    ", comments='" + comments + '\'' + 
                    ", rating=" + rating + 
                    '}'; 
        } 
    } 
} 