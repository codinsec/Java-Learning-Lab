# Polymorphism and Encapsulation

## Overview
This topic covers two fundamental OOP principles: polymorphism (one interface, multiple implementations) and encapsulation (data hiding and access control).

## Learning Objectives
- Understand runtime polymorphism (method overriding)
- Learn compile-time polymorphism (method overloading)
- Master encapsulation with access modifiers
- Understand getters and setters
- Learn about the `this` keyword

## Topics Covered
1. **Polymorphism**: Runtime (dynamic) and compile-time (static)
2. **Method Overriding**: Runtime polymorphism
3. **Method Overloading**: Compile-time polymorphism
4. **Encapsulation**: Data hiding, private fields, public methods
5. **Getters and Setters**: Controlled access to private fields

## Code Examples

### Runtime Polymorphism
```java
Animal animal = new Dog();  // Reference of parent, object of child
animal.makeSound();  // Calls Dog's makeSound() at runtime
```

### Encapsulation
```java
class BankAccount {
    private double balance;  // Private field
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
```

## How to Run

### Using Maven
```bash
cd 09-Polymorphism-Encapsulation
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.polymorphism.PolymorphismDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `PolymorphismDemo.java`
3. Run the main method

## Key Concepts

### Polymorphism Types
- **Runtime (Dynamic)**: Method overriding, determined at runtime
- **Compile-time (Static)**: Method overloading, determined at compile time

### Encapsulation Benefits
- **Data Protection**: Fields cannot be accessed directly
- **Controlled Access**: Through getters and setters
- **Validation**: Can add validation in setters
- **Flexibility**: Can change internal implementation without affecting users

### Access Modifiers
- **private**: Only within the same class
- **protected**: Within package and subclasses
- **public**: From anywhere
- **package-private**: Within the same package (default)

## Exercises
1. Create a `Shape` hierarchy demonstrating runtime polymorphism
2. Build a `Student` class with full encapsulation
3. Implement a `BankAccount` with validation in setters
4. Create a `Vehicle` system showing both types of polymorphism

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

