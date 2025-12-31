package com.learning.lab.strings;

import java.util.Arrays;

/**
 * Demonstrates Java String, StringBuilder, and Math classes
 */
public class StringDemo {
    public static void main(String[] args) {
        System.out.println("=== Java String, StringBuilder, and Math Demo ===\n");
        
        // String Basics
        demonstrateStringBasics();
        
        // String Methods
        demonstrateStringMethods();
        
        // String Comparison
        demonstrateStringComparison();
        
        // StringBuilder
        demonstrateStringBuilder();
        
        // Math Class
        demonstrateMath();
    }
    
    private static void demonstrateStringBasics() {
        System.out.println("--- String Basics ---");
        
        // String literals (stored in string pool)
        String str1 = "Hello";
        String str2 = "Hello";  // Reuses from string pool
        String str3 = new String("Hello");  // New object
        
        System.out.println("str1 = \"Hello\"");
        System.out.println("str2 = \"Hello\"");
        System.out.println("str3 = new String(\"Hello\")");
        System.out.println("str1 == str2: " + (str1 == str2));  // true (same reference)
        System.out.println("str1 == str3: " + (str1 == str3));  // false (different references)
        System.out.println("str1.equals(str3): " + str1.equals(str3));  // true (same content)
        
        // String immutability
        String original = "Java";
        String modified = original.concat(" Programming");
        System.out.println("\nOriginal: " + original);  // Still "Java"
        System.out.println("Modified: " + modified);    // New string "Java Programming"
        System.out.println();
    }
    
    private static void demonstrateStringMethods() {
        System.out.println("--- String Methods ---");
        
        String text = "  Hello World  ";
        
        System.out.println("Original: \"" + text + "\"");
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: \"" + text.trim() + "\"");
        System.out.println("Uppercase: \"" + text.toUpperCase() + "\"");
        System.out.println("Lowercase: \"" + text.toLowerCase() + "\"");
        System.out.println("Substring(2, 7): \"" + text.substring(2, 7) + "\"");
        System.out.println("Contains 'World': " + text.contains("World"));
        System.out.println("Starts with 'Hello': " + text.trim().startsWith("Hello"));
        System.out.println("Ends with 'World': " + text.trim().endsWith("World"));
        
        // Replace
        String replaced = text.replace("World", "Java");
        System.out.println("Replace 'World' with 'Java': \"" + replaced + "\"");
        
        // Split
        String sentence = "Java,Python,JavaScript";
        String[] languages = sentence.split(",");
        System.out.println("Split by ',': " + Arrays.toString(languages));
        
        // Join (Java 8+)
        String joined = String.join(" | ", languages);
        System.out.println("Join with ' | ': " + joined);
        System.out.println();
    }
    
    private static void demonstrateStringComparison() {
        System.out.println("--- String Comparison ---");
        
        String str1 = "Java";
        String str2 = "java";
        String str3 = "Java";
        
        System.out.println("str1 = \"" + str1 + "\"");
        System.out.println("str2 = \"" + str2 + "\"");
        System.out.println("str3 = \"" + str3 + "\"");
        
        System.out.println("str1 == str3: " + (str1 == str3));  // true (string pool)
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // false (case-sensitive)
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));  // true
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));  // Negative (J < j)
        System.out.println("str1.compareToIgnoreCase(str2): " + str1.compareToIgnoreCase(str2));  // 0
        System.out.println();
    }
    
    private static void demonstrateStringBuilder() {
        System.out.println("--- StringBuilder ---");
        
        // StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        
        System.out.println("StringBuilder content: " + sb.toString());
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
        
        // Insert
        sb.insert(5, " Beautiful");
        System.out.println("After insert: " + sb.toString());
        
        // Delete
        sb.delete(5, 15);
        System.out.println("After delete: " + sb.toString());
        
        // Reverse
        sb.reverse();
        System.out.println("Reversed: " + sb.toString());
        
        // Performance comparison
        System.out.println("\n--- Performance Comparison ---");
        long start = System.currentTimeMillis();
        String result1 = "";
        for (int i = 0; i < 10000; i++) {
            result1 += "a";  // Creates new String each time
        }
        long time1 = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb2.append("a");  // Modifies existing object
        }
        String result2 = sb2.toString();
        long time2 = System.currentTimeMillis() - start;
        
        System.out.println("String concatenation: " + time1 + " ms");
        System.out.println("StringBuilder: " + time2 + " ms");
        System.out.println("StringBuilder is " + (time1 / (double) time2) + "x faster");
        System.out.println();
    }
    
    private static void demonstrateMath() {
        System.out.println("--- Math Class ---");
        
        // Constants
        System.out.println("Math.PI: " + Math.PI);
        System.out.println("Math.E: " + Math.E);
        
        // Basic operations
        System.out.println("\nBasic Operations:");
        System.out.println("Math.max(10, 20): " + Math.max(10, 20));
        System.out.println("Math.min(10, 20): " + Math.min(10, 20));
        System.out.println("Math.abs(-15): " + Math.abs(-15));
        System.out.println("Math.sqrt(16): " + Math.sqrt(16));
        System.out.println("Math.pow(2, 3): " + Math.pow(2, 3));
        
        // Rounding
        System.out.println("\nRounding:");
        System.out.println("Math.round(3.7): " + Math.round(3.7));
        System.out.println("Math.ceil(3.2): " + Math.ceil(3.2));
        System.out.println("Math.floor(3.8): " + Math.floor(3.8));
        
        // Random
        System.out.println("\nRandom:");
        System.out.println("Math.random(): " + Math.random());
        System.out.println("Random int (0-99): " + (int)(Math.random() * 100));
        
        // Trigonometric
        System.out.println("\nTrigonometric:");
        System.out.println("Math.sin(Math.PI/2): " + Math.sin(Math.PI/2));
        System.out.println("Math.cos(0): " + Math.cos(0));
        System.out.println("Math.toDegrees(Math.PI): " + Math.toDegrees(Math.PI));
        System.out.println();
    }
}

