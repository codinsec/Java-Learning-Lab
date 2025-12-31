# Serialization with Jackson and JSON

## Overview
This topic covers JSON serialization and deserialization using Jackson library. You'll learn how to convert Java objects to JSON and vice versa.

## Learning Objectives
- Understand JSON format and structure
- Learn Jackson ObjectMapper
- Master serialization and deserialization
- Understand Jackson annotations
- Learn about custom serializers and deserializers

## Topics Covered
1. **JSON Basics**: Structure, data types
2. **ObjectMapper**: Core Jackson class for JSON processing
3. **Annotations**: @JsonProperty, @JsonIgnore, @JsonFormat
4. **Custom Serialization**: Custom serializers and deserializers
5. **Advanced Features**: Polymorphism, tree model, streaming API

## Code Examples

### Basic Serialization
```java
ObjectMapper mapper = new ObjectMapper();
String json = mapper.writeValueAsString(user);
```

### Basic Deserialization
```java
ObjectMapper mapper = new ObjectMapper();
User user = mapper.readValue(json, User.class);
```

### Annotations
```java
class User {
    @JsonProperty("user_name")
    private String name;
    
    @JsonIgnore
    private String password;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
}
```

## How to Run

### Using Maven
```bash
cd 20-Serialization-Jackson-JSON
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.json.JsonDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `JsonDemo.java`
3. Run the main method

## Key Concepts

### Serialization
- **Object to JSON**: Convert Java object to JSON string
- **Use Cases**: API responses, data storage, inter-service communication

### Deserialization
- **JSON to Object**: Convert JSON string to Java object
- **Use Cases**: API requests, reading configuration, data import

### Jackson Annotations
- **@JsonProperty**: Custom property name
- **@JsonIgnore**: Exclude from serialization
- **@JsonFormat**: Format dates, numbers
- **@JsonInclude**: Include only non-null values

### ObjectMapper
- **Thread-safe**: Can be shared across threads
- **Configurable**: Custom serialization features
- **Flexible**: Supports various data formats

## Exercises
1. Serialize/deserialize complex nested objects
2. Use annotations to customize JSON structure
3. Handle date/time serialization
4. Implement custom serializer for special types

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

