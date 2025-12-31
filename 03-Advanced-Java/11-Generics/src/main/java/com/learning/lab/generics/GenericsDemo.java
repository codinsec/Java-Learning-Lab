package com.learning.lab.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Java generics
 */
public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Generics Demo ===\n");
        
        // Generic Classes
        demonstrateGenericClasses();
        
        // Generic Methods
        demonstrateGenericMethods();
        
        // Wildcards
        demonstrateWildcards();
        
        // Bounded Type Parameters
        demonstrateBoundedTypes();
    }
    
    private static void demonstrateGenericClasses() {
        System.out.println("--- Generic Classes ---");
        
        // Type-safe Box
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello Generics");
        System.out.println("String box: " + stringBox.getItem());
        
        Box<Integer> intBox = new Box<>();
        intBox.setItem(42);
        System.out.println("Integer box: " + intBox.getItem());
        
        // No casting needed!
        String value = stringBox.getItem();  // Type-safe
        Integer number = intBox.getItem();    // Type-safe
        
        // Generic Pair
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair.getFirst() + " = " + pair.getSecond());
        System.out.println();
    }
    
    private static void demonstrateGenericMethods() {
        System.out.println("--- Generic Methods ---");
        
        // Generic method with type inference
        String first = getFirst(List.of("A", "B", "C"));
        System.out.println("First string: " + first);
        
        Integer firstInt = getFirst(List.of(1, 2, 3));
        System.out.println("First integer: " + firstInt);
        
        // Explicit type parameter
        String result = GenericsDemo.<String>getFirst(List.of("X", "Y"));
        System.out.println("Explicit type: " + result);
        
        // Generic method with multiple type parameters
        Pair<String, Integer> pair = createPair("Count", 10);
        System.out.println("Created pair: " + pair);
        System.out.println();
    }
    
    private static void demonstrateWildcards() {
        System.out.println("--- Wildcards ---");
        
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.1, 2.2, 3.3);
        List<Number> numbers = new ArrayList<>();
        
        // Upper-bounded wildcard (read-only)
        System.out.println("Sum of integers: " + sumNumbers(integers));
        System.out.println("Sum of doubles: " + sumNumbers(doubles));
        
        // Lower-bounded wildcard (write-only)
        addNumbers(numbers, integers);
        System.out.println("Numbers list: " + numbers);
        
        // Unbounded wildcard
        printList(List.of("A", "B", "C"));
        printList(List.of(1, 2, 3));
        System.out.println();
    }
    
    private static void demonstrateBoundedTypes() {
        System.out.println("--- Bounded Type Parameters ---");
        
        // Bounded generic class
        NumberBox<Integer> intBox = new NumberBox<>(10);
        NumberBox<Double> doubleBox = new NumberBox<>(3.14);
        
        System.out.println("Integer box value: " + intBox.getValue());
        System.out.println("Double box value: " + doubleBox.getValue());
        System.out.println("Integer box squared: " + intBox.square());
        System.out.println("Double box squared: " + doubleBox.square());
        
        // NumberBox<String> stringBox = new NumberBox<>("test");  // Error!
        System.out.println();
    }
    
    // Generic method
    public static <T> T getFirst(List<T> list) {
        return list.get(0);
    }
    
    // Generic method with multiple type parameters
    public static <K, V> Pair<K, V> createPair(K key, V value) {
        return new Pair<>(key, value);
    }
    
    // Upper-bounded wildcard (read-only)
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    // Lower-bounded wildcard (write-only)
    public static void addNumbers(List<? super Integer> list, List<Integer> integers) {
        list.addAll(integers);
    }
    
    // Unbounded wildcard
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

// ========== Generic Class Examples ==========

// Simple generic class
class Box<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}

// Generic class with multiple type parameters
class Pair<K, V> {
    private K first;
    private V second;
    
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
    
    public K getFirst() {
        return first;
    }
    
    public V getSecond() {
        return second;
    }
    
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// Bounded type parameter
class NumberBox<T extends Number> {
    private T value;
    
    public NumberBox(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public double square() {
        return value.doubleValue() * value.doubleValue();
    }
}

