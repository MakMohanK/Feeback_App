package com.makmohank.feedbackapp.dao; 
import com.makmohank.feedbackapp.model.Feedback; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class FeedbackDao { 
    private static final String SELECT_ALL_FEEDBACK = "SELECT username, email, comments, rating FROM feedback"; 
    private static final Logger LOGGER = Logger.getLogger(FeedbackDao.class.getName()); 
    public List<Feedback> getAllFeedback() { 
        List<Feedback> feedbackList = new ArrayList<>(); 
        try (Connection connection = DatabaseConnection.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FEEDBACK)) { 
            ResultSet rs = preparedStatement.executeQuery(); 
            while (rs.next()) { 
                String username = rs.getString("username"); 
                String email = rs.getString("email"); 
                String comments = rs.getString("comments"); 
                int rating = rs.getInt("rating"); 
                Feedback feedback = new Feedback(username, email, comments, rating); 
                feedbackList.add(feedback); 
            } 
            LOGGER.info("Feedback data retrieved successfully."); 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error retrieving feedback from the database: ", e); 
        } 
        return feedbackList; 
    } 
} package com.makmohank.feedbackapp.dao; 
import com.makmohank.feedbackapp.database.DatabaseUtil; 
import com.makmohank.feedbackapp.model.Feedback; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class FeedbackDAO { 
    private static final Logger LOGGER = Logger.getLogger(FeedbackDAO.class.getName()); 
    public void saveFeedback(Feedback feedback) { 
        String sql = "INSERT INTO feedback (username, email, phone, comments, rating) VALUES (?, ?, ?, ?, ?)"; 
        try (Connection connection = DatabaseUtil.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) { 
            statement.setString(1, feedback.getUsername()); 
            statement.setString(2, feedback.getEmail()); 
            statement.setString(3, feedback.getPhone()); 
            statement.setString(4, feedback.getComments()); 
            statement.setInt(5, feedback.getRating()); 
            statement.executeUpdate(); 
            LOGGER.info("Feedback data saved to the database successfully."); 
        } catch (SQLException e) { 
            LOGGER.log(Level.SEVERE, "Error saving feedback to the database: {0}", e.getMessage()); 
        } 
    } 
    public List<Feedback> getAllFeedback() { 
        List<Feedback> feedbackList = new ArrayList<>(); 
        String sql = "SELECT username, email, phone, comments, rating FROM feedback"; 
        try (Connection connection = DatabaseUtil.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql); 
             ResultSet resultSet = statement.executeQuery()) { 
            while (resultSet.next()) { 
                Feedback feedback = new Feedback( 
                    resultSet.getString("username"), 
                    resultSet.getString("email"), 
                    resultSet.getString("phone"), 
                    resultSet.getString("comments"), 
                    resultSet.getInt("rating") 
                ); 
                feedbackList.add(feedback); 
            } 
            LOGGER.info("Feedback data retrieved successfully."); 
        } catch (SQLException e) { 
            LOGGER.log(Level.SEVERE, "Error retrieving feedback from the database: {0}", e.getMessage()); 
        } 
        return feedbackList; 
    } 
} 