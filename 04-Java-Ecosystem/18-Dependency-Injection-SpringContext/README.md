# Dependency Injection and Spring Context

## Overview
This topic covers Spring Framework's dependency injection (DI) and Inversion of Control (IoC) container. You'll learn how Spring manages object creation and dependencies.

## Learning Objectives
- Understand dependency injection concepts
- Learn Spring IoC container
- Master @Component, @Service, @Repository annotations
- Understand @Autowired and constructor injection
- Learn about Spring configuration (XML and Java-based)

## Topics Covered
1. **Dependency Injection**: Constructor, setter, field injection
2. **Spring Container**: ApplicationContext, BeanFactory
3. **Stereotype Annotations**: @Component, @Service, @Repository, @Controller
4. **Dependency Injection**: @Autowired, @Qualifier, @Primary
5. **Configuration**: @Configuration, @Bean, @ComponentScan

## Code Examples

### Component Annotation
```java
@Component
public class UserService {
    private final UserRepository repository;
    
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
```

### Configuration Class
```java
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource();
    }
}
```

### Using ApplicationContext
```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
UserService service = context.getBean(UserService.class);
```

## How to Run

### Using Maven
```bash
cd 18-Dependency-Injection-SpringContext
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.spring.SpringDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `SpringDemo.java`
3. Run the main method

## Key Concepts

### Dependency Injection Types
- **Constructor Injection**: Recommended, immutable dependencies
- **Setter Injection**: Optional dependencies
- **Field Injection**: Not recommended, but convenient

### Spring Annotations
- **@Component**: Generic Spring-managed component
- **@Service**: Business logic layer
- **@Repository**: Data access layer
- **@Controller**: Web controller layer
- **@Autowired**: Inject dependency

### IoC Container
- **ApplicationContext**: Full-featured container
- **BeanFactory**: Basic container
- **Bean Lifecycle**: Creation, initialization, destruction

### Benefits
- **Loose Coupling**: Dependencies injected, not hard-coded
- **Testability**: Easy to mock dependencies
- **Flexibility**: Change implementations easily

## Exercises
1. Create a service layer with dependency injection
2. Implement repository pattern with Spring
3. Use @Qualifier for multiple implementations
4. Configure Spring with Java configuration

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

