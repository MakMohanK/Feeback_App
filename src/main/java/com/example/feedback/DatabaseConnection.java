package com.example.feedback; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class DatabaseConnection { 
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName()); 
    private static final String DB_URL = "jdbc:mysql://localhost:3307/feedback_db"; 
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = ""; // INPUT_REQUIRED {Set the database password} 
    public Connection getConnection() { 
        Connection connection = null; 
        try { 
            logger.info("Attempting to establish a database connection."); 
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
            logger.info("Database connection established successfully."); 
        } catch (SQLException e) { 
            logger.log(Level.SEVERE, "Failed to establish a database connection: {0}", e.toString()); 
        } 
        return connection; 
    } 
} 