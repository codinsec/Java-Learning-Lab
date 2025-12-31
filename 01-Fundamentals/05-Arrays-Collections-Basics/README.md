# Arrays and Collections Basics

## Overview
This topic covers Java arrays and basic collection classes: ArrayList and HashMap. These are fundamental data structures used extensively in Java programming.

## Learning Objectives
- Understand array declaration, initialization, and manipulation
- Learn ArrayList for dynamic arrays
- Master HashMap for key-value pairs
- Understand when to use arrays vs collections
- Learn common operations on these data structures

## Topics Covered
1. **Arrays**: Declaration, initialization, multi-dimensional arrays
2. **ArrayList**: Dynamic array implementation, common methods
3. **HashMap**: Key-value pairs, hashing, common operations
4. **Collection Operations**: Iteration, searching, filtering

## Code Examples

### Arrays
```java
int[] numbers = {1, 2, 3, 4, 5};
int[] arr = new int[10];
int[][] matrix = {{1, 2}, {3, 4}};
```

### ArrayList
```java
ArrayList<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");
list.get(0);  // "Java"
list.size();  // 2
```

### HashMap
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Java", 1);
map.put("Python", 2);
map.get("Java");  // 1
```

## How to Run

### Using Maven
```bash
cd 05-Arrays-Collections-Basics
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.collections.CollectionsDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `CollectionsDemo.java`
3. Run the main method

## Key Concepts

### Arrays
- Fixed size once created
- Can store primitives or objects
- Indexed from 0
- Multi-dimensional arrays supported

### ArrayList
- Dynamic size (grows automatically)
- Can only store objects (uses wrapper classes for primitives)
- Implements List interface
- Better for frequent additions/removals

### HashMap
- Key-value pairs
- Keys must be unique
- Fast lookup (O(1) average)
- Not ordered (use LinkedHashMap for insertion order)

### When to Use
- **Arrays**: Fixed size, primitives, performance-critical code
- **ArrayList**: Dynamic size, frequent additions/removals
- **HashMap**: Key-value lookups, fast retrieval

## Exercises
1. Create and manipulate a 2D array (matrix)
2. Implement a shopping cart using ArrayList
3. Build a student grade book using HashMap
4. Compare performance of array vs ArrayList
5. Implement common algorithms (search, sort) on arrays

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

