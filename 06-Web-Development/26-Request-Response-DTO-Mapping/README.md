# Request-Response DTO Mapping

## Overview
This topic covers Data Transfer Objects (DTOs) and mapping between entities and DTOs using MapStruct. DTOs are used to control what data is exposed in API responses and received in requests.

## Learning Objectives
- Understand DTO pattern and its benefits
- Learn to create request and response DTOs
- Master MapStruct for automatic mapping
- Understand when to use DTOs vs entities
- Learn about custom mapping strategies

## Topics Covered
1. **DTO Pattern**: Why use DTOs, separation of concerns
2. **Request DTOs**: Data received from clients
3. **Response DTOs**: Data sent to clients
4. **MapStruct**: Annotation-based mapping
5. **Custom Mappings**: Complex mapping scenarios

## Code Examples

### DTO Classes
```java
public class UserRequestDTO {
    private String name;
    private String email;
    // Getters and setters
}

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    // Getters and setters
}
```

### MapStruct Mapper
```java
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toResponseDTO(User user);
    User toEntity(UserRequestDTO dto);
}
```

### Using in Controller
```java
@PostMapping
public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
    User user = userMapper.toEntity(request);
    User saved = userService.save(user);
    return ResponseEntity.ok(userMapper.toResponseDTO(saved));
}
```

## How to Run

### Using Maven
```bash
cd 26-Request-Response-DTO-Mapping
mvn clean compile
mvn spring-boot:run
```

### Using IDE
1. Open the project in your IDE
2. Run `DtoApplication.java` as Spring Boot application
3. Access endpoints at `http://localhost:8080`

## Key Concepts

### Why DTOs?
- **Security**: Hide internal entity structure
- **Performance**: Transfer only needed data
- **Versioning**: Evolve API without changing entities
- **Validation**: Different validation rules for requests

### MapStruct Benefits
- **Compile-time**: No runtime overhead
- **Type-safe**: Compile-time checking
- **Automatic**: Generates mapping code
- **Customizable**: Custom mapping methods

### Mapping Strategies
- **Automatic**: Same field names
- **@Mapping**: Custom field mapping
- **Custom Methods**: Complex transformations
- **Multiple Sources**: Combine multiple objects

## Exercises
1. Create DTOs for a complex entity with relationships
2. Implement custom mapping for nested objects
3. Use MapStruct with different source/target types
4. Add validation to request DTOs

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

