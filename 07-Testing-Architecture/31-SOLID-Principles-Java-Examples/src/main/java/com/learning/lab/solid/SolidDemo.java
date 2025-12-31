package com.learning.lab.solid;

import java.util.List;

/**
 * Demonstrates SOLID principles with Java examples
 */
public class SolidDemo {
    public static void main(String[] args) {
        System.out.println("=== SOLID Principles Demo ===\n");
        
        demonstrateSingleResponsibility();
        demonstrateOpenClosed();
        demonstrateLiskovSubstitution();
        demonstrateInterfaceSegregation();
        demonstrateDependencyInversion();
    }
    
    private static void demonstrateSingleResponsibility() {
        System.out.println("--- S: Single Responsibility Principle ---");
        System.out.println("Each class should have one reason to change");
        System.out.println("Example: Separate User entity from UserRepository");
        System.out.println();
    }
    
    private static void demonstrateOpenClosed() {
        System.out.println("--- O: Open/Closed Principle ---");
        System.out.println("Open for extension, closed for modification");
        
        // Can add new shapes without modifying existing code
        List<Shape> shapes = List.of(
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)  // New shape added
        );
        
        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.println("Total area: " + totalArea);
        System.out.println();
    }
    
    private static void demonstrateLiskovSubstitution() {
        System.out.println("--- L: Liskov Substitution Principle ---");
        System.out.println("Subtypes must be substitutable for base types");
        
        // Rectangle and Square can be used interchangeably where Shape is expected
        Shape rectangle = new Rectangle(4, 5);
        Shape square = new Square(4);
        
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Square area: " + square.area());
        System.out.println();
    }
    
    private static void demonstrateInterfaceSegregation() {
        System.out.println("--- I: Interface Segregation Principle ---");
        System.out.println("Clients should not depend on interfaces they don't use");
        
        // Printer only needs print, Scanner only needs scan
        Printer printer = new SimplePrinter();
        Scanner scanner = new SimpleScanner();
        
        printer.print("Document");
        scanner.scan("Document");
        System.out.println();
    }
    
    private static void demonstrateDependencyInversion() {
        System.out.println("--- D: Dependency Inversion Principle ---");
        System.out.println("Depend on abstractions, not concretions");
        
        // Service depends on MessageService interface, not concrete implementation
        MessageService emailService = new EmailService();
        NotificationService notificationService = new NotificationService(emailService);
        notificationService.sendNotification("Hello");
        
        // Can easily switch to SMS service
        MessageService smsService = new SmsService();
        NotificationService smsNotification = new NotificationService(smsService);
        smsNotification.sendNotification("Hello");
        System.out.println();
    }
}

// ========== Single Responsibility Principle ==========

class User {
    private String name;
    private String email;
    
    // User class only handles user data
    // Data access is in UserRepository (separate class)
}

// ========== Open/Closed Principle ==========

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double area() {
        return width * height;
    }
}

class Triangle implements Shape {
    private double a, b, c;
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double area() {
        // Heron's formula
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class AreaCalculator {
    // Open for extension (new shapes), closed for modification
    public double calculateTotalArea(List<Shape> shapes) {
        return shapes.stream()
                    .mapToDouble(Shape::area)
                    .sum();
    }
}

// ========== Liskov Substitution Principle ==========

class Square implements Shape {
    private double side;
    
    public Square(double side) {
        this.side = side;
    }
    
    @Override
    public double area() {
        return side * side;
    }
}

// ========== Interface Segregation Principle ==========

interface Printer {
    void print(String document);
}

interface Scanner {
    void scan(String document);
}

// Separate interfaces - clients only depend on what they need
class SimplePrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

class SimpleScanner implements Scanner {
    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }
}

// ========== Dependency Inversion Principle ==========

interface MessageService {
    void send(String message);
}

class EmailService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsService implements MessageService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// High-level module depends on abstraction (MessageService interface)
class NotificationService {
    private final MessageService messageService;  // Depend on interface
    
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public void sendNotification(String message) {
        messageService.send(message);
    }
}

