-- Add a new table to store user theme preferences 
CREATE TABLE IF NOT EXISTS user_preferences ( 
    id INT AUTO_INCREMENT PRIMARY KEY, 
    user_id INT NOT NULL, 
    theme VARCHAR(50) NOT NULL, 
    FOREIGN KEY (user_id) REFERENCES users(id) 
);