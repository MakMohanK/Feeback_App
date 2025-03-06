package com.feedbackapp.util; 
import java.sql.Connection; 
import java.sql.SQLException; 
import org.apache.commons.dbcp2.BasicDataSource; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class DatabaseConnectionPool { 
    private static final Logger logger = Logger.getLogger(DatabaseConnectionPool.class.getName()); 
    private static BasicDataSource dataSource; 
    static { 
        try { 
            dataSource = new BasicDataSource(); 
            dataSource.setUrl("jdbc:mysql://localhost:3307/feedback_db"); 
            dataSource.setUsername("root"); 
            dataSource.setPassword(""); // INPUT_REQUIRED {Set the database password} 
            dataSource.setMinIdle(5); 
            dataSource.setMaxIdle(10); 
            dataSource.setMaxOpenPreparedStatements(100); 
            logger.info("Database connection pool initialized successfully."); 
        } catch (Exception e) { 
            logger.log(Level.SEVERE, "Error initializing database connection pool: ", e); 
        } 
    } 
    public static Connection getConnection() throws SQLException { 
        try { 
            logger.info("Attempting to get a connection from the pool."); 
            Connection connection = dataSource.getConnection(); 
            logger.info("Connection obtained successfully."); 
            return connection; 
        } catch (SQLException e) { 
            logger.log(Level.SEVERE, "Error obtaining connection from the pool: ", e); 
            throw e; 
        } 
    } 
} 