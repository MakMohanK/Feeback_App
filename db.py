import pymysql 
import logging 
import traceback 
 
# Database configuration 
DB_HOST = 'localhost' 
DB_USER = 'root' 
DB_PASSWORD = ''  # INPUT_REQUIRED {Set the database password} 
DB_NAME = 'feedback_db' 
DB_PORT = 3307 
 
def get_db_connection(): 
    try: 
        logging.info("Attempting to connect to the database.") 
        connection = pymysql.connect( 
            host=DB_HOST, 
            user=DB_USER, 
            password=DB_PASSWORD, 
            database=DB_NAME, 
            port=DB_PORT, 
            cursorclass=pymysql.cursors.DictCursor 
        ) 
        logging.info("Database connection established successfully.") 
        return connection 
    except Exception as e: 
        logging.error("Failed to connect to the database: %s", traceback.format_exc()) 
        return None 
 
def save_user_theme(user_id, theme): 
    connection = get_db_connection() 
    if connection: 
        try: 
            with connection.cursor() as cursor: 
                sql = """ 
                INSERT INTO user_preferences (user_id, theme) 
                VALUES (%s, %s) 
                ON DUPLICATE KEY UPDATE theme = %s 
                """ 
                cursor.execute(sql, (user_id, theme, theme)) 
            connection.commit() 
            logging.info("User theme preference saved successfully.") 
        except Exception as e: 
            logging.error("Error saving user theme preference: %s", traceback.format_exc()) 
        finally: 
            connection.close() 
 
def get_user_theme(user_id): 
    connection = get_db_connection() 
    theme = 'default'  # Default theme 
    if connection: 
        try: 
            with connection.cursor() as cursor: 
                sql = "SELECT theme FROM user_preferences WHERE user_id = %s" 
                cursor.execute(sql, (user_id,)) 
                result = cursor.fetchone() 
                if result: 
                    theme = result['theme'] 
                logging.info("User theme preference retrieved successfully.") 
        except Exception as e: 
            logging.error("Error retrieving user theme preference: %s", traceback.format_exc()) 
        finally: 
            connection.close() 
    return theme