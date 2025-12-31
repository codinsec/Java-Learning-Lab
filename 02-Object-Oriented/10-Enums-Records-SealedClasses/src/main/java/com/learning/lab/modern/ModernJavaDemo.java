package com.learning.lab.modern;

/**
 * Demonstrates modern Java features: Enums, Records, and Sealed Classes
 */
public class ModernJavaDemo {
    public static void main(String[] args) {
        System.out.println("=== Modern Java Features Demo ===\n");
        
        // Enums
        demonstrateEnums();
        
        // Records
        demonstrateRecords();
        
        // Sealed Classes (Java 17+)
        demonstrateSealedClasses();
        
        // Pattern Matching
        demonstratePatternMatching();
    }
    
    private static void demonstrateEnums() {
        System.out.println("--- Enums ---");
        
        // Basic enum usage
        Status status = Status.PENDING;
        System.out.println("Status: " + status);
        System.out.println("Is active: " + status.isActive());
        
        // Enum with methods
        Priority priority = Priority.HIGH;
        System.out.println("\nPriority: " + priority);
        System.out.println("Value: " + priority.getValue());
        System.out.println("Description: " + priority.getDescription());
        
        // Iterate over enum values
        System.out.println("\nAll priorities:");
        for (Priority p : Priority.values()) {
            System.out.println("  " + p + " - " + p.getDescription());
        }
        
        // Enum in switch
        System.out.println("\nSwitch with enum:");
        switch (status) {
            case PENDING -> System.out.println("Processing...");
            case APPROVED -> System.out.println("Success!");
            case REJECTED -> System.out.println("Failed!");
        }
        
        System.out.println();
    }
    
    private static void demonstrateRecords() {
        System.out.println("--- Records (Java 14+) ---");
        
        // Record - immutable data class
        Person person = new Person("Alice", 25);
        System.out.println("Person: " + person);
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        
        // Record with validation
        try {
            Person invalid = new Person("Bob", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
        
        // Record with custom method
        Point point1 = new Point(3, 4);
        Point point2 = new Point(0, 0);
        System.out.println("\nPoint 1: " + point1);
        System.out.println("Distance from origin: " + point1.distanceFromOrigin());
        System.out.println("Point 2: " + point2);
        System.out.println("Distance from origin: " + point2.distanceFromOrigin());
        
        // Records are immutable
        // point1.x = 10;  // Error: records are immutable
        
        System.out.println();
    }
    
    private static void demonstrateSealedClasses() {
        System.out.println("--- Sealed Classes (Java 17+) ---");
        
        // Sealed class hierarchy
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0, 4.0, 5.0);
        
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Triangle area: " + triangle.area());
        
        // All permitted classes
        System.out.println("\nAll shapes:");
        Shape[] shapes = {circle, rectangle, triangle};
        for (Shape shape : shapes) {
            System.out.println("  " + shape.getClass().getSimpleName() + 
                             " - Area: " + shape.area());
        }
        
        System.out.println();
    }
    
    private static void demonstratePatternMatching() {
        System.out.println("--- Pattern Matching (Java 17+) ---");
        
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        // Pattern matching with instanceof
        if (circle instanceof Circle c) {
            System.out.println("Circle radius: " + c.getRadius());
        }
        
        // Pattern matching in switch (Java 17+)
        System.out.println("\nPattern matching switch:");
        describeShape(circle);
        describeShape(rectangle);
        
        System.out.println();
    }
    
    private static void describeShape(Shape shape) {
        switch (shape) {
            case Circle c -> System.out.println("Circle with radius " + c.getRadius());
            case Rectangle r -> System.out.println("Rectangle " + r.getWidth() + "x" + r.getHeight());
            case Triangle t -> System.out.println("Triangle with sides " + 
                t.getA() + ", " + t.getB() + ", " + t.getC());
        }
    }
}

// ========== Enum Examples ==========

// Simple enum
enum Status {
    PENDING,
    APPROVED,
    REJECTED;
    
    public boolean isActive() {
        return this == APPROVED;
    }
}

// Enum with fields and methods
enum Priority {
    LOW(1, "Low priority - can be deferred"),
    MEDIUM(2, "Medium priority - normal processing"),
    HIGH(3, "High priority - urgent"),
    CRITICAL(4, "Critical - immediate attention required");
    
    private final int value;
    private final String description;
    
    Priority(int value, String description) {
        this.value = value;
        this.description = description;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
}

// ========== Record Examples ==========

// Simple record
record Person(String name, int age) {
    // Compact constructor with validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    
    // Custom method
    public boolean isAdult() {
        return age >= 18;
    }
}

// Record with custom methods
record Point(double x, double y) {
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    public double distanceTo(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// ========== Sealed Class Examples (Java 17+) ==========

// Sealed class - only permitted classes can extend
sealed class Shape permits Circle, Rectangle, Triangle {
    abstract double area();
}

// Final class - cannot be extended further
final class Circle extends Shape {
    private final double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
    
    public double getRadius() {
        return radius;
    }
}

// Final class
final class Rectangle extends Shape {
    private final double width;
    private final double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    double area() {
        return width * height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
}

// Final class
final class Triangle extends Shape {
    private final double a, b, c;
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    double area() {
        // Heron's formula
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public double getA() {
        return a;
    }
    
    public double getB() {
        return b;
    }
    
    public double getC() {
        return c;
    }
}

