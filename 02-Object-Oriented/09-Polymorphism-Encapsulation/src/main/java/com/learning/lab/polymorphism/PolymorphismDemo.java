package com.learning.lab.polymorphism;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Java polymorphism and encapsulation
 */
public class PolymorphismDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Polymorphism and Encapsulation Demo ===\n");
        
        // Runtime Polymorphism
        demonstrateRuntimePolymorphism();
        
        // Compile-time Polymorphism
        demonstrateCompileTimePolymorphism();
        
        // Encapsulation
        demonstrateEncapsulation();
        
        // Polymorphism with Collections
        demonstratePolymorphismWithCollections();
    }
    
    private static void demonstrateRuntimePolymorphism() {
        System.out.println("--- Runtime Polymorphism (Method Overriding) ---");
        
        // Parent reference, child objects
        Animal animal1 = new Dog("Buddy");
        Animal animal2 = new Cat("Whiskers");
        Animal animal3 = new Bird("Tweety");
        
        // Same method call, different behaviors (determined at runtime)
        animal1.makeSound();  // Calls Dog's makeSound()
        animal2.makeSound();  // Calls Cat's makeSound()
        animal3.makeSound();  // Calls Bird's makeSound()
        
        System.out.println();
    }
    
    private static void demonstrateCompileTimePolymorphism() {
        System.out.println("--- Compile-time Polymorphism (Method Overloading) ---");
        
        Calculator calc = new Calculator();
        
        // Same method name, different parameters (determined at compile time)
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("add(\"Hello\", \" World\") = " + calc.add("Hello", " World"));
        
        System.out.println();
    }
    
    private static void demonstrateEncapsulation() {
        System.out.println("--- Encapsulation ---");
        
        // Create encapsulated object
        Student student = new Student();
        
        // Cannot access private fields directly
        // student.name = "John";  // Error: name is private
        // System.out.println(student.gpa);  // Error: gpa is private
        
        // Must use public methods (getters/setters)
        student.setName("John Doe");
        student.setAge(20);
        student.setGpa(3.8);
        
        System.out.println("Student Info:");
        System.out.println("  Name: " + student.getName());
        System.out.println("  Age: " + student.getAge());
        System.out.println("  GPA: " + student.getGpa());
        
        // Validation in setter
        student.setGpa(5.0);  // Invalid GPA
        System.out.println("  GPA after invalid set: " + student.getGpa());  // Still 3.8
        
        System.out.println();
    }
    
    private static void demonstratePolymorphismWithCollections() {
        System.out.println("--- Polymorphism with Collections ---");
        
        // List of Animal references, but different objects
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Max"));
        animals.add(new Cat("Fluffy"));
        animals.add(new Bird("Polly"));
        
        // Polymorphic method calls
        System.out.println("All animals making sounds:");
        for (Animal animal : animals) {
            animal.makeSound();  // Runtime polymorphism
        }
        
        System.out.println();
    }
}

// ========== Runtime Polymorphism Example ==========

class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Method to be overridden
    public void makeSound() {
        System.out.println(name + " makes a generic sound");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
}

// ========== Compile-time Polymorphism Example ==========

class Calculator {
    // Method overloading - same name, different parameters
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
}

// ========== Encapsulation Example ==========

class Student {
    // Private fields - data hiding
    private String name;
    private int age;
    private double gpa;
    
    // Public getters and setters - controlled access
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0 && age <= 120) {
            this.age = age;
        }
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        // Validation in setter
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA: " + gpa + ". GPA must be between 0.0 and 4.0");
        }
    }
    
    // Additional encapsulated method
    public String getGrade() {
        if (gpa >= 3.5) {
            return "A";
        } else if (gpa >= 3.0) {
            return "B";
        } else if (gpa >= 2.0) {
            return "C";
        } else {
            return "F";
        }
    }
}

