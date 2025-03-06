package com.example.feedback; 
import org.junit.Test; 
import static org.junit.Assert.*; 
import java.sql.Connection; 
import java.sql.SQLException; 
import com.example.feedbackapp.DatabaseConnection; 
public class DatabaseConnectionTest { 
    @Test 
    public void testDatabaseConnection() { 
        DatabaseConnection dbConnection = new DatabaseConnection(); 
        Connection connection = null; 
        try { 
            connection = dbConnection.getConnection(); 
            assertNotNull("Database connection should be established", connection); 
        } catch (SQLException e) { 
            fail("SQLException was thrown: " + e.getMessage()); 
        } finally { 
            if (connection != null) { 
                try { 
                    connection.close(); 
                } catch (SQLException e) { 
                    System.err.println("Failed to close the connection: " + e.getMessage()); 
                } 
            } 
        } 
    } 
    @Test 
    public void testDatabaseConnectionFailure() { 
        DatabaseConnection dbConnection = new DatabaseConnection(); 
        dbConnection.setDbName("invalid_db_name"); // Simulate failure by using an invalid database name 
        Connection connection = null; 
        try { 
            connection = dbConnection.getConnection(); 
            assertNull("Database connection should not be established", connection); 
        } catch (SQLException e) { 
            System.out.println("Expected failure: " + e.getMessage()); 
        } finally { 
            if (connection != null) { 
                try { 
                    connection.close(); 
                } catch (SQLException e) { 
                    System.err.println("Failed to close the connection: " + e.getMessage()); 
                } 
            } 
        } 
    } 
} 