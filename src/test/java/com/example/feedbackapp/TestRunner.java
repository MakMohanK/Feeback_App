package com.example.feedbackapp; 
import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure; 
public class TestRunner { 
    public static void main(String[] args) { 
        System.out.println("Starting test execution..."); 
        Result result = JUnitCore.runClasses(FeedbackFormTest.class, DatabaseConnectionTest.class); 
        System.out.println("Test execution completed. Processing results..."); 
        for (Failure failure : result.getFailures()) { 
            System.err.println("Test failed: " + failure.toString()); 
        } 
        if (result.wasSuccessful()) { 
            System.out.println("All tests passed successfully."); 
        } else { 
            System.err.println("Some tests failed. Total failures: " + result.getFailureCount()); 
        } 
        System.out.println("Total tests run: " + result.getRunCount()); 
        System.out.println("Total tests ignored: " + result.getIgnoreCount()); 
        System.out.println("Total time taken: " + result.getRunTime() + "ms"); 
    } 
} 