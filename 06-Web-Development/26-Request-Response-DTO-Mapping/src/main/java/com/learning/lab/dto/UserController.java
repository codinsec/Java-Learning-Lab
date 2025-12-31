package com.learning.lab.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates DTO mapping with MapStruct
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserMapper userMapper;
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;
    
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
        // Initialize with sample data
        users.add(new User(nextId++, "Alice", "alice@example.com", "password123"));
    }
    
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        // Convert DTO to entity
        User user = userMapper.toEntity(request);
        user.setId(nextId++);
        users.add(user);
        
        // Convert entity to response DTO
        UserResponseDTO response = userMapper.toResponseDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        User user = users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
        
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        
        UserResponseDTO response = userMapper.toResponseDTO(user);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> responses = users.stream()
            .map(userMapper::toResponseDTO)
            .toList();
        return ResponseEntity.ok(responses);
    }
}

// ========== Entity ==========

class User {
    private Long id;
    private String name;
    private String email;
    private String password;  // Internal field, not exposed in DTO
    
    public User() {
    }
    
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

// ========== DTOs ==========

class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    // Note: password is NOT included in response DTO
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

