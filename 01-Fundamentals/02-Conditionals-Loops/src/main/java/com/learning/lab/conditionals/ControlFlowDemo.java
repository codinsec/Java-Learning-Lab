package com.learning.lab.conditionals;

/**
 * Demonstrates Java conditional statements and loops
 */
public class ControlFlowDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Conditionals and Loops Demo ===\n");
        
        // Conditional Statements
        demonstrateConditionals();
        
        // Switch Statements
        demonstrateSwitch();
        
        // For Loops
        demonstrateForLoops();
        
        // While Loops
        demonstrateWhileLoops();
        
        // Enhanced For Loop
        demonstrateEnhancedFor();
        
        // Break and Continue
        demonstrateBreakContinue();
    }
    
    private static void demonstrateConditionals() {
        System.out.println("--- Conditional Statements ---");
        
        int score = 85;
        
        // Simple if
        if (score >= 60) {
            System.out.println("Score " + score + ": Passed");
        }
        
        // if-else
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
        
        // Ternary operator
        String result = score >= 60 ? "Pass" : "Fail";
        System.out.println("Result: " + result);
        System.out.println();
    }
    
    private static void demonstrateSwitch() {
        System.out.println("--- Switch Statements ---");
        
        String day = "Monday";
        
        // Traditional switch
        System.out.print("Traditional switch: ");
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println(day + " is a weekday");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println(day + " is a weekend");
                break;
            default:
                System.out.println("Invalid day");
        }
        
        // Enhanced switch (Java 14+)
        System.out.print("Enhanced switch: ");
        String dayType = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Unknown";
        };
        System.out.println(day + " is a " + dayType);
        System.out.println();
    }
    
    private static void demonstrateForLoops() {
        System.out.println("--- For Loops ---");
        
        // Standard for loop
        System.out.print("Count 0 to 4: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For loop with multiple variables
        System.out.print("Multiple variables: ");
        for (int i = 0, j = 10; i < 5; i++, j--) {
            System.out.print("(" + i + "," + j + ") ");
        }
        System.out.println();
        
        // Nested for loops
        System.out.println("Multiplication table (2x2):");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.print(i + "x" + j + "=" + (i * j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static void demonstrateWhileLoops() {
        System.out.println("--- While Loops ---");
        
        // While loop
        System.out.print("Countdown (while): ");
        int count = 5;
        while (count > 0) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println();
        
        // Do-while loop (executes at least once)
        System.out.print("Do-while example: ");
        int num = 0;
        do {
            System.out.print(num + " ");
            num++;
        } while (num < 5);
        System.out.println();
        System.out.println();
    }
    
    private static void demonstrateEnhancedFor() {
        System.out.println("--- Enhanced For Loop (For-Each) ---");
        
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.print("Array elements: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.print("Fruits: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        System.out.println();
    }
    
    private static void demonstrateBreakContinue() {
        System.out.println("--- Break and Continue ---");
        
        // Break example
        System.out.print("Break at 5: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;  // Exit loop
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Continue example
        System.out.print("Skip even numbers: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // Skip to next iteration
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Labeled break
        System.out.println("Labeled break (nested loops):");
        outer: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    break outer;  // Break outer loop
                }
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.println();
    }
}

