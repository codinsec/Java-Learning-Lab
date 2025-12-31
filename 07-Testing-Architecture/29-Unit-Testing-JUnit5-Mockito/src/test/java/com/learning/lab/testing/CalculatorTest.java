package com.learning.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test examples
 */
@DisplayName("Calculator Tests")
class CalculatorTest {
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Should add two positive numbers")
    void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;
        
        // Act
        int result = calculator.add(a, b);
        
        // Assert
        assertEquals(8, result);
    }
    
    @Test
    @DisplayName("Should subtract two numbers")
    void testSubtract() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }
    
    @Test
    @DisplayName("Should multiply two numbers")
    void testMultiply() {
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }
    
    @Test
    @DisplayName("Should divide two numbers")
    void testDivide() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result);
    }
    
    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
    
    @Test
    @DisplayName("Should handle negative numbers")
    void testNegativeNumbers() {
        int result = calculator.add(-5, -3);
        assertEquals(-8, result);
    }
}

