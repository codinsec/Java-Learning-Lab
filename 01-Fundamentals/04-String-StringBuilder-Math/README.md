# String, StringBuilder, and Math

## Overview
This topic covers Java's String class, StringBuilder for efficient string manipulation, and the Math utility class for mathematical operations.

## Learning Objectives
- Understand String immutability and string pool
- Learn StringBuilder for efficient string concatenation
- Master common String methods
- Use Math class for mathematical operations
- Understand string comparison and equality

## Topics Covered
1. **String Class**: Immutability, string pool, common methods
2. **StringBuilder**: Mutable string builder for performance
3. **StringBuffer**: Thread-safe version of StringBuilder
4. **Math Class**: Mathematical operations and constants
5. **String Methods**: substring, replace, split, join, etc.

## Code Examples

### String Basics
```java
String str1 = "Hello";
String str2 = new String("Hello");
String str3 = str1 + " World";
```

### StringBuilder
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();
```

### Math Operations
```java
double max = Math.max(10, 20);
double sqrt = Math.sqrt(16);
int random = (int)(Math.random() * 100);
```

## How to Run

### Using Maven
```bash
cd 04-String-StringBuilder-Math
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.strings.StringDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `StringDemo.java`
3. Run the main method

## Key Concepts

### String Immutability
- Strings are immutable (cannot be changed)
- Operations create new String objects
- String pool: reuse of string literals

### StringBuilder vs String
- **String**: Immutable, thread-safe, slower for concatenation
- **StringBuilder**: Mutable, not thread-safe, faster for concatenation
- **StringBuffer**: Mutable, thread-safe, slower than StringBuilder

### String Comparison
- `==`: Compares references
- `equals()`: Compares content
- `equalsIgnoreCase()`: Case-insensitive comparison

### Math Class
- Static methods for mathematical operations
- Constants: `Math.PI`, `Math.E`
- Methods: `max()`, `min()`, `abs()`, `sqrt()`, `pow()`, `random()`, etc.

## Exercises
1. Reverse a string using StringBuilder
2. Count occurrences of a character in a string
3. Implement a simple calculator using Math class
4. Compare performance of String concatenation vs StringBuilder
5. Parse and format strings using various String methods

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

