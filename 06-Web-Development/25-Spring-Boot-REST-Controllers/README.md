# Spring Boot REST Controllers

## Overview
This topic covers building REST APIs with Spring Boot. You'll learn how to create REST controllers, handle HTTP requests, and return JSON responses.

## Learning Objectives
- Understand REST principles and HTTP methods
- Learn Spring Boot annotations (@RestController, @RequestMapping, etc.)
- Master request mapping and path variables
- Understand request/response handling
- Learn about exception handling in REST APIs

## Topics Covered
1. **REST Principles**: Resources, HTTP methods, status codes
2. **@RestController**: Creating REST endpoints
3. **Request Mapping**: @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
4. **Path Variables**: @PathVariable
5. **Request Parameters**: @RequestParam, @RequestBody
6. **Response Entity**: Custom HTTP responses

## Code Examples

### Basic REST Controller
```java
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }
}
```

### POST Request
```java
@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
    User created = userService.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
```

## How to Run

### Using Maven
```bash
cd 25-Spring-Boot-REST-Controllers
mvn spring-boot:run
```

### Using IDE
1. Open the project in your IDE
2. Run `RestApplication.java` as Spring Boot application
3. Access endpoints at `http://localhost:8080`

## Key Concepts

### REST Principles
- **Stateless**: Each request contains all information
- **Resource-based**: URLs represent resources
- **HTTP Methods**: GET, POST, PUT, DELETE, PATCH
- **Status Codes**: 200 OK, 201 Created, 404 Not Found, etc.

### Spring Boot Annotations
- **@RestController**: Combines @Controller and @ResponseBody
- **@RequestMapping**: Base URL mapping
- **@GetMapping, @PostMapping**: HTTP method-specific mappings
- **@PathVariable**: Extract path variables
- **@RequestParam**: Extract query parameters
- **@RequestBody**: Extract request body

### HTTP Methods
- **GET**: Retrieve resources
- **POST**: Create resources
- **PUT**: Update resources (full update)
- **PATCH**: Partial update
- **DELETE**: Delete resources

## Exercises
1. Create a complete CRUD REST API for a resource
2. Implement pagination and sorting
3. Add validation to request bodies
4. Create custom exception handlers

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

