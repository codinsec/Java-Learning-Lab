package com.learning.lab.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo controller to demonstrate filters, interceptors, and aspects
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {
    
    @GetMapping("/test")
    @Loggable
    public String test() {
        return "Test endpoint - check logs for filter/interceptor/aspect execution";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello from controller";
    }
}

// Marker annotation for AOP
@interface Loggable {
}

