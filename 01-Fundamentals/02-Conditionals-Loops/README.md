# Conditionals and Loops

## Overview
This topic covers Java's control flow statements including conditionals (if/else, switch) and loops (for, while, do-while, enhanced for).

## Learning Objectives
- Master if/else and switch statements
- Understand different loop types and when to use them
- Learn about break and continue statements
- Practice nested control structures

## Topics Covered
1. **Conditional Statements**: `if`, `if-else`, `if-else-if`, `switch` (traditional and enhanced)
2. **Loops**: `for`, `while`, `do-while`, enhanced `for` (for-each)
3. **Control Flow**: `break`, `continue`, labeled statements
4. **Ternary Operator**: Conditional expressions

## Code Examples

### If-Else Example
```java
int score = 85;
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else {
    System.out.println("Grade: C");
}
```

### Switch Example (Java 14+)
```java
String day = "Monday";
switch (day) {
    case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> 
        System.out.println("Weekday");
    case "Saturday", "Sunday" -> 
        System.out.println("Weekend");
    default -> 
        System.out.println("Invalid day");
}
```

### For Loop Example
```java
for (int i = 0; i < 10; i++) {
    System.out.println("Count: " + i);
}
```

## How to Run

### Using Maven
```bash
cd 02-Conditionals-Loops
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.conditionals.ControlFlowDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ControlFlowDemo.java`
3. Run the main method

## Key Concepts

### Conditional Statements
- **if-else**: Basic branching logic
- **switch**: Multiple choice based on a single value
- **Ternary operator**: `condition ? valueIfTrue : valueIfFalse`

### Loop Types
- **for**: Known number of iterations
- **while**: Condition checked before iteration
- **do-while**: Condition checked after iteration (executes at least once)
- **Enhanced for**: Iterate over arrays/collections

### Control Flow
- **break**: Exit loop or switch
- **continue**: Skip to next iteration
- **Labels**: Control outer loops from inner loops

## Exercises
1. Create a number guessing game using loops and conditionals
2. Print multiplication tables using nested loops
3. Implement a menu system using switch statements
4. Use enhanced for loop to process array elements

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

