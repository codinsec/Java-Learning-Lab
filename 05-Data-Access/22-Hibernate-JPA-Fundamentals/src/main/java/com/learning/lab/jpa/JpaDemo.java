package com.learning.lab.jpa;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates Hibernate and JPA fundamentals
 */
public class JpaDemo {
    private static EntityManagerFactory emf;
    
    public static void main(String[] args) {
        System.out.println("=== Hibernate and JPA Fundamentals Demo ===\n");
        
        // Create EntityManagerFactory
        emf = Persistence.createEntityManagerFactory("jpa-demo");
        
        try {
            // Basic CRUD operations
            demonstrateCrud();
            
            // Relationships
            demonstrateRelationships();
            
            // JPQL Queries
            demonstrateJpql();
            
        } finally {
            emf.close();
        }
    }
    
    private static void demonstrateCrud() {
        System.out.println("--- CRUD Operations ---");
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            
            // Create (Persist)
            User user = new User("Alice", "alice@example.com");
            em.persist(user);
            System.out.println("Created user: " + user.getName() + " (ID: " + user.getId() + ")");
            
            tx.commit();
            
            // Read (Find)
            User foundUser = em.find(User.class, user.getId());
            System.out.println("Found user: " + foundUser.getName());
            
            // Update (Merge)
            tx.begin();
            foundUser.setEmail("alice.new@example.com");
            em.merge(foundUser);
            tx.commit();
            System.out.println("Updated user email");
            
            // Delete (Remove)
            tx.begin();
            em.remove(foundUser);
            tx.commit();
            System.out.println("Deleted user");
            
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        System.out.println();
    }
    
    private static void demonstrateRelationships() {
        System.out.println("--- Entity Relationships ---");
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            
            // Create user with orders
            User user = new User("Bob", "bob@example.com");
            em.persist(user);
            
            Order order1 = new Order("ORD-001", user);
            Order order2 = new Order("ORD-002", user);
            
            em.persist(order1);
            em.persist(order2);
            
            tx.commit();
            
            // Query user with orders
            User foundUser = em.find(User.class, user.getId());
            System.out.println("User: " + foundUser.getName());
            System.out.println("Orders: " + foundUser.getOrders().size());
            
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        System.out.println();
    }
    
    private static void demonstrateJpql() {
        System.out.println("--- JPQL Queries ---");
        
        EntityManager em = emf.createEntityManager();
        
        try {
            // Create some users
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(new User("Charlie", "charlie@example.com"));
            em.persist(new User("David", "david@example.com"));
            tx.commit();
            
            // JPQL Query
            TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.email LIKE :domain", User.class);
            query.setParameter("domain", "%@example.com");
            
            List<User> users = query.getResultList();
            System.out.println("Users with @example.com domain: " + users.size());
            users.forEach(u -> System.out.println("  - " + u.getName()));
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        System.out.println();
    }
}

// ========== JPA Entities ==========

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
    
    public User() {
    }
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
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
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public Order() {
    }
    
    public Order(String orderNumber, User user) {
        this.orderNumber = orderNumber;
        this.user = user;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}

