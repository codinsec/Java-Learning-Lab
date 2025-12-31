# JDBC Basics

## Overview
This topic covers Java Database Connectivity (JDBC), the standard API for connecting to relational databases from Java. You'll learn how to connect to databases, execute SQL queries, and handle results.

## Learning Objectives
- Understand JDBC architecture and drivers
- Learn how to establish database connections
- Master executing SQL statements (SELECT, INSERT, UPDATE, DELETE)
- Understand PreparedStatement for parameterized queries
- Learn about connection pooling and best practices

## Topics Covered
1. **JDBC Architecture**: Drivers, Connection, Statement, ResultSet
2. **Database Connection**: DriverManager, Connection URL
3. **SQL Execution**: Statement, PreparedStatement, CallableStatement
4. **Result Processing**: ResultSet, metadata
5. **Transaction Management**: Commit, rollback, savepoints

## Code Examples

### Basic Connection
```java
String url = "jdbc:h2:mem:testdb";
Connection conn = DriverManager.getConnection(url, "sa", "");
```

### Execute Query
```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
while (rs.next()) {
    String name = rs.getString("name");
}
```

### PreparedStatement
```java
PreparedStatement pstmt = conn.prepareStatement(
    "INSERT INTO users (name, email) VALUES (?, ?)");
pstmt.setString(1, "Alice");
pstmt.setString(2, "alice@example.com");
pstmt.executeUpdate();
```

## How to Run

### Using Maven
```bash
cd 21-JDBC-Basics
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.jdbc.JdbcDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `JdbcDemo.java`
3. Run the main method

## Key Concepts

### JDBC Components
- **Driver**: Database-specific implementation
- **Connection**: Database session
- **Statement**: SQL execution
- **ResultSet**: Query results

### Statement Types
- **Statement**: Simple SQL (vulnerable to SQL injection)
- **PreparedStatement**: Parameterized SQL (recommended)
- **CallableStatement**: Stored procedures

### Connection Management
- **Always close**: Connections, statements, result sets
- **Try-with-resources**: Automatic resource management
- **Connection Pooling**: For production applications

### Best Practices
- Use PreparedStatement to prevent SQL injection
- Always close resources (try-with-resources)
- Use connection pooling in production
- Handle exceptions properly
- Use transactions for multiple operations

## Exercises
1. Create a UserDAO class with CRUD operations
2. Implement transaction management for multiple operations
3. Use PreparedStatement for all database operations
4. Build a simple connection pool

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

