package com.learning.lab.exceptions;

import java.io.FileReader;
import java.io.IOException;

/**
 * Demonstrates Java exception handling and custom exceptions
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Exception Handling Demo ===\n");
        
        // Basic Exception Handling
        demonstrateBasicHandling();
        
        // Multiple Catch Blocks
        demonstrateMultipleCatch();
        
        // Finally Block
        demonstrateFinally();
        
        // Try-With-Resources
        demonstrateTryWithResources();
        
        // Custom Exceptions
        demonstrateCustomExceptions();
        
        // Exception Propagation
        demonstrateExceptionPropagation();
    }
    
    private static void demonstrateBasicHandling() {
        System.out.println("--- Basic Exception Handling ---");
        
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        try {
            int result = divide(10, 2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateMultipleCatch() {
        System.out.println("--- Multiple Catch Blocks ---");
        
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Number at index 5: " + numbers[5]);
            int result = 10 / 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateFinally() {
        System.out.println("--- Finally Block ---");
        
        try {
            System.out.println("Inside try block");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        
        System.out.println();
    }
    
    private static void demonstrateTryWithResources() {
        System.out.println("--- Try-With-Resources ---");
        
        // Try-with-resources automatically closes resources
        try (FileReader reader = new FileReader("nonexistent.txt")) {
            // This will throw FileNotFoundException
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        // FileReader is automatically closed here
        
        // Custom resource
        try (CustomResource resource = new CustomResource()) {
            resource.use();
        } catch (Exception e) {
            System.out.println("Error using resource: " + e.getMessage());
        }
        // CustomResource is automatically closed
        
        System.out.println();
    }
    
    private static void demonstrateCustomExceptions() {
        System.out.println("--- Custom Exceptions ---");
        
        BankAccount account = new BankAccount(100.0);
        
        try {
            account.withdraw(50.0);
            System.out.println("Withdrawal successful. Balance: " + account.getBalance());
            
            account.withdraw(100.0);  // This will throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Current balance: " + e.getBalance());
            System.out.println("Requested amount: " + e.getRequestedAmount());
        }
        
        try {
            account.deposit(-10.0);  // This will throw exception
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    private static void demonstrateExceptionPropagation() {
        System.out.println("--- Exception Propagation ---");
        
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    // Helper methods
    private static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    
    private static void method1() throws Exception {
        System.out.println("In method1");
        method2();
    }
    
    private static void method2() throws Exception {
        System.out.println("In method2");
        method3();
    }
    
    private static void method3() throws Exception {
        System.out.println("In method3");
        throw new Exception("Exception from method3");
    }
}

// ========== Custom Exception Classes ==========

// Checked exception
class InsufficientFundsException extends Exception {
    private double balance;
    private double requestedAmount;
    
    public InsufficientFundsException(double balance, double requestedAmount) {
        super("Insufficient funds. Balance: " + balance + ", Requested: " + requestedAmount);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getRequestedAmount() {
        return requestedAmount;
    }
}

// Unchecked exception
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// ========== Example Classes ==========

class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
    }
    
    public double getBalance() {
        return balance;
    }
}

// Custom resource for try-with-resources
class CustomResource implements AutoCloseable {
    public void use() {
        System.out.println("Using custom resource");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Closing custom resource");
    }
}

