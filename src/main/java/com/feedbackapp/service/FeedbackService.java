package com.feedbackapp.service; 
import com.feedbackapp.util.DatabaseConnectionPool; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class FeedbackService { 
    private static final Logger logger = Logger.getLogger(FeedbackService.class.getName()); 
    public void saveFeedback(String username, String email, String phone, String comments, int rating) { 
        String sql = "INSERT INTO feedback (username, email, phone, comments, rating) VALUES (?, ?, ?, ?, ?)"; 
        try (Connection connection = DatabaseConnectionPool.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) { 
            statement.setString(1, username); 
            statement.setString(2, email); 
            statement.setString(3, phone); 
            statement.setString(4, comments); 
            statement.setInt(5, rating); 
            statement.executeUpdate(); 
            logger.info("Feedback saved successfully for user: " + username); 
        } catch (SQLException e) { 
            logger.log(Level.SEVERE, "Error saving feedback for user: " + username, e); 
        } 
    } 
    public List<Feedback> getAllFeedback() { 
        List<Feedback> feedbackList = new ArrayList<>(); 
        String sql = "SELECT username, email, comments, rating FROM feedback"; 
        try (Connection connection = DatabaseConnectionPool.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql); 
             ResultSet resultSet = statement.executeQuery()) { 
            while (resultSet.next()) { 
                Feedback feedback = new Feedback(); 
                feedback.setUsername(resultSet.getString("username")); 
                feedback.setEmail(resultSet.getString("email")); 
                feedback.setComments(resultSet.getString("comments")); 
                feedback.setRating(resultSet.getInt("rating")); 
                feedbackList.add(feedback); 
            } 
            logger.info("Feedback data retrieved successfully."); 
        } catch (SQLException e) { 
            logger.log(Level.SEVERE, "Error retrieving feedback data", e); 
        } 
        return feedbackList; 
    } 
} 