import pymysql
import logging
import traceback

DB_HOST = 'localhost'
DB_USER = 'root'
DB_PASSWORD = 'your_password_here'
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
    except pymysql.MySQLError as e:
        logging.error("MySQL error occurred: %s", e)
        return None
    except Exception as e:
        logging.error("An unexpected error occurred: %s", traceback.format_exc())
        return None

def alter_feedback_table():
    connection = get_db_connection()
    if connection:
        try:
            with connection.cursor() as cursor:
                cursor.execute("ALTER TABLE feedback ADD COLUMN first_name VARCHAR(255), ADD COLUMN last_name VARCHAR(255)")
                connection.commit()
                logging.info("Table altered successfully to include first_name and last_name columns.")
        except pymysql.MySQLError as e:
            logging.error("Failed to alter table: %s", e)
        finally:
            connection.close()
    else:
        logging.error("No database connection available to alter table.")