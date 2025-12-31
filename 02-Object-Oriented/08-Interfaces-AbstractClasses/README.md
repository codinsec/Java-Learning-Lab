# Interfaces and Abstract Classes

## Overview
This topic covers interfaces and abstract classes in Java, two mechanisms for achieving abstraction and defining contracts that classes must follow.

## Learning Objectives
- Understand interfaces and the `implements` keyword
- Learn about abstract classes and the `abstract` keyword
- Master default and static methods in interfaces (Java 8+)
- Understand when to use interfaces vs abstract classes
- Learn about multiple interface implementation

## Topics Covered
1. **Interfaces**: Contract definition, `implements` keyword
2. **Abstract Classes**: Partial implementation, `abstract` keyword
3. **Default Methods**: Interface methods with implementation (Java 8+)
4. **Static Methods**: Interface-level utility methods (Java 8+)
5. **Multiple Inheritance**: Implementing multiple interfaces

## Code Examples

### Interface
```java
interface Drawable {
    void draw();
    default void display() {
        System.out.println("Displaying...");
    }
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
```

### Abstract Class
```java
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    abstract double getArea();
    
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
```

## How to Run

### Using Maven
```bash
cd 08-Interfaces-AbstractClasses
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.interfaces.InterfacesDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `InterfacesDemo.java`
3. Run the main method

## Key Concepts

### Interfaces
- **Purpose**: Define contracts (what, not how)
- **Keyword**: `implements`
- **All methods**: Public and abstract (before Java 8)
- **Fields**: Public, static, and final (constants)
- **Java 8+**: Can have default and static methods

### Abstract Classes
- **Purpose**: Provide partial implementation
- **Keyword**: `abstract`
- **Can have**: Both abstract and concrete methods
- **Can have**: Instance fields and constructors
- **Cannot**: Be instantiated directly

### When to Use
- **Interface**: When you need to define a contract, multiple inheritance
- **Abstract Class**: When you have shared code and need partial implementation

### Default Methods (Java 8+)
- Provide default implementation in interfaces
- Can be overridden by implementing classes
- Useful for backward compatibility

## Exercises
1. Create a `Payment` interface with multiple implementations (CreditCard, PayPal)
2. Build an abstract `Vehicle` class with concrete and abstract methods
3. Implement a `Logger` interface with default methods
4. Create a shape hierarchy using abstract classes and interfaces

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

