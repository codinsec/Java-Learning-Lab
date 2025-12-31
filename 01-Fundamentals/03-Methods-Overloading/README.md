# Methods and Overloading

## Overview
This topic covers Java methods, including method declaration, parameters, return types, and method overloading (multiple methods with the same name but different signatures).

## Learning Objectives
- Understand method syntax and structure
- Learn about parameters and return types
- Master method overloading
- Understand pass-by-value vs pass-by-reference
- Learn about varargs (variable arguments)

## Topics Covered
1. **Method Declaration**: Access modifiers, return types, method names, parameters
2. **Method Overloading**: Same method name, different parameters
3. **Parameters**: Primitive vs object parameters, varargs
4. **Return Types**: void, primitives, objects
5. **Method Calls**: Static vs instance methods

## Code Examples

### Basic Method
```java
public static int add(int a, int b) {
    return a + b;
}
```

### Method Overloading
```java
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}

public static int add(int a, int b, int c) {
    return a + b + c;
}
```

### Varargs
```java
public static int sum(int... numbers) {
    int total = 0;
    for (int num : numbers) {
        total += num;
    }
    return total;
}
```

## How to Run

### Using Maven
```bash
cd 03-Methods-Overloading
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.methods.MethodsDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `MethodsDemo.java`
3. Run the main method

## Key Concepts

### Method Structure
```java
[access-modifier] [static] [return-type] methodName([parameters]) {
    // method body
    return value;  // if return type is not void
}
```

### Method Overloading Rules
- Methods must have the same name
- Must differ in: number of parameters, types of parameters, or order of parameters
- Cannot differ only by return type
- Cannot differ only by access modifier

### Parameter Passing
- **Primitives**: Passed by value (copy)
- **Objects**: Reference is passed by value (object itself can be modified)

### Varargs
- Variable number of arguments
- Must be the last parameter
- Treated as an array inside the method

## Exercises
1. Create overloaded methods for calculating area (circle, rectangle, triangle)
2. Implement a method that accepts varargs and finds the maximum value
3. Create methods that demonstrate pass-by-value vs pass-by-reference
4. Build a calculator class with overloaded operations

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

