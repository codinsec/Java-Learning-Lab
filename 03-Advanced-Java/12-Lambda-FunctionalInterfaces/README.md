# Lambda and Functional Interfaces

## Overview
This topic covers Java lambda expressions (Java 8+) and functional interfaces, which enable functional programming in Java and make code more concise and readable.

## Learning Objectives
- Understand lambda expression syntax
- Learn about functional interfaces
- Master built-in functional interfaces (Predicate, Function, Consumer, Supplier)
- Understand method references
- Learn about variable capture in lambdas

## Topics Covered
1. **Lambda Expressions**: Syntax, parameters, body
2. **Functional Interfaces**: Single abstract method interfaces
3. **Built-in Functional Interfaces**: Predicate, Function, Consumer, Supplier, etc.
4. **Method References**: Static, instance, constructor references
5. **Variable Capture**: Effectively final variables

## Code Examples

### Lambda Expression
```java
// Before (anonymous class)
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};

// After (lambda)
Runnable r = () -> System.out.println("Hello");
```

### Functional Interface
```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

Calculator add = (a, b) -> a + b;
```

### Method Reference
```java
List<String> names = Arrays.asList("Alice", "Bob");
names.forEach(System.out::println);  // Method reference
```

## How to Run

### Using Maven
```bash
cd 12-Lambda-FunctionalInterfaces
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.lambda.LambdaDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `LambdaDemo.java`
3. Run the main method

## Key Concepts

### Lambda Syntax
- `(parameters) -> expression`
- `(parameters) -> { statements; }`
- `() -> expression` (no parameters)

### Functional Interfaces
- Interface with exactly one abstract method
- Can have default and static methods
- `@FunctionalInterface` annotation (optional but recommended)

### Built-in Functional Interfaces
- **Predicate<T>**: `boolean test(T t)`
- **Function<T,R>**: `R apply(T t)`
- **Consumer<T>**: `void accept(T t)`
- **Supplier<T>**: `T get()`
- **BiFunction<T,U,R>**: `R apply(T t, U u)`

### Method References
- **Static**: `ClassName::staticMethod`
- **Instance**: `instance::instanceMethod`
- **Constructor**: `ClassName::new`

## Exercises
1. Create custom functional interfaces
2. Use lambda expressions with collections
3. Implement a calculator using functional interfaces
4. Use method references to simplify code

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

