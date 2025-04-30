package com.yourcompany.feedbackapp.model; 
import javax.validation.constraints.Email; 
import javax.validation.constraints.Max; 
import javax.validation.constraints.Min; 
import javax.validation.constraints.NotBlank; 
import javax.validation.constraints.NotNull; 
public class Feedback { 
    @NotBlank(message = "Username is required") 
    private String username; 
    @NotBlank(message = "Email is required") 
    @Email(message = "Email should be valid") 
    private String email; 
    @NotBlank(message = "Phone number is required") 
    private String phone; 
    @NotBlank(message = "Comments are required") 
    private String comments; 
    @NotNull(message = "Rating is required") 
    @Min(value = 1, message = "Rating must be at least 1") 
    @Max(value = 5, message = "Rating must be at most 5") 
    private Integer rating; 
    // Getters and Setters 
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
    public Integer getRating() { 
        return rating; 
    } 
    public void setRating(Integer rating) { 
        this.rating = rating; 
    } 
} 