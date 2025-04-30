package com.makmohank.feedbackapp.database; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class DatabaseUtil { 
    private static final String DB_URL = "jdbc:mysql://localhost:3307/feedback_db"; 
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = ""; // INPUT_REQUIRED {Set the database password} 
    private static final Logger LOGGER = Logger.getLogger(DatabaseUtil.class.getName()); 
    public static Connection getConnection() { 
        try { 
            LOGGER.info("Attempting to connect to the database."); 
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
            LOGGER.info("Database connection established successfully."); 
            return connection; 
        } catch (SQLException e) { 
            LOGGER.log(Level.SEVERE, "Failed to connect to the database: {0}", e.getMessage()); 
            LOGGER.log(Level.SEVERE, "Error details: ", e); 
            return null; 
        } 
    } 
} 