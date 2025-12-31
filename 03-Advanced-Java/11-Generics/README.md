# Generics

## Overview
This topic covers Java generics, which provide type safety and eliminate the need for casting. You'll learn how to create generic classes, methods, and interfaces.

## Learning Objectives
- Understand the need for generics and type safety
- Learn how to create generic classes and methods
- Master wildcards (?, ? extends, ? super)
- Understand bounded type parameters
- Learn about type erasure

## Topics Covered
1. **Generic Classes**: Type parameters, generic types
2. **Generic Methods**: Type inference, method-level generics
3. **Wildcards**: Unbounded, upper-bounded, lower-bounded
4. **Bounded Type Parameters**: `extends`, `super` keywords
5. **Type Erasure**: How generics work at runtime

## Code Examples

### Generic Class
```java
class Box<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}
```

### Generic Method
```java
public static <T> T getFirst(List<T> list) {
    return list.get(0);
}
```

### Wildcards
```java
void processList(List<? extends Number> numbers) {
    // Can read, but cannot write
}
```

## How to Run

### Using Maven
```bash
cd 11-Generics
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.generics.GenericsDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `GenericsDemo.java`
3. Run the main method

## Key Concepts

### Why Generics?
- **Type Safety**: Compile-time type checking
- **No Casting**: Eliminates need for explicit casts
- **Code Reuse**: Write once, use with different types

### Generic Syntax
- `<T>`: Type parameter
- `Box<String>`: Parameterized type
- `?`: Wildcard (unknown type)

### Wildcards
- `?`: Unbounded wildcard
- `? extends T`: Upper-bounded (read-only)
- `? super T`: Lower-bounded (write-only)

### Type Erasure
- Generics exist only at compile time
- At runtime, type information is erased
- `List<String>` becomes `List` at runtime

## Exercises
1. Create a generic `Stack` class
2. Implement a generic `Pair` class
3. Build a generic `Repository<T>` interface
4. Use wildcards in method parameters

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

