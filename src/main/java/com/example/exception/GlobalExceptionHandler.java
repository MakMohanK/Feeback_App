package com.example.exception; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
@ControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler { 
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class); 
    @ExceptionHandler(Exception.class) 
    public ResponseEntity<Object> handleAllExceptions(Exception ex) { 
        // Log the exception with full stack trace 
        logger.error("An unexpected error occurred: ", ex); 
        // Return a generic error message 
        return new ResponseEntity<>("An error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR); 
    } 
} 