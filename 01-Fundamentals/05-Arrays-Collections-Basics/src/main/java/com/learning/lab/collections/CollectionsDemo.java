package com.learning.lab.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

/**
 * Demonstrates Java arrays, ArrayList, and HashMap
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Arrays and Collections Basics Demo ===\n");
        
        // Arrays
        demonstrateArrays();
        
        // Multi-dimensional Arrays
        demonstrateMultiDimensionalArrays();
        
        // ArrayList
        demonstrateArrayList();
        
        // HashMap
        demonstrateHashMap();
    }
    
    private static void demonstrateArrays() {
        System.out.println("--- Arrays ---");
        
        // Array declaration and initialization
        int[] numbers1 = {1, 2, 3, 4, 5};  // Initialized with values
        int[] numbers2 = new int[5];        // Initialized with default values (0)
        int[] numbers3 = new int[]{10, 20, 30};  // Explicit initialization
        
        System.out.println("numbers1: " + Arrays.toString(numbers1));
        System.out.println("numbers2: " + Arrays.toString(numbers2));
        System.out.println("numbers3: " + Arrays.toString(numbers3));
        
        // Array operations
        System.out.println("\nArray Operations:");
        System.out.println("Length: " + numbers1.length);
        System.out.println("First element: " + numbers1[0]);
        System.out.println("Last element: " + numbers1[numbers1.length - 1]);
        
        // Modify array
        numbers1[0] = 100;
        System.out.println("After modification: " + Arrays.toString(numbers1));
        
        // Iterate array
        System.out.print("Iteration: ");
        for (int num : numbers1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }
    
    private static void demonstrateMultiDimensionalArrays() {
        System.out.println("--- Multi-dimensional Arrays ---");
        
        // 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Enhanced for loop
        System.out.println("\nUsing enhanced for loop:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static void demonstrateArrayList() {
        System.out.println("--- ArrayList ---");
        
        // Create ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        
        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("Is empty: " + fruits.isEmpty());
        
        // Access elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));
        
        // Modify elements
        fruits.set(1, "Blueberry");
        System.out.println("After modification: " + fruits);
        
        // Remove elements
        fruits.remove("Cherry");
        System.out.println("After removing 'Cherry': " + fruits);
        
        // Check existence
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));
        System.out.println("Index of 'Date': " + fruits.indexOf("Date"));
        
        // Iterate
        System.out.print("Iteration: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        
        // Clear
        fruits.clear();
        System.out.println("After clear, size: " + fruits.size());
        System.out.println();
    }
    
    private static void demonstrateHashMap() {
        System.out.println("--- HashMap ---");
        
        // Create HashMap
        HashMap<String, Integer> studentScores = new HashMap<>();
        
        // Add key-value pairs
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 87);
        studentScores.put("Charlie", 92);
        studentScores.put("Diana", 88);
        
        System.out.println("Student Scores: " + studentScores);
        System.out.println("Size: " + studentScores.size());
        System.out.println("Is empty: " + studentScores.isEmpty());
        
        // Access values
        System.out.println("Alice's score: " + studentScores.get("Alice"));
        System.out.println("Bob's score: " + studentScores.get("Bob"));
        
        // Check existence
        System.out.println("Contains key 'Alice': " + studentScores.containsKey("Alice"));
        System.out.println("Contains value 95: " + studentScores.containsValue(95));
        
        // Update value
        studentScores.put("Bob", 90);  // Updates existing key
        System.out.println("After updating Bob's score: " + studentScores);
        
        // Remove
        studentScores.remove("Charlie");
        System.out.println("After removing Charlie: " + studentScores);
        
        // Iterate
        System.out.println("\nIteration:");
        for (String name : studentScores.keySet()) {
            System.out.println(name + ": " + studentScores.get(name));
        }
        
        // Iterate entries
        System.out.println("\nEntry iteration:");
        for (HashMap.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Get all values
        System.out.println("\nAll scores: " + studentScores.values());
        System.out.println();
    }
}

