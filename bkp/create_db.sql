-- Create a database if it doesn't already exist
CREATE DATABASE IF NOT EXISTS feedback_db;

-- Use the feedback_db database
USE feedback_db;

-- Create a feedback table (example schema, adapt as needed)
CREATE TABLE IF NOT EXISTS feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    feedback_text TEXT,
    submission_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- You can add more tables, relationships, and other schema definitions here if needed
