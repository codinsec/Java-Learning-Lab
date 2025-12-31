package com.learning.lab.springdata;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * Demonstrates Spring Data JPA repositories
 */
public class SpringDataDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Data JPA Repositories Demo ===\n");
        
        // Note: This is a simplified example
        // In real applications, Spring Boot auto-configures everything
        
        System.out.println("Spring Data JPA provides:");
        System.out.println("1. Repository interfaces with automatic implementation");
        System.out.println("2. Query methods derived from method names");
        System.out.println("3. Custom queries with @Query annotation");
        System.out.println("4. Pagination and sorting support");
        System.out.println("5. Specifications for dynamic queries");
        
        System.out.println("\nExample Repository Interface:");
        System.out.println("""
            public interface UserRepository extends JpaRepository<User, Long> {
                List<User> findByName(String name);
                Optional<User> findByEmail(String email);
                List<User> findByAgeGreaterThan(int age);
                @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
                List<User> findByEmailDomain(@Param("domain") String domain);
            }
            """);
    }
}

// ========== Example Repository Interface ==========

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    // Query methods derived from method names
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByAgeGreaterThan(int age);
    long countByName(String name);
    
    // Custom query
    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
    List<User> findByEmailDomain(@Param("domain") String domain);
}

// ========== Entity ==========

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private int age;
    
    public User() {
    }
    
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}

