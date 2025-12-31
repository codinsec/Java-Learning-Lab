package com.learning.lab.security;

import org.springframework.web.bind.annotation.*;

/**
 * Demonstrates authentication endpoints
 * In a real application, this would generate and validate JWT tokens
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // In real application:
        // 1. Validate credentials
        // 2. Generate JWT token
        // 3. Return token
        
        return "JWT token would be returned here";
    }
    
    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }
}

class LoginRequest {
    private String username;
    private String password;
    
    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

