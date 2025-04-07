feedback_app/app.py`: Main entry point for the Flask application, defining routes and handling requests, including new fields for first name and last name in form submissions.
- `feedback_app/forms.py`: Defines the feedback form using Flask-WTF, now including first name and last name fields for validation.
- `feedback_app/db.py`: Manages the connection to the MySQL database using PyMySQL, updated to accommodate new fields in the feedback table.
- `feedback_app/templates`: Contains HTML templates for rendering the home page, feedback form, and feedback list, updated to display first name and last name.
- `feedback_app/static/css/styles.css`: Stylesheet for the application's visual presentation.

## Features

- Submit feedback through a form with fields for first name, last name, username, email, phone number, comments, and star rating.
- Form validation to ensure data integrity and user-friendly error messages.
- Store feedback data in a MySQL database, including new fields for first name and last name.
- View all submitted feedback entries, including first name, last name, username, email, comments, and star rating.

## Getting started

### Requirements

To run the FeedBack application, you need to have the following technologies and tools installed on your computer:

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
   - Update the database schema to include `first_name` and `last_name` fields in the feedback table.

4. **Run the Flask application**:

   Navigate to the project root directory and execute the following command:

   ```bash
   python feedback_app/app.py
   ```

   The application will start on `http://localhost:5001`.

5. **Access the application**:

   - Visit `http://localhost:5001`