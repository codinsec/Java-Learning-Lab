# Classes, Objects, and Constructors

## Overview
This topic covers the fundamental concepts of object-oriented programming in Java: classes, objects, and constructors. You'll learn how to define classes, create objects, and initialize them using constructors.

## Learning Objectives
- Understand the difference between classes and objects
- Learn how to define classes with fields and methods
- Master constructor types (default, parameterized, copy)
- Understand access modifiers (public, private, protected, package-private)
- Learn about static members and instance members

## Topics Covered
1. **Classes**: Blueprint for creating objects
2. **Objects**: Instances of classes
3. **Constructors**: Default, parameterized, constructor chaining
4. **Access Modifiers**: Controlling visibility
5. **Static vs Instance**: Class-level vs object-level members

## Code Examples

### Basic Class
```java
public class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println(name + " is " + age + " years old");
    }
}
```

### Object Creation
```java
Person person = new Person("John", 25);
person.display();
```

### Constructor Overloading
```java
public class Rectangle {
    private int width;
    private int height;
    
    public Rectangle() {
        this(1, 1);  // Constructor chaining
    }
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

## How to Run

### Using Maven
```bash
cd 06-Classes-Objects-Constructors
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.classes.ClassesDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ClassesDemo.java`
3. Run the main method

## Key Concepts

### Class vs Object
- **Class**: Template or blueprint (e.g., `Person`)
- **Object**: Instance of a class (e.g., `new Person("John", 25)`)

### Constructors
- **Default Constructor**: No parameters, provided by compiler if none defined
- **Parameterized Constructor**: Takes parameters to initialize fields
- **Constructor Chaining**: Calling one constructor from another using `this()`

### Access Modifiers
- **public**: Accessible from anywhere
- **private**: Only accessible within the same class
- **protected**: Accessible within package and subclasses
- **package-private** (default): Accessible within the same package

### Static vs Instance
- **Static**: Belongs to the class, shared by all instances
- **Instance**: Belongs to each object, unique per instance

## Exercises
1. Create a `BankAccount` class with balance, deposit, and withdraw methods
2. Implement a `Student` class with name, ID, and GPA
3. Create a `Car` class with multiple constructors (default, make/model, full specs)
4. Build a `Calculator` class with static methods for basic operations

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

