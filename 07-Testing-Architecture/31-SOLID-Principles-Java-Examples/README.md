# SOLID Principles Java Examples

## Overview
This topic covers the SOLID principles of object-oriented design. These principles help create maintainable, flexible, and scalable software designs.

## Learning Objectives
- Understand each SOLID principle
- Learn to identify violations of SOLID principles
- Master applying SOLID principles in Java
- Understand the benefits of SOLID design
- Learn refactoring techniques

## Topics Covered
1. **S - Single Responsibility Principle**: One class, one reason to change
2. **O - Open/Closed Principle**: Open for extension, closed for modification
3. **L - Liskov Substitution Principle**: Subtypes must be substitutable
4. **I - Interface Segregation Principle**: Many specific interfaces
5. **D - Dependency Inversion Principle**: Depend on abstractions

## Code Examples

### Single Responsibility
```java
// Bad: Class does too much
class User {
    void save() { }
    void sendEmail() { }
    void generateReport() { }
}

// Good: Separate responsibilities
class User { void save() { } }
class EmailService { void sendEmail() { } }
class ReportGenerator { void generateReport() { } }
```

### Open/Closed Principle
```java
interface Shape {
    double area();
}

class Circle implements Shape { }
class Rectangle implements Shape { }
// Can add new shapes without modifying existing code
```

## How to Run

### Using Maven
```bash
cd 31-SOLID-Principles-Java-Examples
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.solid.SolidDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `SolidDemo.java`
3. Run the main method

## Key Concepts

### Single Responsibility Principle (SRP)
- **One Reason to Change**: Each class should have one responsibility
- **Benefits**: Easier to understand, test, and maintain
- **Example**: Separate data access from business logic

### Open/Closed Principle (OCP)
- **Open for Extension**: Add new functionality
- **Closed for Modification**: Don't change existing code
- **Benefits**: Reduces risk, maintains stability
- **Example**: Use interfaces and polymorphism

### Liskov Substitution Principle (LSP)
- **Substitutability**: Subtypes must work anywhere base type works
- **Benefits**: Reliable inheritance hierarchies
- **Example**: Square should work wherever Rectangle works

### Interface Segregation Principle (ISP)
- **Specific Interfaces**: Many small interfaces
- **Benefits**: Clients don't depend on unused methods
- **Example**: Separate read/write interfaces

### Dependency Inversion Principle (DIP)
- **Abstractions**: Depend on interfaces, not concrete classes
- **Benefits**: Flexible, testable, maintainable
- **Example**: Inject dependencies through interfaces

## Exercises
1. Refactor a class violating SRP
2. Apply OCP to add new features
3. Fix LSP violations in inheritance hierarchy
4. Split large interface following ISP
5. Apply DIP to a service class

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

