package com.example.feedback; 
import java.util.regex.Pattern; 
public class FeedbackForm { 
    private String username; 
    private String email; 
    private String phone; 
    private String comments; 
    private int rating; 
    // Regular expression for validating email 
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; 
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX); 
    public FeedbackForm() { 
    } 
    public FeedbackForm(String username, String email, String phone, String comments, int rating) { 
        this.username = username; 
        this.email = email; 
        this.phone = phone; 
        this.comments = comments; 
        this.rating = rating; 
    } 
    public String getUsername() { 
        return username; 
    } 
    public void setUsername(String username) { 
        this.username = username; 
    } 
    public String getEmail() { 
        return email; 
    } 
    public void setEmail(String email) { 
        this.email = email; 
    } 
    public String getPhone() { 
        return phone; 
    } 
    public void setPhone(String phone) { 
        this.phone = phone; 
    } 
    public String getComments() { 
        return comments; 
    } 
    public void setComments(String comments) { 
        this.comments = comments; 
    } 
    public int getRating() { 
        return rating; 
    } 
    public void setRating(int rating) { 
        this.rating = rating; 
    } 
    public boolean isValid() { 
        try { 
            if (username == null || username.isEmpty()) { 
                System.out.println("Validation failed: Username is required."); 
                return false; 
            } 
            if (email == null || !EMAIL_PATTERN.matcher(email).matches()) { 
                System.out.println("Validation failed: Invalid email format."); 
                return false; 
            } 
            if (phone == null || phone.isEmpty()) { 
                System.out.println("Validation failed: Phone number is required."); 
                return false; 
            } 
            if (comments == null || comments.isEmpty()) { 
                System.out.println("Validation failed: Comments are required."); 
                return false; 
            } 
            if (rating < 1 || rating > 5) { 
                System.out.println("Validation failed: Rating must be between 1 and 5."); 
                return false; 
            } 
            System.out.println("Validation successful."); 
            return true; 
        } catch (Exception e) { 
            System.err.println("Error during validation: " + e.getMessage()); 
            e.printStackTrace(); 
            return false; 
        } 
    } 
} 