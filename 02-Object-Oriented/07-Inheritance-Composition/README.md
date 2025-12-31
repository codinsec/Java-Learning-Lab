# Inheritance and Composition

## Overview
This topic covers two fundamental relationships in object-oriented programming: inheritance (IS-A) and composition (HAS-A). You'll learn when to use each approach and understand their differences.

## Learning Objectives
- Understand inheritance and the `extends` keyword
- Learn about method overriding and `super` keyword
- Master composition relationships
- Understand when to use inheritance vs composition
- Learn about the `final` keyword

## Topics Covered
1. **Inheritance**: IS-A relationship, `extends` keyword
2. **Method Overriding**: `@Override` annotation, `super` keyword
3. **Composition**: HAS-A relationship, object references
4. **Inheritance vs Composition**: When to use which
5. **Final Keyword**: Preventing inheritance and overriding

## Code Examples

### Inheritance
```java
class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```

### Composition
```java
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;  // Composition
    
    public Car() {
        this.engine = new Engine();
    }
    
    public void start() {
        engine.start();
    }
}
```

## How to Run

### Using Maven
```bash
cd 07-Inheritance-Composition
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.inheritance.InheritanceDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `InheritanceDemo.java`
3. Run the main method

## Key Concepts

### Inheritance (IS-A)
- **Purpose**: Code reuse, polymorphism
- **Keyword**: `extends`
- **Relationship**: Child class IS-A parent class
- **Example**: `Dog extends Animal` means Dog IS-A Animal

### Composition (HAS-A)
- **Purpose**: Building complex objects from simpler ones
- **Relationship**: One class HAS-A reference to another
- **Example**: `Car HAS-A Engine`

### When to Use
- **Inheritance**: When there's a clear IS-A relationship and you need polymorphism
- **Composition**: When you need flexibility and want to avoid tight coupling

### Method Overriding
- Use `@Override` annotation
- Use `super` to call parent class methods
- Method signature must match parent class

## Exercises
1. Create an `Animal` hierarchy (Mammal, Bird, Fish) using inheritance
2. Build a `Computer` class using composition (CPU, RAM, HardDrive)
3. Implement a `Vehicle` hierarchy with method overriding
4. Compare inheritance vs composition for a `Library` system

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

