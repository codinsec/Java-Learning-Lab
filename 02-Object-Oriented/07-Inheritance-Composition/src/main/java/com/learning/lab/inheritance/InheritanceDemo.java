package com.learning.lab.inheritance;

/**
 * Demonstrates Java inheritance and composition
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Inheritance and Composition Demo ===\n");
        
        // Inheritance
        demonstrateInheritance();
        
        // Method Overriding
        demonstrateMethodOverriding();
        
        // Composition
        demonstrateComposition();
        
        // Inheritance vs Composition
        demonstrateComparison();
    }
    
    private static void demonstrateInheritance() {
        System.out.println("--- Inheritance (IS-A Relationship) ---");
        
        // Parent class
        Animal animal = new Animal("Generic Animal");
        animal.makeSound();
        
        // Child classes inherit from Animal
        Dog dog = new Dog("Buddy");
        dog.makeSound();
        dog.fetch();  // Dog-specific method
        
        Cat cat = new Cat("Whiskers");
        cat.makeSound();
        cat.climb();  // Cat-specific method
        
        System.out.println();
    }
    
    private static void demonstrateMethodOverriding() {
        System.out.println("--- Method Overriding ---");
        
        Animal animal = new Animal("Animal");
        Dog dog = new Dog("Max");
        Cat cat = new Cat("Fluffy");
        
        // All can call makeSound, but each behaves differently
        animal.makeSound();
        dog.makeSound();
        cat.makeSound();
        
        // Using super keyword
        dog.displayInfo();
        System.out.println();
    }
    
    private static void demonstrateComposition() {
        System.out.println("--- Composition (HAS-A Relationship) ---");
        
        // Car HAS-A Engine
        Car car = new Car("Toyota", "Camry");
        car.start();
        car.drive();
        car.stop();
        
        // Computer HAS-A CPU, RAM, HardDrive
        Computer computer = new Computer("Intel i7", "16GB", "1TB SSD");
        computer.start();
        computer.displaySpecs();
        System.out.println();
    }
    
    private static void demonstrateComparison() {
        System.out.println("--- Inheritance vs Composition ---");
        
        System.out.println("Inheritance (IS-A):");
        System.out.println("  - Dog IS-A Animal");
        System.out.println("  - Use when: Clear hierarchical relationship");
        System.out.println("  - Benefits: Code reuse, polymorphism");
        
        System.out.println("\nComposition (HAS-A):");
        System.out.println("  - Car HAS-A Engine");
        System.out.println("  - Use when: Building complex objects");
        System.out.println("  - Benefits: Flexibility, loose coupling");
        System.out.println();
    }
}

// ========== Inheritance Examples ==========

// Parent class
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void displayInfo() {
        System.out.println("Animal: " + name);
    }
}

// Child class - Inheritance
class Dog extends Animal {
    public Dog(String name) {
        super(name);  // Call parent constructor
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    // Dog-specific method
    public void fetch() {
        System.out.println(name + " fetches the ball");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.println("Type: Dog");
    }
}

// Child class - Inheritance
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    // Cat-specific method
    public void climb() {
        System.out.println(name + " climbs the tree");
    }
}

// ========== Composition Examples ==========

// Engine class (used in composition)
class Engine {
    private String type;
    
    public Engine(String type) {
        this.type = type;
    }
    
    public void start() {
        System.out.println(type + " engine started");
    }
    
    public void stop() {
        System.out.println(type + " engine stopped");
    }
}

// Car class - Composition (HAS-A Engine)
class Car {
    private String make;
    private String model;
    private Engine engine;  // Composition: Car HAS-A Engine
    
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.engine = new Engine("V6");  // Create engine
    }
    
    public void start() {
        System.out.println(make + " " + model + " starting...");
        engine.start();
    }
    
    public void drive() {
        System.out.println(make + " " + model + " is driving");
    }
    
    public void stop() {
        System.out.println(make + " " + model + " stopping...");
        engine.stop();
    }
}

// CPU class (used in composition)
class CPU {
    private String model;
    
    public CPU(String model) {
        this.model = model;
    }
    
    public String getModel() {
        return model;
    }
}

// RAM class (used in composition)
class RAM {
    private String capacity;
    
    public RAM(String capacity) {
        this.capacity = capacity;
    }
    
    public String getCapacity() {
        return capacity;
    }
}

// HardDrive class (used in composition)
class HardDrive {
    private String capacity;
    
    public HardDrive(String capacity) {
        this.capacity = capacity;
    }
    
    public String getCapacity() {
        return capacity;
    }
}

// Computer class - Composition (HAS-A CPU, RAM, HardDrive)
class Computer {
    private CPU cpu;        // Composition
    private RAM ram;        // Composition
    private HardDrive hdd;  // Composition
    
    public Computer(String cpuModel, String ramCapacity, String hddCapacity) {
        this.cpu = new CPU(cpuModel);
        this.ram = new RAM(ramCapacity);
        this.hdd = new HardDrive(hddCapacity);
    }
    
    public void start() {
        System.out.println("Computer starting...");
        System.out.println("CPU: " + cpu.getModel() + " initialized");
    }
    
    public void displaySpecs() {
        System.out.println("Computer Specifications:");
        System.out.println("  CPU: " + cpu.getModel());
        System.out.println("  RAM: " + ram.getCapacity());
        System.out.println("  Storage: " + hdd.getCapacity());
    }
}

