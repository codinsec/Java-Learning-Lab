# Section 3: Advanced Java

## Overview
This section covers advanced Java features including generics, functional programming (lambda, streams), exception handling, concurrency, and reflection. These topics are essential for writing modern, efficient Java applications.

## Learning Path
This section consists of 6 topics that should be completed in order:

1. **[11-Generics](./11-Generics/)** - Type safety with generics
2. **[12-Lambda-FunctionalInterfaces](./12-Lambda-FunctionalInterfaces/)** - Functional programming in Java
3. **[13-Streams-API](./13-Streams-API/)** - Functional data processing
4. **[14-Exception-Handling-CustomExceptions](./14-Exception-Handling-CustomExceptions/)** - Error handling and custom exceptions
5. **[15-Multithreading-Concurrency](./15-Multithreading-Concurrency/)** - Concurrent programming
6. **[16-Reflection-Annotations](./16-Reflection-Annotations/)** - Runtime inspection and metadata

## Prerequisites
- Completion of Section 1: Fundamentals
- Completion of Section 2: Object-Oriented Programming
- Understanding of collections and interfaces

## Learning Objectives
By the end of this section, you will be able to:
- ✅ Use generics for type-safe code
- ✅ Write lambda expressions and use functional interfaces
- ✅ Process data with Streams API
- ✅ Handle exceptions properly and create custom exceptions
- ✅ Write concurrent programs with threads and CompletableFuture
- ✅ Use reflection and annotations for framework development

## Key Concepts

### Generics
- **Type Safety**: Compile-time type checking
- **Wildcards**: `?`, `? extends T`, `? super T`
- **Type Erasure**: Generics at compile time, erased at runtime

### Functional Programming
- **Lambda Expressions**: Concise function syntax
- **Functional Interfaces**: Single abstract method interfaces
- **Method References**: `ClassName::methodName`

### Streams API
- **Intermediate Operations**: filter, map, sorted (lazy)
- **Terminal Operations**: collect, forEach, reduce (eager)
- **Parallel Streams**: Concurrent data processing

### Exception Handling
- **Checked vs Unchecked**: Compile-time vs runtime exceptions
- **Try-With-Resources**: Automatic resource management
- **Custom Exceptions**: Application-specific error handling

### Concurrency
- **Threads**: Basic concurrency unit
- **Synchronization**: Mutual exclusion, locks
- **CompletableFuture**: Asynchronous programming
- **Thread Pools**: Efficient thread management

### Reflection & Annotations
- **Reflection**: Runtime class inspection
- **Annotations**: Metadata for code
- **Retention Policies**: SOURCE, CLASS, RUNTIME

## How to Use This Section

1. **Follow the sequence** - Complete topics in order (11 → 16)
2. **Read the README** - Each topic has detailed explanations
3. **Run the examples** - Execute code to see advanced features in action
4. **Practice** - Modify examples and try exercises
5. **Understand use cases** - Know when to use each feature

## Project Structure
Each topic contains:
- `pom.xml` - Maven project configuration
- `README.md` - Topic-specific documentation
- `src/main/java/` - Example code demonstrating advanced features
- `src/test/java/` - Test files (when applicable)

## Next Steps
After completing this section, proceed to:
- **Section 4: Java Ecosystem** - Maven, Gradle, Spring Context, Logging

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

