# Multithreading and Concurrency

## Overview
This topic covers Java multithreading and concurrency, including thread creation, synchronization, thread pools, CompletableFuture, and virtual threads (Java 21+).

## Learning Objectives
- Understand threads and the Thread class
- Learn about Runnable and Callable interfaces
- Master synchronization (synchronized, locks)
- Understand thread pools and ExecutorService
- Learn CompletableFuture for asynchronous programming
- Understand virtual threads (Java 21+)

## Topics Covered
1. **Thread Creation**: Extending Thread, implementing Runnable
2. **Synchronization**: synchronized keyword, locks, atomic classes
3. **Thread Pools**: ExecutorService, ThreadPoolExecutor
4. **CompletableFuture**: Asynchronous programming, chaining
5. **Virtual Threads**: Lightweight threads (Java 21+)

## Code Examples

### Thread Creation
```java
Thread thread = new Thread(() -> {
    System.out.println("Running in thread");
});
thread.start();
```

### Synchronization
```java
synchronized (this) {
    // Critical section
}
```

### CompletableFuture
```java
CompletableFuture<String> future = CompletableFuture
    .supplyAsync(() -> "Hello")
    .thenApply(s -> s + " World");
```

## How to Run

### Using Maven
```bash
cd 15-Multithreading-Concurrency
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.concurrency.ConcurrencyDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ConcurrencyDemo.java`
3. Run the main method

## Key Concepts

### Thread Creation
- **Extend Thread**: Override run() method
- **Implement Runnable**: More flexible, can extend other classes
- **Lambda**: Quick way to create threads

### Synchronization
- **synchronized**: Mutual exclusion
- **Locks**: More flexible than synchronized
- **Atomic Classes**: Thread-safe operations without locks

### Thread Pools
- **ExecutorService**: Manages thread lifecycle
- **FixedThreadPool**: Fixed number of threads
- **CachedThreadPool**: Dynamic thread creation

### CompletableFuture
- **Asynchronous**: Non-blocking operations
- **Chaining**: Chain multiple async operations
- **Composition**: Combine multiple futures

## Exercises
1. Create multiple threads and synchronize access to shared data
2. Use ExecutorService to process tasks in parallel
3. Implement async operations with CompletableFuture
4. Compare performance of traditional threads vs virtual threads

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

