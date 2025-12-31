package com.learning.lab.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Demonstrates Java lambda expressions and functional interfaces
 */
public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Lambda and Functional Interfaces Demo ===\n");
        
        // Basic Lambda Expressions
        demonstrateBasicLambdas();
        
        // Functional Interfaces
        demonstrateFunctionalInterfaces();
        
        // Built-in Functional Interfaces
        demonstrateBuiltInInterfaces();
        
        // Method References
        demonstrateMethodReferences();
        
        // Variable Capture
        demonstrateVariableCapture();
    }
    
    private static void demonstrateBasicLambdas() {
        System.out.println("--- Basic Lambda Expressions ---");
        
        // Lambda with no parameters
        Runnable runnable = () -> System.out.println("Hello from lambda!");
        runnable.run();
        
        // Lambda with one parameter
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        greeting.greet("Alice");
        
        // Lambda with multiple parameters
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        
        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
        
        // Lambda with block body
        Calculator complex = (a, b) -> {
            int result = a + b;
            return result * 2;
        };
        System.out.println("(5 + 3) * 2 = " + complex.calculate(5, 3));
        System.out.println();
    }
    
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("--- Custom Functional Interfaces ---");
        
        // Using custom functional interface
        Validator<String> emailValidator = email -> email.contains("@");
        Validator<Integer> positiveValidator = num -> num > 0;
        
        System.out.println("Is 'test@email.com' valid? " + emailValidator.validate("test@email.com"));
        System.out.println("Is -5 positive? " + positiveValidator.validate(-5));
        System.out.println("Is 10 positive? " + positiveValidator.validate(10));
        System.out.println();
    }
    
    private static void demonstrateBuiltInInterfaces() {
        System.out.println("--- Built-in Functional Interfaces ---");
        
        // Predicate<T> - returns boolean
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));
        
        // Function<T,R> - transforms input to output
        Function<String, Integer> length = String::length;
        System.out.println("Length of 'Hello': " + length.apply("Hello"));
        
        // Consumer<T> - consumes input, returns void
        Consumer<String> printer = System.out::println;
        printer.accept("This is consumed by Consumer");
        
        // Supplier<T> - supplies a value
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
        
        // BiFunction<T,U,R> - two inputs, one output
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
        
        // UnaryOperator<T> - Function<T,T>
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));
        
        System.out.println();
    }
    
    private static void demonstrateMethodReferences() {
        System.out.println("--- Method References ---");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Static method reference
        names.forEach(System.out::println);
        
        // Instance method reference
        String prefix = "Name: ";
        names.forEach(prefix::concat);  // Not very useful, but demonstrates concept
        
        // Constructor reference
        Supplier<List<String>> listSupplier = java.util.ArrayList::new;
        List<String> newList = listSupplier.get();
        newList.add("New item");
        System.out.println("New list: " + newList);
        
        // Method reference with Function
        Function<String, Integer> length = String::length;
        names.stream()
             .map(length)
             .forEach(len -> System.out.println("Length: " + len));
        
        System.out.println();
    }
    
    private static void demonstrateVariableCapture() {
        System.out.println("--- Variable Capture in Lambdas ---");
        
        // Effectively final variable
        final int multiplier = 10;
        Function<Integer, Integer> multiply = x -> x * multiplier;
        System.out.println("5 * " + multiplier + " = " + multiply.apply(5));
        
        // Effectively final (not explicitly final)
        int base = 5;
        Function<Integer, Integer> addBase = x -> x + base;
        System.out.println("10 + " + base + " = " + addBase.apply(10));
        
        // Cannot modify captured variable
        // base = 10;  // Error: would break effectively final
        
        System.out.println();
    }
}

// ========== Custom Functional Interfaces ==========

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface Greeting {
    void greet(String name);
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T item);
}

