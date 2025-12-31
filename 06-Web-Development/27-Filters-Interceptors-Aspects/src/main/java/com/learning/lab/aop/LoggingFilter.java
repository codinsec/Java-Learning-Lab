package com.learning.lab.aop;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Demonstrates Servlet Filter
 * Filters execute before/after servlet processing
 */
@Component
public class LoggingFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        
        System.out.println("Filter: Request received - " + 
                          ((jakarta.servlet.http.HttpServletRequest) request).getRequestURI());
        
        // Continue filter chain
        chain.doFilter(request, response);
        
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Filter: Request processed in " + duration + "ms");
    }
}

