package com.learning.lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Demonstrates Spring Framework dependency injection
 */
public class SpringDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Dependency Injection Demo ===\n");
        
        // Create Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get beans from container
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);
        
        // Use services
        System.out.println("--- Using Services ---");
        userService.createUser("Alice");
        orderService.createOrder("Order-001");
        
        // Demonstrate dependency injection
        System.out.println("\n--- Dependency Injection ---");
        System.out.println("UserService has UserRepository: " + 
                         (userService.getRepository() != null));
        System.out.println("OrderService has OrderRepository: " + 
                         (orderService.getRepository() != null));
        
        // Show that same repository instance is shared
        UserRepository userRepo = context.getBean(UserRepository.class);
        System.out.println("Same repository instance: " + 
                         (userService.getRepository() == userRepo));
    }
}

// ========== Spring Configuration ==========

@Configuration
@ComponentScan("com.learning.lab.spring")
class AppConfig {
    // Configuration can include @Bean methods
    // Component scanning will find @Component, @Service, @Repository
}

// ========== Repository Layer ==========

interface UserRepository {
    void save(String user);
}

@Component
class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(String user) {
        System.out.println("Saving user: " + user);
    }
}

interface OrderRepository {
    void save(String order);
}

@Component
class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void save(String order) {
        System.out.println("Saving order: " + order);
    }
}

// ========== Service Layer ==========

@Service
class UserService {
    private final UserRepository repository;
    
    // Constructor injection (recommended)
    public UserService(UserRepository repository) {
        this.repository = repository;
        System.out.println("UserService created with repository");
    }
    
    public void createUser(String name) {
        repository.save(name);
    }
    
    public UserRepository getRepository() {
        return repository;
    }
}

@Service
class OrderService {
    private final OrderRepository repository;
    
    // Constructor injection
    public OrderService(OrderRepository repository) {
        this.repository = repository;
        System.out.println("OrderService created with repository");
    }
    
    public void createOrder(String orderId) {
        repository.save(orderId);
    }
    
    public OrderRepository getRepository() {
        return repository;
    }
}

