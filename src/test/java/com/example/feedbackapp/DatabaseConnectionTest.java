package com.example.feedbackapp; 
import org.junit.Test; 
import static org.junit.Assert.*; 
import java.sql.Connection; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class DatabaseConnectionTest { 
    private static final Logger logger = Logger.getLogger(DatabaseConnectionTest.class.getName()); 
    @Test 
    public void testDatabaseConnection() { 
        DatabaseConnection dbConnection = new DatabaseConnection(); 
        Connection connection = null; 
        try { 
            connection = dbConnection.getConnection(); 
            assertNotNull("Database connection should be established", connection); 
            logger.info("Database connection established successfully."); 
        } catch (Exception e) { 
            logger.log(Level.SEVERE, "Error establishing database connection: ", e); 
            fail("Exception thrown while establishing database connection: " + e.getMessage()); 
        } finally { 
            if (connection != null) { 
                try { 
                    connection.close(); 
                    logger.info("Database connection closed successfully."); 
                } catch (SQLException e) { 
                    logger.log(Level.SEVERE, "Error closing database connection: ", e); 
                } 
            } 
        } 
    } 
    // Add more tests to simulate database operations and error handling 
} 