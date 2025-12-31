package com.learning.lab.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates classic design patterns from Gang of Four
 */
public class PatternsDemo {
    public static void main(String[] args) {
        System.out.println("=== Design Patterns Demo ===\n");
        
        demonstrateSingleton();
        demonstrateFactory();
        demonstrateBuilder();
        demonstrateObserver();
        demonstrateStrategy();
    }
    
    private static void demonstrateSingleton() {
        System.out.println("--- Singleton Pattern ---");
        System.out.println("Ensures only one instance exists");
        
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        
        System.out.println("Same instance: " + (db1 == db2));
        System.out.println();
    }
    
    private static void demonstrateFactory() {
        System.out.println("--- Factory Pattern ---");
        System.out.println("Creates objects without specifying exact class");
        
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.createShape("circle");
        Shape rectangle = factory.createShape("rectangle");
        
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println();
    }
    
    private static void demonstrateBuilder() {
        System.out.println("--- Builder Pattern ---");
        System.out.println("Constructs complex objects step by step");
        
        User user = new User.Builder()
            .name("Alice")
            .email("alice@example.com")
            .age(25)
            .build();
        
        System.out.println("Built user: " + user.getName());
        System.out.println();
    }
    
    private static void demonstrateObserver() {
        System.out.println("--- Observer Pattern ---");
        System.out.println("One-to-many dependency between objects");
        
        NewsAgency agency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel("Channel 1");
        NewsChannel channel2 = new NewsChannel("Channel 2");
        
        agency.addObserver(channel1);
        agency.addObserver(channel2);
        
        agency.setNews("Breaking: Java 21 released!");
        System.out.println();
    }
    
    private static void demonstrateStrategy() {
        System.out.println("--- Strategy Pattern ---");
        System.out.println("Encapsulates algorithms and makes them interchangeable");
        
        Sorter sorter = new Sorter();
        
        sorter.setStrategy(new BubbleSort());
        int[] data1 = {5, 2, 8, 1, 9};
        sorter.sort(data1);
        System.out.print("Bubble sort: ");
        printArray(data1);
        
        sorter.setStrategy(new QuickSort());
        int[] data2 = {5, 2, 8, 1, 9};
        sorter.sort(data2);
        System.out.print("Quick sort: ");
        printArray(data2);
        System.out.println();
    }
    
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

// ========== Singleton Pattern ==========

class DatabaseConnection {
    private static DatabaseConnection instance;
    
    private DatabaseConnection() {
        System.out.println("Database connection created");
    }
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

// ========== Factory Pattern ==========

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius = 5.0;
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width = 4.0;
    private double height = 6.0;
    
    @Override
    public double area() {
        return width * height;
    }
}

class ShapeFactory {
    public Shape createShape(String type) {
        return switch (type.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> throw new IllegalArgumentException("Unknown shape type");
        };
    }
}

// ========== Builder Pattern ==========

class User {
    private String name;
    private String email;
    private int age;
    
    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
    }
    
    public static class Builder {
        private String name;
        private String email;
        private int age;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}

// ========== Observer Pattern ==========

interface Observer {
    void update(String news);
}

class NewsChannel implements Observer {
    private String name;
    
    public NewsChannel(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String news) {
        System.out.println(name + " received: " + news);
    }
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    private String news;
    
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
    
    private void notifyObservers() {
        observers.forEach(observer -> observer.update(news));
    }
}

// ========== Strategy Pattern ==========

interface SortStrategy {
    void sort(int[] array);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        // Simplified bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
}

class Sorter {
    private SortStrategy strategy;
    
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void sort(int[] array) {
        strategy.sort(array);
    }
}

