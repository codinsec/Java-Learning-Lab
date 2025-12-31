# Section 6: Web Development (Spring Boot)

## Overview
This section covers building RESTful web applications with Spring Boot. You'll learn how to create REST APIs, handle requests/responses, implement security, and manage cross-cutting concerns.

## Learning Path
This section consists of 4 topics that should be completed in order:

1. **[25-Spring-Boot-REST-Controllers](./25-Spring-Boot-REST-Controllers/)** - Building REST APIs
2. **[26-Request-Response-DTO-Mapping](./26-Request-Response-DTO-Mapping/)** - DTOs and MapStruct
3. **[27-Filters-Interceptors-Aspects](./27-Filters-Interceptors-Aspects/)** - Cross-cutting concerns
4. **[28-Spring-Security-JWT-OAuth2](./28-Spring-Security-JWT-OAuth2/)** - Application security

## Prerequisites
- Completion of Section 1: Fundamentals
- Completion of Section 2: Object-Oriented Programming
- Completion of Section 4: Java Ecosystem (Spring Context)
- Completion of Section 5: Data Access (Spring Data JPA)
- Basic understanding of HTTP and REST principles

## Learning Objectives
By the end of this section, you will be able to:
- ✅ Build RESTful APIs with Spring Boot
- ✅ Use DTOs for request/response mapping
- ✅ Implement filters, interceptors, and aspects
- ✅ Secure applications with Spring Security
- ✅ Implement JWT authentication

## Key Concepts

### REST APIs
- **REST Principles**: Stateless, resource-based, HTTP methods
- **Controllers**: @RestController, @RequestMapping
- **HTTP Methods**: GET, POST, PUT, DELETE, PATCH
- **Status Codes**: 200, 201, 404, 500, etc.

### DTOs and Mapping
- **DTO Pattern**: Separate API contracts from entities
- **MapStruct**: Compile-time mapping generation
- **Benefits**: Security, performance, versioning

### Cross-Cutting Concerns
- **Filters**: Servlet-level processing
- **Interceptors**: Spring MVC-level processing
- **Aspects**: Method-level processing (AOP)

### Security
- **Authentication**: Verifying user identity
- **Authorization**: Controlling access to resources
- **JWT**: Stateless token-based authentication
- **OAuth2**: Delegated authorization protocol

## How to Use This Section

1. **Follow the sequence** - Complete topics in order (25 → 28)
2. **Read the README** - Each topic has detailed explanations
3. **Run the examples** - Start Spring Boot applications
4. **Test endpoints** - Use Postman or curl to test APIs
5. **Understand security** - Learn authentication and authorization

## Project Structure
Each topic contains:
- `pom.xml` - Spring Boot project with dependencies
- `README.md` - Topic-specific documentation
- `src/main/java/` - Application code
- `src/main/resources/` - Configuration files

## Running Applications
All Spring Boot applications can be run with:
```bash
mvn spring-boot:run
```

Default port is 8080. Access endpoints at `http://localhost:8080`

## Next Steps
After completing this section, proceed to:
- **Section 7: Testing & Architecture** - JUnit, Mockito, SOLID, Design Patterns

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

