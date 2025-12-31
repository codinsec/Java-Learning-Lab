package com.learning.lab.interfaces;

/**
 * Demonstrates Java interfaces and abstract classes
 */
public class InterfacesDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Interfaces and Abstract Classes Demo ===\n");
        
        // Interfaces
        demonstrateInterfaces();
        
        // Abstract Classes
        demonstrateAbstractClasses();
        
        // Default Methods
        demonstrateDefaultMethods();
        
        // Multiple Interfaces
        demonstrateMultipleInterfaces();
        
        // Interface vs Abstract Class
        demonstrateComparison();
    }
    
    private static void demonstrateInterfaces() {
        System.out.println("--- Interfaces ---");
        
        // Interface implementation
        Drawable circle = new Circle("Red", 5.0);
        circle.draw();
        
        Drawable rectangle = new Rectangle("Blue", 4.0, 6.0);
        rectangle.draw();
        
        System.out.println();
    }
    
    private static void demonstrateAbstractClasses() {
        System.out.println("--- Abstract Classes ---");
        
        // Cannot instantiate abstract class directly
        // Shape shape = new Shape("Green");  // Error!
        
        // But can use concrete subclasses
        Shape circle = new CircleShape("Red", 5.0);
        circle.displayColor();
        System.out.println("Area: " + circle.getArea());
        
        Shape rectangle = new RectangleShape("Blue", 4.0, 6.0);
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.getArea());
        System.out.println();
    }
    
    private static void demonstrateDefaultMethods() {
        System.out.println("--- Default Methods in Interfaces (Java 8+) ---");
        
        Logger fileLogger = new FileLogger();
        fileLogger.log("This is a file log message");
        fileLogger.logError("This is an error message");
        
        Logger consoleLogger = new ConsoleLogger();
        consoleLogger.log("This is a console log message");
        consoleLogger.logError("This is an error message");
        System.out.println();
    }
    
    private static void demonstrateMultipleInterfaces() {
        System.out.println("--- Multiple Interface Implementation ---");
        
        // Class implementing multiple interfaces
        SmartPhone phone = new SmartPhone("iPhone 15");
        phone.call("123-456-7890");
        phone.sendMessage("Hello!");
        phone.takePhoto();
        phone.browseInternet();
        System.out.println();
    }
    
    private static void demonstrateComparison() {
        System.out.println("--- Interface vs Abstract Class ---");
        System.out.println("Interface:");
        System.out.println("  - All methods abstract (before Java 8)");
        System.out.println("  - Can have default/static methods (Java 8+)");
        System.out.println("  - Multiple inheritance supported");
        System.out.println("  - No instance fields");
        System.out.println("  - Use for: Contracts, APIs");
        
        System.out.println("\nAbstract Class:");
        System.out.println("  - Can have abstract and concrete methods");
        System.out.println("  - Can have instance fields and constructors");
        System.out.println("  - Single inheritance only");
        System.out.println("  - Use for: Shared code, partial implementation");
        System.out.println();
    }
}

// ========== Interface Examples ==========

// Simple interface
interface Drawable {
    void draw();  // Abstract method (implicitly public)
}

// Interface with default method (Java 8+)
interface Logger {
    void log(String message);  // Abstract method
    
    // Default method with implementation
    default void logError(String message) {
        System.out.println("[ERROR] " + message);
    }
    
    // Static method (Java 8+)
    static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
}

// Interface implementation
class Circle implements Drawable {
    private String color;
    private double radius;
    
    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
}

class Rectangle implements Drawable {
    private String color;
    private double width;
    private double height;
    
    public Rectangle(String color, double width, double height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle " + width + "x" + height);
    }
}

// Logger implementations
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[FILE] " + message);
    }
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[CONSOLE] " + message);
    }
    
    // Override default method
    @Override
    public void logError(String message) {
        System.out.println("[CONSOLE ERROR] " + message.toUpperCase());
    }
}

// ========== Abstract Class Examples ==========

// Abstract class
abstract class Shape {
    protected String color;  // Instance field
    
    public Shape(String color) {  // Constructor
        this.color = color;
    }
    
    // Abstract method (must be implemented by subclasses)
    abstract double getArea();
    
    // Concrete method (has implementation)
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

// Concrete subclass
class CircleShape extends Shape {
    private double radius;
    
    public CircleShape(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

// Concrete subclass
class RectangleShape extends Shape {
    private double width;
    private double height;
    
    public RectangleShape(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    double getArea() {
        return width * height;
    }
}

// ========== Multiple Interfaces Example ==========

interface Phone {
    void call(String number);
    void sendMessage(String message);
}

interface Camera {
    void takePhoto();
}

interface Internet {
    void browseInternet();
}

// Class implementing multiple interfaces
class SmartPhone implements Phone, Camera, Internet {
    private String model;
    
    public SmartPhone(String model) {
        this.model = model;
    }
    
    @Override
    public void call(String number) {
        System.out.println(model + " calling " + number);
    }
    
    @Override
    public void sendMessage(String message) {
        System.out.println(model + " sending: " + message);
    }
    
    @Override
    public void takePhoto() {
        System.out.println(model + " taking a photo");
    }
    
    @Override
    public void browseInternet() {
        System.out.println(model + " browsing the internet");
    }
}

