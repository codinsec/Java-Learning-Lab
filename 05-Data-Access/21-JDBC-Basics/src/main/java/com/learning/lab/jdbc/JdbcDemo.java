package com.learning.lab.jdbc;

import java.sql.*;

/**
 * Demonstrates JDBC basics
 */
public class JdbcDemo {
    public static void main(String[] args) {
        System.out.println("=== JDBC Basics Demo ===\n");
        
        // H2 in-memory database URL
        String url = "jdbc:h2:mem:testdb";
        
        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {
            // Create table
            createTable(conn);
            
            // Insert data
            insertData(conn);
            
            // Query data
            queryData(conn);
            
            // Update data
            updateData(conn);
            
            // Delete data
            deleteData(conn);
            
            // PreparedStatement example
            demonstratePreparedStatement(conn);
            
            // Transaction example
            demonstrateTransaction(conn);
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void createTable(Connection conn) throws SQLException {
        System.out.println("--- Creating Table ---");
        
        String sql = """
            CREATE TABLE users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                age INT
            )
            """;
        
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'users' created successfully");
        }
        System.out.println();
    }
    
    private static void insertData(Connection conn) throws SQLException {
        System.out.println("--- Inserting Data ---");
        
        String sql = "INSERT INTO users (name, email, age) VALUES " +
                     "('Alice', 'alice@example.com', 25), " +
                     "('Bob', 'bob@example.com', 30), " +
                     "('Charlie', 'charlie@example.com', 28)";
        
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Inserted " + rowsAffected + " rows");
        }
        System.out.println();
    }
    
    private static void queryData(Connection conn) throws SQLException {
        System.out.println("--- Querying Data ---");
        
        String sql = "SELECT id, name, email, age FROM users";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("Users:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                
                System.out.printf("  ID: %d, Name: %s, Email: %s, Age: %d%n",
                                id, name, email, age);
            }
        }
        System.out.println();
    }
    
    private static void updateData(Connection conn) throws SQLException {
        System.out.println("--- Updating Data ---");
        
        String sql = "UPDATE users SET age = 26 WHERE name = 'Alice'";
        
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Updated " + rowsAffected + " row(s)");
        }
        System.out.println();
    }
    
    private static void deleteData(Connection conn) throws SQLException {
        System.out.println("--- Deleting Data ---");
        
        String sql = "DELETE FROM users WHERE name = 'Charlie'";
        
        try (Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Deleted " + rowsAffected + " row(s)");
        }
        System.out.println();
    }
    
    private static void demonstratePreparedStatement(Connection conn) 
            throws SQLException {
        System.out.println("--- PreparedStatement (Recommended) ---");
        
        // Insert using PreparedStatement (prevents SQL injection)
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "David");
            pstmt.setString(2, "david@example.com");
            pstmt.setInt(3, 35);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row using PreparedStatement");
            
            // Query using PreparedStatement
            String querySql = "SELECT name, email FROM users WHERE age > ?";
            try (PreparedStatement queryPstmt = conn.prepareStatement(querySql)) {
                queryPstmt.setInt(1, 28);
                
                try (ResultSet rs = queryPstmt.executeQuery()) {
                    System.out.println("Users older than 28:");
                    while (rs.next()) {
                        System.out.println("  " + rs.getString("name") + 
                                         " - " + rs.getString("email"));
                    }
                }
            }
        }
        System.out.println();
    }
    
    private static void demonstrateTransaction(Connection conn) throws SQLException {
        System.out.println("--- Transaction Management ---");
        
        try {
            // Disable auto-commit
            conn.setAutoCommit(false);
            
            // Multiple operations
            try (PreparedStatement pstmt1 = conn.prepareStatement(
                    "UPDATE users SET age = age + 1 WHERE name = ?")) {
                pstmt1.setString(1, "Alice");
                pstmt1.executeUpdate();
            }
            
            try (PreparedStatement pstmt2 = conn.prepareStatement(
                    "UPDATE users SET age = age + 1 WHERE name = ?")) {
                pstmt2.setString(1, "Bob");
                pstmt2.executeUpdate();
            }
            
            // Commit transaction
            conn.commit();
            System.out.println("Transaction committed successfully");
            
        } catch (SQLException e) {
            // Rollback on error
            conn.rollback();
            System.out.println("Transaction rolled back due to error: " + e.getMessage());
            throw e;
        } finally {
            // Restore auto-commit
            conn.setAutoCommit(true);
        }
        System.out.println();
    }
}

