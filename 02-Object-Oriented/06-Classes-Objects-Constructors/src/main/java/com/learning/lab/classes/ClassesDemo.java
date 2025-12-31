package com.learning.lab.classes;

/**
 * Demonstrates Java classes, objects, and constructors
 */
public class ClassesDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Classes, Objects, and Constructors Demo ===\n");
        
        // Basic Object Creation
        demonstrateBasicObjects();
        
        // Constructors
        demonstrateConstructors();
        
        // Static vs Instance
        demonstrateStaticVsInstance();
        
        // Access Modifiers
        demonstrateAccessModifiers();
    }
    
    private static void demonstrateBasicObjects() {
        System.out.println("--- Basic Objects ---");
        
        // Create objects using constructors
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);
        
        person1.display();
        person2.display();
        
        System.out.println("Total persons created: " + Person.getCount());
        System.out.println();
    }
    
    private static void demonstrateConstructors() {
        System.out.println("--- Constructors ---");
        
        // Default constructor
        Rectangle rect1 = new Rectangle();
        System.out.println("Default rectangle: " + rect1);
        
        // Parameterized constructor
        Rectangle rect2 = new Rectangle(5, 10);
        System.out.println("Parameterized rectangle: " + rect2);
        
        // Constructor chaining
        Rectangle rect3 = new Rectangle(3);
        System.out.println("Square (chained): " + rect3);
        System.out.println();
    }
    
    private static void demonstrateStaticVsInstance() {
        System.out.println("--- Static vs Instance ---");
        
        // Static members belong to the class
        System.out.println("Math.PI (static): " + Math.PI);
        System.out.println("Counter.getCount() (static): " + Counter.getCount());
        
        // Instance members belong to objects
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        
        c1.increment();
        c2.increment();
        c2.increment();
        
        System.out.println("c1 value (instance): " + c1.getValue());
        System.out.println("c2 value (instance): " + c2.getValue());
        System.out.println("Total increments (static): " + Counter.getTotalIncrements());
        System.out.println();
    }
    
    private static void demonstrateAccessModifiers() {
        System.out.println("--- Access Modifiers ---");
        
        BankAccount account = new BankAccount("ACC001", 1000.0);
        
        // Public method - accessible
        account.displayBalance();
        
        // Public method - accessible
        account.deposit(500.0);
        account.displayBalance();
        
        // Private fields are accessed through public methods
        // account.balance = 10000;  // Error: balance is private
        System.out.println();
    }
}

// Example: Person Class
class Person {
    // Instance fields
    private String name;
    private int age;
    
    // Static field
    private static int count = 0;
    
    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;  // Increment static counter
    }
    
    // Instance methods
    public void display() {
        System.out.println(name + " is " + age + " years old");
    }
    
    // Static method
    public static int getCount() {
        return count;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

// Example: Rectangle Class with Multiple Constructors
class Rectangle {
    private int width;
    private int height;
    
    // Default constructor
    public Rectangle() {
        this(1, 1);  // Constructor chaining
    }
    
    // Parameterized constructor
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    // Constructor for square
    public Rectangle(int side) {
        this(side, side);  // Constructor chaining
    }
    
    public int getArea() {
        return width * height;
    }
    
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + ", area=" + getArea() + "]";
    }
}

// Example: Static vs Instance
class Counter {
    private int value;  // Instance field
    private static int totalIncrements = 0;  // Static field
    
    public Counter() {
        this.value = 0;
    }
    
    // Instance method
    public void increment() {
        value++;
        totalIncrements++;  // Modify static field
    }
    
    // Instance method
    public int getValue() {
        return value;
    }
    
    // Static method
    public static int getTotalIncrements() {
        return totalIncrements;
    }
}

// Example: Access Modifiers
class BankAccount {
    private String accountNumber;  // Private field
    private double balance;        // Private field
    
    // Public constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Public method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    // Public method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
    
    // Public method
    public void displayBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
    
    // Public getter
    public double getBalance() {
        return balance;
    }
}

