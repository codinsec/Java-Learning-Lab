# Streams API

## Overview
This topic covers the Java Streams API (Java 8+), which provides a functional approach to processing collections of data. Streams enable declarative, parallelizable data processing.

## Learning Objectives
- Understand the Stream API and its benefits
- Learn intermediate operations (filter, map, sorted, etc.)
- Master terminal operations (collect, forEach, reduce, etc.)
- Understand parallel streams
- Learn about collectors and grouping

## Topics Covered
1. **Stream Creation**: From collections, arrays, generators
2. **Intermediate Operations**: filter, map, flatMap, sorted, distinct, limit
3. **Terminal Operations**: collect, forEach, reduce, findFirst, anyMatch, allMatch
4. **Collectors**: toList, toSet, groupingBy, partitioningBy
5. **Parallel Streams**: Parallel processing, when to use

## Code Examples

### Basic Stream
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .filter(name -> name.startsWith("A"))
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

### Collectors
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> evens = numbers.stream()
                             .filter(n -> n % 2 == 0)
                             .collect(Collectors.toList());
```

### Grouping
```java
Map<String, List<Person>> byCity = people.stream()
                                         .collect(Collectors.groupingBy(Person::getCity));
```

## How to Run

### Using Maven
```bash
cd 13-Streams-API
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.streams.StreamsDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `StreamsDemo.java`
3. Run the main method

## Key Concepts

### Stream Characteristics
- **Non-mutating**: Operations don't modify source
- **Lazy**: Intermediate operations are lazy
- **Functional**: Declarative style
- **Potentially infinite**: Can work with infinite streams

### Operation Types
- **Intermediate**: Return Stream, lazy (filter, map, sorted)
- **Terminal**: Return result, eager (collect, forEach, reduce)

### Common Operations
- **filter**: Select elements matching predicate
- **map**: Transform elements
- **flatMap**: Flatten nested structures
- **sorted**: Sort elements
- **distinct**: Remove duplicates
- **collect**: Collect to collection

### Parallel Streams
- Use `parallelStream()` for parallel processing
- Best for large datasets and CPU-intensive operations
- Thread-safe operations required

## Exercises
1. Filter and transform a list of products
2. Group students by grade using Collectors
3. Calculate statistics (sum, average, max) using streams
4. Process large datasets with parallel streams

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

