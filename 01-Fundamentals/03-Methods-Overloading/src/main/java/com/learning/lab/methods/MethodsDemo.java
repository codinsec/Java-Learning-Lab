package com.learning.lab.methods;

/**
 * Demonstrates Java methods and method overloading
 */
public class MethodsDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Methods and Overloading Demo ===\n");
        
        // Basic Methods
        demonstrateBasicMethods();
        
        // Method Overloading
        demonstrateOverloading();
        
        // Varargs
        demonstrateVarargs();
        
        // Parameter Passing
        demonstrateParameterPassing();
    }
    
    private static void demonstrateBasicMethods() {
        System.out.println("--- Basic Methods ---");
        
        // Method with return value
        int sum = add(10, 20);
        System.out.println("add(10, 20) = " + sum);
        
        // Method without return value (void)
        greet("Java Learner");
        
        // Method with multiple parameters
        double average = calculateAverage(10, 20, 30);
        System.out.println("Average of 10, 20, 30 = " + average);
        System.out.println();
    }
    
    // Basic method with return type
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Void method (no return)
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    // Method with multiple parameters
    public static double calculateAverage(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }
    
    private static void demonstrateOverloading() {
        System.out.println("--- Method Overloading ---");
        
        // Overloaded methods with different parameter types
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("add(5.5, 3.2) = " + add(5.5, 3.2));
        
        // Overloaded methods with different number of parameters
        System.out.println("add(1, 2) = " + add(1, 2));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
        System.out.println("add(1, 2, 3, 4) = " + add(1, 2, 3, 4));
        
        // Overloaded methods with different parameter order
        printInfo("John", 25);
        printInfo(30, "Jane");
        System.out.println();
    }
    
    // Overloaded: int parameters
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Overloaded: double parameters
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Overloaded: three parameters
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Overloaded: four parameters
    public static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
    
    // Overloaded: different parameter order
    public static void printInfo(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public static void printInfo(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }
    
    private static void demonstrateVarargs() {
        System.out.println("--- Varargs (Variable Arguments) ---");
        
        // Varargs method can accept any number of arguments
        System.out.println("sum() = " + sum());
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(10, 20, 30, 40, 50) = " + sum(10, 20, 30, 40, 50));
        
        // Varargs with other parameters
        printNumbers("Numbers:", 1, 2, 3, 4, 5);
        System.out.println();
    }
    
    // Varargs method (must be last parameter)
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
    
    // Varargs with other parameters
    public static void printNumbers(String label, int... numbers) {
        System.out.print(label + " ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    private static void demonstrateParameterPassing() {
        System.out.println("--- Parameter Passing ---");
        
        // Primitive: passed by value (copy)
        int x = 10;
        System.out.println("Before: x = " + x);
        modifyPrimitive(x);
        System.out.println("After: x = " + x + " (unchanged - pass by value)");
        
        // Object: reference passed by value
        int[] arr = {1, 2, 3};
        System.out.println("\nBefore: arr[0] = " + arr[0]);
        modifyArray(arr);
        System.out.println("After: arr[0] = " + arr[0] + " (changed - reference passed)");
        System.out.println();
    }
    
    // Primitive parameter (copy)
    public static void modifyPrimitive(int value) {
        value = 100;  // Only modifies the copy
    }
    
    // Array parameter (reference)
    public static void modifyArray(int[] array) {
        if (array.length > 0) {
            array[0] = 999;  // Modifies the original array
        }
    }
}

