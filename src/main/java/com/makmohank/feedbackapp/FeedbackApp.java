package com.makmohank.feedbackapp; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@SpringBootApplication 
public class FeedbackApp { 
    private static final Logger logger = LoggerFactory.getLogger(FeedbackApp.class); 
    public static void main(String[] args) { 
        try { 
            logger.info("Starting FeedbackApp application."); 
            SpringApplication.run(FeedbackApp.class, args); 
            logger.info("FeedbackApp application started successfully."); 
        } catch (Exception e) { 
            logger.error("Error starting FeedbackApp application: ", e); 
        } 
    } 
} 