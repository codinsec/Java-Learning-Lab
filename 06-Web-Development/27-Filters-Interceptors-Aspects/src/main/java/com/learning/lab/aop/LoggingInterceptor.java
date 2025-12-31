package com.learning.lab.aop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Demonstrates Spring Interceptor
 * Interceptors execute before/after controller method execution
 */
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, 
                           HttpServletResponse response, Object handler) {
        System.out.println("Interceptor: Pre-handle - " + request.getRequestURI());
        return true; // Continue processing
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, 
                               HttpServletResponse response, Object handler, 
                               Exception ex) {
        System.out.println("Interceptor: After completion - " + request.getRequestURI());
    }
}

