-- SQL script to create the database and table 
-- Replace DB_NAME with your actual database name 
CREATE DATABASE IF NOT EXISTS `feedback_db`; 
USE `feedback_db`; 
-- Create feedback table 
CREATE TABLE IF NOT EXISTS `feedback` ( 
    `id` INT AUTO_INCREMENT PRIMARY KEY, 
    `first_name` VARCHAR(100) NOT NULL, 
    `last_name` VARCHAR(100) NOT NULL, 
    `email` VARCHAR(255) NOT NULL, 
    `phone` VARCHAR(15) NOT NULL,  -- Added phone field 
    `comments` TEXT NOT NULL,      -- Renamed feedback to comments 
    `rating` INT NOT NULL,         -- Added rating field 
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
); 
-- You can add more tables or modify this structure based on requirements.