# Exception Handling and Custom Exceptions

## Overview
This topic covers Java exception handling, including checked and unchecked exceptions, try-catch-finally blocks, and creating custom exception classes.

## Learning Objectives
- Understand exception hierarchy (Throwable, Error, Exception)
- Learn about checked vs unchecked exceptions
- Master try-catch-finally and try-with-resources
- Create custom exception classes
- Understand exception propagation and best practices

## Topics Covered
1. **Exception Types**: Checked, unchecked, errors
2. **Exception Handling**: try-catch, finally, try-with-resources
3. **Exception Propagation**: throws, throw keywords
4. **Custom Exceptions**: Creating application-specific exceptions
5. **Best Practices**: When to catch, when to throw, exception chaining

## Code Examples

### Try-Catch
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Division by zero: " + e.getMessage());
}
```

### Try-With-Resources
```java
try (FileReader fr = new FileReader("file.txt")) {
    // Use resource
} catch (IOException e) {
    // Handle exception
}
```

### Custom Exception
```java
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

## How to Run

### Using Maven
```bash
cd 14-Exception-Handling-CustomExceptions
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.exceptions.ExceptionDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ExceptionDemo.java`
3. Run the main method

## Key Concepts

### Exception Hierarchy
- **Throwable**: Root class
- **Error**: System errors (not recoverable)
- **Exception**: Application exceptions
  - **RuntimeException**: Unchecked exceptions
  - **Other**: Checked exceptions

### Checked vs Unchecked
- **Checked**: Must be handled (compile-time check)
- **Unchecked**: RuntimeException and its subclasses

### Exception Handling
- **try-catch**: Handle exceptions
- **finally**: Always executes (cleanup)
- **try-with-resources**: Automatic resource management

### Best Practices
- Catch specific exceptions
- Don't catch and ignore
- Use try-with-resources for resources
- Create meaningful custom exceptions

## Exercises
1. Create a custom `ValidationException`
2. Implement a method with multiple exception types
3. Use try-with-resources for file operations
4. Build an exception hierarchy for a banking application

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

