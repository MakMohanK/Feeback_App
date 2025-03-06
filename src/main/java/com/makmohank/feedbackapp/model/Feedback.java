package com.makmohank.feedbackapp.model; 
public class Feedback { 
    private Long id; 
    private String username; 
    private String email; 
    private String phone; 
    private String comments; 
    private Integer rating; 
    // Getters and setters 
    public Long getId() { 
        return id; 
    } 
    public void setId(Long id) { 
        this.id = id; 
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
    public Integer getRating() { 
        return rating; 
    } 
    public void setRating(Integer rating) { 
        this.rating = rating; 
    } 
} package com.makmohank.feedbackapp.model; 
public class Feedback { 
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
    // Getters and setters 
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
} package com.makmohank.feedbackapp.model; 
public class Feedback { 
    private String username; 
    private String email; 
    private String phone; 
    private String comments; 
    private int rating; 
    public Feedback(String username, String email, String phone, String comments, int rating) { 
        this.username = username; 
        this.email = email; 
        this.phone = phone; 
        this.comments = comments; 
        this.rating = rating; 
    } 
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
    public int getRating() { 
        return rating; 
    } 
    public void setRating(int rating) { 
        this.rating = rating; 
    } 
} 