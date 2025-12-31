package com.learning.lab.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Demonstrates logging with SLF4J and Log4j2
 */
public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
    
    public static void main(String[] args) {
        System.out.println("=== SLF4J and Log4j2 Logging Demo ===\n");
        
        // Different log levels
        demonstrateLogLevels();
        
        // Parameterized logging
        demonstrateParameterizedLogging();
        
        // Exception logging
        demonstrateExceptionLogging();
        
        // MDC (Mapped Diagnostic Context)
        demonstrateMDC();
    }
    
    private static void demonstrateLogLevels() {
        System.out.println("--- Log Levels ---");
        
        logger.trace("This is a TRACE message");
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        
        System.out.println();
    }
    
    private static void demonstrateParameterizedLogging() {
        System.out.println("--- Parameterized Logging ---");
        
        String username = "Alice";
        int userId = 12345;
        String action = "login";
        
        // Parameterized logging (efficient, no string concatenation)
        logger.info("User {} (ID: {}) performed action: {}", username, userId, action);
        
        // Multiple parameters
        logger.debug("Processing request for user: {}, with {} items", username, 5);
        
        // Conditional logging
        if (logger.isDebugEnabled()) {
            logger.debug("Detailed debug information: {}", getComplexDebugInfo());
        }
        
        System.out.println();
    }
    
    private static void demonstrateExceptionLogging() {
        System.out.println("--- Exception Logging ---");
        
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Log exception with message
            logger.error("Division by zero occurred", e);
            
            // Log exception with custom message
            logger.error("Error processing calculation: {}", e.getMessage(), e);
        }
        
        System.out.println();
    }
    
    private static void demonstrateMDC() {
        System.out.println("--- MDC (Mapped Diagnostic Context) ---");
        
        // Set context information
        MDC.put("userId", "12345");
        MDC.put("requestId", "req-001");
        MDC.put("sessionId", "sess-abc");
        
        logger.info("Processing user request");
        logger.debug("Fetching user data");
        logger.info("Request completed successfully");
        
        // Clear MDC
        MDC.clear();
        
        logger.info("MDC cleared, this log won't have context");
        
        System.out.println();
    }
    
    private static String getComplexDebugInfo() {
        // Simulate expensive operation
        return "Complex debug information";
    }
}

