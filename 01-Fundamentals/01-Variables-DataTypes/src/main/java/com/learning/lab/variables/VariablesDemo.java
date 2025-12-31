package com.learning.lab.variables;

/**
 * Demonstrates Java primitive types and wrapper classes
 */
public class VariablesDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Variables and Data Types Demo ===\n");
        
        // Primitive Types
        demonstratePrimitives();
        
        // Wrapper Classes
        demonstrateWrappers();
        
        // Autoboxing and Unboxing
        demonstrateAutoboxing();
        
        // Memory and Default Values
        demonstrateDefaults();
    }
    
    private static void demonstratePrimitives() {
        System.out.println("--- Primitive Types ---");
        
        byte byteValue = 127;                    // 8-bit, -128 to 127
        short shortValue = 32767;                // 16-bit, -32,768 to 32,767
        int intValue = 2147483647;               // 32-bit, -2^31 to 2^31-1
        long longValue = 9223372036854775807L;  // 64-bit, suffix L required
        
        float floatValue = 3.14f;               // 32-bit, suffix f required
        double doubleValue = 3.14159265359;      // 64-bit, default for decimals
        
        char charValue = 'A';                   // 16-bit Unicode
        boolean boolValue = true;                // true or false
        
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: " + charValue);
        System.out.println("boolean: " + boolValue);
        System.out.println();
    }
    
    private static void demonstrateWrappers() {
        System.out.println("--- Wrapper Classes ---");
        
        Byte byteWrapper = Byte.valueOf((byte) 100);
        Short shortWrapper = Short.valueOf((short) 1000);
        Integer intWrapper = Integer.valueOf(100000);
        Long longWrapper = Long.valueOf(1000000L);
        
        Float floatWrapper = Float.valueOf(3.14f);
        Double doubleWrapper = Double.valueOf(3.14159);
        
        Character charWrapper = Character.valueOf('Z');
        Boolean boolWrapper = Boolean.valueOf(true);
        
        System.out.println("Byte: " + byteWrapper);
        System.out.println("Short: " + shortWrapper);
        System.out.println("Integer: " + intWrapper);
        System.out.println("Long: " + longWrapper);
        System.out.println("Float: " + floatWrapper);
        System.out.println("Double: " + doubleWrapper);
        System.out.println("Character: " + charWrapper);
        System.out.println("Boolean: " + boolWrapper);
        
        // Wrapper utility methods
        System.out.println("\nWrapper Utility Methods:");
        System.out.println("Integer.parseInt(\"123\"): " + Integer.parseInt("123"));
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("Character.isDigit('5'): " + Character.isDigit('5'));
        System.out.println();
    }
    
    private static void demonstrateAutoboxing() {
        System.out.println("--- Autoboxing and Unboxing ---");
        
        // Autoboxing: primitive to wrapper (automatic)
        Integer autoBoxed = 42;  // int automatically converted to Integer
        System.out.println("Autoboxing: int 42 -> Integer " + autoBoxed);
        
        // Unboxing: wrapper to primitive (automatic)
        int unboxed = autoBoxed;  // Integer automatically converted to int
        System.out.println("Unboxing: Integer " + autoBoxed + " -> int " + unboxed);
        
        // In method calls
        Integer result = add(10, 20);  // primitives boxed, result unboxed
        System.out.println("Method call with autoboxing: " + result);
        System.out.println();
    }
    
    private static Integer add(Integer a, Integer b) {
        return a + b;  // unboxing, addition, then autoboxing result
    }
    
    private static void demonstrateDefaults() {
        System.out.println("--- Default Values ---");
        System.out.println("Note: Default values only apply to instance variables");
        System.out.println("Local variables must be initialized before use");
        
        // Instance variables would have defaults:
        // byte, short, int, long: 0
        // float, double: 0.0
        // char: '\u0000'
        // boolean: false
        // Object references: null
        System.out.println();
    }
}

