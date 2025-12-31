# Spring Data JPA Repositories

## Overview
This topic covers Spring Data JPA, which simplifies data access by providing repository abstractions. You'll learn how to create repositories with minimal code and use query methods.

## Learning Objectives
- Understand repository pattern and Spring Data JPA
- Learn to create repositories extending JpaRepository
- Master query methods (findBy, countBy, etc.)
- Understand @Query annotation for custom queries
- Learn about pagination and sorting

## Topics Covered
1. **Repository Interfaces**: JpaRepository, CrudRepository
2. **Query Methods**: Method name-based queries
3. **@Query Annotation**: Custom JPQL and native queries
4. **Pagination**: Pageable, Page, Slice
5. **Specifications**: Dynamic queries with Specifications API

## Code Examples

### Repository Interface
```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByAgeGreaterThan(int age);
}
```

### Custom Query
```java
@Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
List<User> findByEmailDomain(@Param("domain") String domain);
```

### Pagination
```java
Page<User> users = userRepository.findAll(PageRequest.of(0, 10));
```

## How to Run

### Using Maven
```bash
cd 23-Spring-Data-JPA-Repositories
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.springdata.SpringDataDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `SpringDataDemo.java`
3. Run the main method

## Key Concepts

### Repository Pattern
- **Abstraction**: Hides data access implementation
- **Spring Data**: Provides implementation automatically
- **Benefits**: Less boilerplate, consistent API

### Query Methods
- **Naming Convention**: findBy + field name
- **Keywords**: And, Or, Between, Like, In, etc.
- **Return Types**: Entity, List, Optional, Page

### Spring Data Features
- **Automatic Implementation**: No need to write implementation
- **Query Derivation**: From method names
- **Pagination Support**: Built-in pagination
- **Auditing**: @CreatedDate, @LastModifiedDate

### Repository Types
- **CrudRepository**: Basic CRUD operations
- **PagingAndSortingRepository**: Adds pagination
- **JpaRepository**: JPA-specific features

## Exercises
1. Create repositories with various query methods
2. Implement pagination for large datasets
3. Use @Query for complex queries
4. Implement custom repository methods

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

