# Variables and Data Types

## Overview
This topic covers Java's primitive data types and their wrapper classes, understanding the differences between them, and when to use each.

## Learning Objectives
- Understand Java's 8 primitive data types
- Learn about wrapper classes and autoboxing/unboxing
- Understand the difference between stack and heap memory
- Know when to use primitives vs wrapper classes

## Topics Covered
1. **Primitive Types**: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`
2. **Wrapper Classes**: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`
3. **Autoboxing and Unboxing**: Automatic conversion between primitives and wrappers
4. **Memory Management**: Stack vs Heap allocation

## Code Examples

### Primitives Example
```java
int age = 25;
double price = 99.99;
boolean isActive = true;
char grade = 'A';
```

### Wrapper Classes Example
```java
Integer count = 100;
Double balance = 1500.50;
Boolean isValid = false;
```

### Autoboxing/Unboxing
```java
// Autoboxing: primitive to wrapper
Integer num = 42;  // int automatically boxed to Integer

// Unboxing: wrapper to primitive
int value = num;   // Integer automatically unboxed to int
```

## How to Run

### Using Maven
```bash
cd 01-Variables-DataTypes
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.variables.VariablesDemo"
```

### Using IDE
1. Open the project in your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Navigate to `VariablesDemo.java`
3. Run the main method

## Key Concepts

### Primitive Types
- Stored on the stack (for local variables)
- More memory efficient
- Cannot be `null`
- Default values: `0`, `0.0`, `false`, `'\u0000'`

### Wrapper Classes
- Stored on the heap
- Can be `null`
- Required for collections (e.g., `ArrayList<Integer>`)
- Provide utility methods (e.g., `Integer.parseInt()`)

### Memory Considerations
- **Stack**: Fast, limited size, stores primitive values and object references
- **Heap**: Larger, stores actual objects and arrays

## Exercises
1. Create variables for a student record (name, age, GPA, isEnrolled)
2. Compare performance of primitives vs wrappers in a loop
3. Demonstrate autoboxing/unboxing with method calls

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

