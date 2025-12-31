# Enums, Records, and Sealed Classes

## Overview
This topic covers modern Java features (Java 5+, 14+, 17+) that enhance type safety and code clarity: enums for constants, records for immutable data, and sealed classes for controlled inheritance.

## Learning Objectives
- Understand enums and their use cases
- Learn about enum methods and constants
- Master records for immutable data classes
- Understand sealed classes and interfaces (Java 17+)
- Learn when to use each feature

## Topics Covered
1. **Enums**: Type-safe constants, enum methods, enum with fields
2. **Records** (Java 14+): Immutable data classes, compact constructors
3. **Sealed Classes** (Java 17+): Controlled inheritance, permits clause
4. **Pattern Matching**: Enhanced switch with enums and sealed classes

## Code Examples

### Enum
```java
enum Status {
    PENDING, APPROVED, REJECTED;
    
    public boolean isActive() {
        return this == APPROVED;
    }
}
```

### Record
```java
record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
    }
}
```

### Sealed Class
```java
sealed class Shape permits Circle, Rectangle {
    abstract double area();
}

final class Circle extends Shape {
    private double radius;
    // ...
}
```

## How to Run

### Using Maven
```bash
cd 10-Enums-Records-SealedClasses
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.modern.ModernJavaDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ModernJavaDemo.java`
3. Run the main method

## Key Concepts

### Enums
- **Purpose**: Type-safe constants
- **Benefits**: Compile-time checking, can have methods and fields
- **Use Cases**: Status values, configuration options, fixed sets

### Records (Java 14+)
- **Purpose**: Immutable data carriers
- **Auto-generated**: Constructor, getters, equals, hashCode, toString
- **Use Cases**: DTOs, value objects, data transfer

### Sealed Classes (Java 17+)
- **Purpose**: Controlled inheritance hierarchy
- **Keyword**: `sealed`, `permits`
- **Use Cases**: When you want to limit which classes can extend a base class

## Exercises
1. Create a `Priority` enum with methods
2. Build a `Point` record for 2D coordinates
3. Implement a sealed `PaymentMethod` hierarchy
4. Use pattern matching with enums in switch expressions

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

