# Flask Feedback Capture Application

This is a simple Flask-based web application that captures user feedback through a web form and displays the submitted feedback.

## Features
- User-friendly feedback form for capturing feedback.
- In-memory storage for feedback (can be extended to use a database).
- Displays all submitted feedback on a separate page.

## Prerequisites
- Python (3.7 or later)
- Flask library

## Setup Instructions

1. **Clone or Download the Repository:**
   - Download this project or clone it using Git:
     ```bash
     git clone <repository_url>
     ```

2. **Install Dependencies:**
   - Install Flask using pip:
     ```bash
     pip install flask
     ```

3. **Create the Required File Structure:**
   - Ensure the following file structure:
     ```
     project_directory/
     |-- app.py
     |-- bkp/
         |-- templates/
             |-- base.html
             |-- feedback_form.html
             |-- home.html
         |-- styles.css
     |-- static/
     |-- templates/
         |-- base.html
         |-- feedback_form.html
         |-- home.html
     ```

4. **Run the Application:**
   - Navigate to the project directory and run the app:
     ```bash
     python app.py
     ```

5. **Access the Application:**
   - Open a browser and navigate to:
     ```
     http://127.0.0.1:5000/
     ```

## File Descriptions
- `app.py`: Main Python script for the Flask application.

## Application Workflow
1. The user accesses the home page and fills out the feedback form.
2. On submission, the feedback is stored in an in-memory list.
3. The user is redirected to the feedback display page where all feedback is listed.

## Future Enhancements
- **Database Integration:** Use a database like SQLite or MySQL for persistent storage.
- **Authentication:** Add user login and authentication for secure feedback submission.
- **Styling:** Improve UI using CSS or a framework like Bootstrap.

## License
This project is open-source and available under the MIT License.

