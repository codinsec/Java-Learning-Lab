# Spring Security JWT and OAuth2

## Overview
This topic covers securing Spring Boot applications with Spring Security, including JWT (JSON Web Tokens) authentication and OAuth2 authorization.

## Learning Objectives
- Understand authentication vs authorization
- Learn Spring Security configuration
- Master JWT token generation and validation
- Understand OAuth2 flow
- Learn about security best practices

## Topics Covered
1. **Spring Security Basics**: Authentication, authorization, filters
2. **JWT Authentication**: Token generation, validation, refresh tokens
3. **OAuth2**: Authorization code flow, client credentials
4. **Security Configuration**: @EnableWebSecurity, SecurityFilterChain
5. **Best Practices**: Password hashing, token expiration, HTTPS

## Code Examples

### Security Configuration
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/public/**").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}
```

### JWT Token Generation
```java
String token = Jwts.builder()
    .setSubject(username)
    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
    .signWith(SignatureAlgorithm.HS512, secretKey)
    .compact();
```

## How to Run

### Using Maven
```bash
cd 28-Spring-Security-JWT-OAuth2
mvn spring-boot:run
```

### Using IDE
1. Open the project in your IDE
2. Run `SecurityApplication.java` as Spring Boot application
3. Test endpoints with authentication

## Key Concepts

### Authentication vs Authorization
- **Authentication**: Who you are (login)
- **Authorization**: What you can do (permissions)

### JWT Structure
- **Header**: Algorithm and token type
- **Payload**: Claims (user info, expiration)
- **Signature**: Verification

### OAuth2 Roles
- **Resource Owner**: User
- **Client**: Application
- **Authorization Server**: Issues tokens
- **Resource Server**: Protected resources

### Security Best Practices
- Use HTTPS in production
- Hash passwords (BCrypt)
- Set token expiration
- Validate tokens on every request
- Use refresh tokens

## Exercises
1. Implement JWT authentication
2. Create role-based authorization
3. Add refresh token mechanism
4. Configure OAuth2 with Google/GitHub

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

