package com.makmohank.feedbackapp.servlet; 
import com.makmohank.feedbackapp.dao.FeedbackDao; 
import com.makmohank.feedbackapp.model.Feedback; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import java.io.IOException; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
@WebServlet("/feedback-list") 
public class FeedbackListServlet extends HttpServlet { 
    private static final Logger LOGGER = Logger.getLogger(FeedbackListServlet.class.getName()); 
    private FeedbackDao feedbackDao = new FeedbackDao(); 
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try { 
            LOGGER.info("Fetching feedback list from the database."); 
            List<Feedback> feedbackList = feedbackDao.getAllFeedback(); 
            request.setAttribute("feedbackList", feedbackList); 
            LOGGER.info("Feedback list retrieved successfully, forwarding to JSP."); 
            request.getRequestDispatcher("WEB-INF/views/feedbackList.jsp").forward(request, response); 
        } catch (Exception e) { 
            LOGGER.log(Level.SEVERE, "Error retrieving feedback list: ", e); 
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving the feedback list."); 
        } 
    } 
} 