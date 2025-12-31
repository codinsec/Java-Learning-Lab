# Hibernate and JPA Fundamentals

## Overview
This topic covers Hibernate ORM (Object-Relational Mapping) and JPA (Java Persistence API). You'll learn how to map Java objects to database tables and perform database operations using object-oriented approach.

## Learning Objectives
- Understand ORM concepts and benefits
- Learn JPA annotations (@Entity, @Id, @Column, etc.)
- Master entity relationships (One-to-Many, Many-to-One, Many-to-Many)
- Understand EntityManager and persistence context
- Learn about Hibernate-specific features

## Topics Covered
1. **JPA Entities**: @Entity, @Table, @Id, @GeneratedValue
2. **Entity Relationships**: @OneToMany, @ManyToOne, @ManyToMany, @OneToOne
3. **EntityManager**: Persist, merge, remove, find
4. **JPQL**: Java Persistence Query Language
5. **Hibernate Features**: HQL, caching, lazy loading

## Code Examples

### Entity Definition
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_name")
    private String name;
    
    // Getters and setters
}
```

### EntityManager Usage
```java
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
em.persist(user);
em.getTransaction().commit();
```

### Relationships
```java
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Order> orders;
```

## How to Run

### Using Maven
```bash
cd 22-Hibernate-JPA-Fundamentals
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.jpa.JpaDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `JpaDemo.java`
3. Run the main method

## Key Concepts

### ORM Benefits
- **Object-Oriented**: Work with objects, not SQL
- **Productivity**: Less boilerplate code
- **Database Independence**: Switch databases easily
- **Type Safety**: Compile-time checking

### JPA Annotations
- **@Entity**: Marks class as JPA entity
- **@Table**: Specifies table name
- **@Id**: Primary key
- **@GeneratedValue**: Auto-generation strategy
- **@Column**: Column mapping
- **@OneToMany, @ManyToOne**: Relationship mapping

### EntityManager
- **Persistence Context**: Cache of managed entities
- **Lifecycle States**: New, Managed, Detached, Removed
- **Operations**: persist, merge, remove, find

### Relationships
- **One-to-Many**: One entity to many entities
- **Many-to-One**: Many entities to one entity
- **Many-to-Many**: Many entities to many entities
- **One-to-One**: One entity to one entity

## Exercises
1. Create entities with relationships
2. Implement CRUD operations using EntityManager
3. Write JPQL queries
4. Handle lazy loading and eager fetching

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

