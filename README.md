# Feedback Management System

## Overview

The Feedback Management System is a web application developed using Flask, a lightweight web framework for Python. It allows users to submit feedback through a web-based form, which is then stored in a MySQL database. The system provides a user-friendly interface for submitting feedback, ensuring data integrity through form validation. Administrators can view submitted feedback entries, facilitating efficient feedback management.

## File Structure

- `feedback_app/app.py`: Main entry point for the Flask application, defining routes and handling requests.
- `feedback_app/forms.py`: Defines the feedback form using Flask-WTF for form handling and validation.
- `feedback_app/db.py`: Manages the connection to the MySQL database using PyMySQL.
- `feedback_app/templates`: Contains HTML templates for rendering the home page, feedback form, and feedback list.
- `feedback_app/static/css/styles.css`: Stylesheet for the application's visual presentation.

## Features

- **Feedback Submission**: Users can submit feedback through a form with fields for first name, last name, email, phone number, comments, and a star rating.
- **Form Validation**: Ensures data integrity and provides user-friendly error messages.
- **Data Storage**: Feedback data is securely stored in a MySQL database.
- **Feedback Viewing**: Users can view a list of all submitted feedback entries, including first name, last name, email, comments, and star rating.

## Getting Started

### Requirements

To run the Feedback application, ensure the following technologies are installed on your computer:

- Python 3.x
- Flask
- Flask-WTF
- PyMySQL
- MySQL
- PHPMyAdmin

### Quickstart

1. **Set up the Python environment**: Ensure Python 3.x is installed on your system.

2. **Install required Python packages**: Run the following commands to install the necessary Python packages:

   ```bash
   pip install Flask
   pip install Flask-WTF
   pip install PyMySQL
   ```

3. **Set up the MySQL database**:

   - Use PHPMyAdmin to create a database named `feedback_db`.
   - Ensure the database configuration in `feedback_app/db.py` matches your setup (host, user, password, and port).

4. **Run the Flask application**:

   Navigate to the project root directory and execute the following command:

   ```bash
   python feedback_app/app.py
   ```

   The application will start on `http://localhost:5001`.

5. **Access the application**:

   - Visit `http://localhost:5001` in your web browser to access the application.

## Updates

- The feedback form has been updated to include 'First Name' and 'Last Name' fields to enhance user identification.

## Conclusion

The Feedback Management System is designed to streamline the process of feedback collection and storage, making it easier for organizations to gather and analyze user input. By leveraging Flask and MySQL, the project aims to provide a scalable and maintainable solution for collecting and managing user feedback.