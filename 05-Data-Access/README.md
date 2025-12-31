# Section 5: Data Access

## Overview
This section covers data access in Java applications, from low-level JDBC to high-level ORM frameworks. You'll learn how to interact with databases efficiently and manage schema changes.

## Learning Path
This section consists of 4 topics that should be completed in order:

1. **[21-JDBC-Basics](./21-JDBC-Basics/)** - Java Database Connectivity fundamentals
2. **[22-Hibernate-JPA-Fundamentals](./22-Hibernate-JPA-Fundamentals/)** - Object-Relational Mapping
3. **[23-Spring-Data-JPA-Repositories](./23-Spring-Data-JPA-Repositories/)** - Repository pattern with Spring
4. **[24-Database-Migrations-Flyway-Liquibase](./24-Database-Migrations-Flyway-Liquibase/)** - Database schema versioning

## Prerequisites
- Completion of Section 1: Fundamentals
- Completion of Section 2: Object-Oriented Programming
- Completion of Section 4: Java Ecosystem (Spring Context)
- Basic understanding of SQL and relational databases

## Learning Objectives
By the end of this section, you will be able to:
- ✅ Connect to databases using JDBC
- ✅ Use PreparedStatement for safe database operations
- ✅ Map Java objects to database tables with JPA
- ✅ Create and use Spring Data repositories
- ✅ Manage database schema changes with migration tools

## Key Concepts

### JDBC
- **Low-level API**: Direct database access
- **Connection Management**: DriverManager, connection pooling
- **SQL Execution**: Statement, PreparedStatement
- **Result Processing**: ResultSet, metadata

### JPA/Hibernate
- **ORM**: Object-Relational Mapping
- **Entities**: @Entity, @Table, @Id annotations
- **Relationships**: @OneToMany, @ManyToOne, etc.
- **EntityManager**: Persistence context management

### Spring Data JPA
- **Repository Pattern**: Abstraction over data access
- **Query Methods**: Derived from method names
- **Pagination**: Built-in pagination support
- **Custom Queries**: @Query annotation

### Database Migrations
- **Version Control**: Track schema changes
- **Flyway**: SQL-based migrations
- **Liquibase**: XML/YAML migrations
- **Best Practices**: Naming, rollback strategies

## How to Use This Section

1. **Follow the sequence** - Complete topics in order (21 → 24)
2. **Read the README** - Each topic has detailed explanations
3. **Run the examples** - Execute code to see data access in action
4. **Practice** - Modify examples and try exercises
5. **Understand trade-offs** - Know when to use JDBC vs JPA

## Project Structure
Each topic contains:
- `pom.xml` - Maven project with database dependencies
- `README.md` - Topic-specific documentation
- `src/main/java/` - Example code
- `src/main/resources/` - Configuration and migration files

## Database Setup
Examples use H2 in-memory database for simplicity. For production:
- Use PostgreSQL, MySQL, or other production databases
- Configure connection pooling
- Use proper transaction management

## Next Steps
After completing this section, proceed to:
- **Section 6: Web Development** - Spring Boot REST APIs, Security

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

