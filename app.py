from flask import Flask, render_template, request, redirect, url_for, flash 
import logging 
import traceback 
import mysql.connector 
from mysql.connector import Error 
 
# Initialize the Flask application 
app = Flask(__name__) 
app.secret_key = 'just_a_67890'  # Necessary for flashing messages 
 
# Configure logging 
logging.basicConfig(level=logging.INFO) 
logger = logging.getLogger(__name__) 
 
# Database configuration 
db_config = { 
    'user': 'root', 
    'host': '127.0.0.1', 
    'port': '3306', 
    'database': 'feedback_db',  # Ensure this database exists 
    'raise_on_warnings': True 
} 
 
@app.route('/') 
def home(): 
    try: 
        logger.info("Rendering home page") 
        return render_template('home.html') 
    except Exception as e: 
        logger.error("Error rendering home page: %s", traceback.format_exc()) 
        return "An error occurred while loading the home page.", 500 
 
@app.route('/feedback-form', methods=['GET', 'POST']) 
def feedback_form(): 
    try: 
        if request.method == 'POST': 
            username = request.form.get('username') 
            email = request.form.get('email') 
            phone_number = request.form.get('phone_number') 
            comments = request.form.get('comments') 
            star_rating = request.form.get('star_rating') 
 
            # Validate form fields 
            if not username or not email or not phone_number or not comments or not star_rating: 
                flash('All fields are required!', 'error') 
                return redirect(url_for('feedback_form')) 
 
            # Validate email format 
            if '@' not in email or '.' not in email: 
                flash('Invalid email format!', 'error') 
                return redirect(url_for('feedback_form')) 
 
            # Validate phone number format (basic example) 
            if not phone_number.isdigit() or len(phone_number) < 10: 
                flash('Invalid phone number format!', 'error') 
                return redirect(url_for('feedback_form')) 
 
            # Insert feedback into the database 
            try: 
                connection = mysql.connector.connect(**db_config) 
                cursor = connection.cursor() 
                insert_query = """ 
                INSERT INTO feedback (username, email, phone_number, comments, star_rating) 
                VALUES (%s, %s, %s, %s, %s) 
                """ 
                cursor.execute(insert_query, (username, email, phone_number, comments, int(star_rating))) 
                connection.commit() 
                flash('Feedback submitted successfully!', 'success') 
            except Error as e: 
                logger.error("Error inserting feedback: %s", str(e)) 
                flash('An error occurred while submitting feedback.', 'error') 
            finally: 
                if connection.is_connected(): 
                    cursor.close() 
                    connection.close() 
 
            return redirect(url_for('feedback_form')) 
 
        logger.info("Rendering feedback form page") 
        return render_template('feedback_form.html') 
    except Exception as e: 
        logger.error("Error processing feedback form: %s", traceback.format_exc()) 
        return "An error occurred while processing the feedback form.", 500 
 
@app.route('/feedback-listing') 
def feedback_listing(): 
    try: 
        logger.info("Rendering feedback listing page") 
        # Placeholder for feedback listing page 
        return "Feedback Listing Page" 
    except Exception as e: 
        logger.error("Error rendering feedback listing page: %s", traceback.format_exc()) 
        return "An error occurred while loading the feedback listing page.", 500 
 
if __name__ == '__main__': 
    try: 
        logger.info("Starting the Flask application") 
        app.run(port=8000, debug=True) 
    except Exception as e: 
        logger.error("Error starting the Flask application: %s", traceback.format_exc())
