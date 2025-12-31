# Design Patterns - Gang of Four

## Overview
This topic covers classic design patterns from the "Gang of Four" book. Design patterns are reusable solutions to common problems in software design.

## Learning Objectives
- Understand what design patterns are and when to use them
- Learn creational patterns (Singleton, Factory, Builder)
- Master structural patterns (Adapter, Decorator, Facade)
- Understand behavioral patterns (Observer, Strategy, Command)
- Learn to identify pattern opportunities

## Topics Covered
1. **Creational Patterns**: Singleton, Factory, Builder, Prototype
2. **Structural Patterns**: Adapter, Decorator, Facade, Proxy
3. **Behavioral Patterns**: Observer, Strategy, Command, Template Method
4. **Pattern Selection**: When to use which pattern
5. **Anti-patterns**: Common mistakes to avoid

## Code Examples

### Singleton Pattern
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() { }
    
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

### Factory Pattern
```java
public class ShapeFactory {
    public Shape createShape(String type) {
        return switch (type) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> throw new IllegalArgumentException();
        };
    }
}
```

### Observer Pattern
```java
public interface Observer {
    void update(String message);
}

public class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    
    public void notifyObservers(String news) {
        observers.forEach(o -> o.update(news));
    }
}
```

## How to Run

### Using Maven
```bash
cd 32-Design-Patterns-Gang-Of-Four
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.patterns.PatternsDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `PatternsDemo.java`
3. Run the main method

## Key Concepts

### Pattern Categories
- **Creational**: Object creation mechanisms
- **Structural**: Object composition and relationships
- **Behavioral**: Communication between objects

### When to Use Patterns
- **Recognize Problem**: Identify recurring problems
- **Pattern Match**: Find appropriate pattern
- **Apply Pattern**: Implement solution
- **Don't Overuse**: Not every problem needs a pattern

### Common Patterns
- **Singleton**: Single instance
- **Factory**: Create objects without specifying exact class
- **Observer**: One-to-many dependency
- **Strategy**: Encapsulate algorithms
- **Adapter**: Make incompatible interfaces work together

### Benefits
- **Reusability**: Proven solutions
- **Communication**: Common vocabulary
- **Maintainability**: Well-understood structure
- **Flexibility**: Easy to modify

## Exercises
1. Implement Singleton pattern with thread safety
2. Create a Factory for different payment methods
3. Implement Observer pattern for event notifications
4. Use Strategy pattern for sorting algorithms
5. Build an Adapter for legacy code integration

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

