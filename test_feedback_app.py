import unittest 
from app import app 
from db import get_db_connection 
import logging 
import traceback 
class FeedbackAppTestCase(unittest.TestCase): 
    def setUp(self): 
        # Set up the test client 
        app.config['TESTING'] = True 
        self.client = app.test_client() 
        # Create a database connection for testing 
        self.connection = get_db_connection() 
        # Ensure the database is clean before each test 
        try: 
            with self.connection.cursor() as cursor: 
                cursor.execute("DELETE FROM feedback") 
            self.connection.commit() 
            logging.info("Database cleaned before test.") 
        except Exception as e: 
            logging.error("Error cleaning database before test: %s", traceback.format_exc()) 
    def tearDown(self): 
        # Clean up the database after each test 
        try: 
            with self.connection.cursor() as cursor: 
                cursor.execute("DELETE FROM feedback") 
            self.connection.commit() 
            logging.info("Database cleaned after test.") 
        except Exception as e: 
            logging.error("Error cleaning database after test: %s", traceback.format_exc()) 
        finally: 
            self.connection.close() 
    def test_feedback_submission(self): 
        # Test submitting feedback 
        try: 
            response = self.client.post('/feedback-form', data=dict( 
                first_name='John', 
                last_name='Doe', 
                email='john.doe@example.com', 
                phone='1234567890', 
                comments='Great service!', 
                rating=5 
            ), follow_redirects=True) 
            self.assertEqual(response.status_code, 200) 
            self.assertIn(b'Feedback submitted successfully!', response.data) 
            logging.info("Feedback submission test passed.") 
            # Verify the feedback is stored in the database 
            with self.connection.cursor() as cursor: 
                cursor.execute("SELECT * FROM feedback WHERE email=%s", ('john.doe@example.com',)) 
                result = cursor.fetchone() 
                self.assertIsNotNone(result) 
                self.assertEqual(result['first_name'], 'John') 
                self.assertEqual(result['last_name'], 'Doe') 
                self.assertEqual(result['comments'], 'Great service!') 
                self.assertEqual(result['rating'], 5) 
                logging.info("Feedback data verified in database.") 
        except Exception as e: 
            logging.error("Error during feedback submission test: %s", traceback.format_exc()) 
    def test_feedback_display(self): 
        # Insert a test feedback entry directly into the database 
        try: 
            with self.connection.cursor() as cursor: 
                cursor.execute(""" 
                    INSERT INTO feedback (first_name, last_name, email, phone, comments, rating) 
                    VALUES (%s, %s, %s, %s, %s, %s) 
                """, ('Jane', 'Smith', 'jane.smith@example.com', '0987654321', 'Excellent support!', 4)) 
            self.connection.commit() 
            logging.info("Test feedback entry inserted into database.") 
            # Test viewing feedback list 
            response = self.client.get('/feedback-list') 
            self.assertEqual(response.status_code, 200) 
            self.assertIn(b'Jane', response.data) 
            self.assertIn(b'Smith', response.data) 
            self.assertIn(b'Excellent support!', response.data) 
            self.assertIn(b'4', response.data) 
            logging.info("Feedback display test passed.") 
        except Exception as e: 
            logging.error("Error during feedback display test: %s", traceback.format_exc()) 
if __name__ == '__main__': 
    unittest.main()