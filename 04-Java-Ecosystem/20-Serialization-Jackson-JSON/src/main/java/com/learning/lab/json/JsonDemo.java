package com.learning.lab.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

/**
 * Demonstrates JSON serialization and deserialization with Jackson
 */
public class JsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("=== Jackson JSON Serialization Demo ===\n");
        
        ObjectMapper mapper = new ObjectMapper();
        
        // Basic Serialization
        demonstrateSerialization(mapper);
        
        // Basic Deserialization
        demonstrateDeserialization(mapper);
        
        // Annotations
        demonstrateAnnotations(mapper);
        
        // Complex Objects
        demonstrateComplexObjects(mapper);
    }
    
    private static void demonstrateSerialization(ObjectMapper mapper) 
            throws JsonProcessingException {
        System.out.println("--- Serialization (Object to JSON) ---");
        
        User user = new User("Alice", 25, "alice@example.com");
        String json = mapper.writeValueAsString(user);
        System.out.println("User object as JSON:");
        System.out.println(json);
        
        // Pretty print
        String prettyJson = mapper.writerWithDefaultPrettyPrinter()
                                  .writeValueAsString(user);
        System.out.println("\nPretty printed JSON:");
        System.out.println(prettyJson);
        
        System.out.println();
    }
    
    private static void demonstrateDeserialization(ObjectMapper mapper) 
            throws JsonProcessingException {
        System.out.println("--- Deserialization (JSON to Object) ---");
        
        String json = "{\"name\":\"Bob\",\"age\":30,\"email\":\"bob@example.com\"}";
        User user = mapper.readValue(json, User.class);
        System.out.println("Deserialized user:");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        
        System.out.println();
    }
    
    private static void demonstrateAnnotations(ObjectMapper mapper) 
            throws JsonProcessingException {
        System.out.println("--- Jackson Annotations ---");
        
        Product product = new Product("Laptop", 999.99, LocalDate.of(2024, 1, 15));
        String json = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(product);
        System.out.println("Product with annotations:");
        System.out.println(json);
        
        System.out.println();
    }
    
    private static void demonstrateComplexObjects(ObjectMapper mapper) 
            throws JsonProcessingException {
        System.out.println("--- Complex Objects ---");
        
        Order order = new Order("ORD-001", 
            List.of(new OrderItem("Item1", 2, 10.0),
                    new OrderItem("Item2", 1, 20.0)));
        
        String json = mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(order);
        System.out.println("Order with items:");
        System.out.println(json);
        
        System.out.println();
    }
}

// ========== Example Classes ==========

class User {
    private String name;
    private int age;
    private String email;
    
    public User() {
        // Default constructor for Jackson
    }
    
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}

class Product {
    @JsonProperty("product_name")
    private String name;
    
    @JsonProperty("price")
    private double price;
    
    @JsonIgnore
    private String internalId = "INT-123";
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    
    public Product() {
    }
    
    public Product(String name, double price, LocalDate manufactureDate) {
        this.name = name;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getInternalId() {
        return internalId;
    }
    
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
    
    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}

class Order {
    private String orderId;
    private List<OrderItem> items;
    
    public Order() {
    }
    
    public Order(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}

class OrderItem {
    private String name;
    private int quantity;
    private double price;
    
    public OrderItem() {
    }
    
    public OrderItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

