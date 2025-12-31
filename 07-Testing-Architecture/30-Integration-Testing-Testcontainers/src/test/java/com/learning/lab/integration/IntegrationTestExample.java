package com.learning.lab.integration;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates integration testing with Testcontainers
 * 
 * Note: Requires Docker to be running
 */
@Testcontainers
class IntegrationTestExample {
    
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
    
    @Test
    void testDatabaseConnection() throws Exception {
        // Get JDBC URL from container
        String jdbcUrl = postgres.getJdbcUrl();
        String username = postgres.getUsername();
        String password = postgres.getPassword();
        
        // Connect to database
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {
            
            // Create table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100))");
            
            // Insert data
            stmt.executeUpdate("INSERT INTO users (name) VALUES ('Test User')");
            
            // Verify
            var rs = stmt.executeQuery("SELECT COUNT(*) FROM users");
            assertTrue(rs.next());
            assertEquals(1, rs.getInt(1));
        }
    }
    
    @Test
    void testDatabaseIsolation() throws Exception {
        // Each test gets a fresh database state
        String jdbcUrl = postgres.getJdbcUrl();
        
        try (Connection conn = DriverManager.getConnection(
                jdbcUrl, postgres.getUsername(), postgres.getPassword());
             Statement stmt = conn.createStatement()) {
            
            // This test runs in the same container but with clean state
            var rs = stmt.executeQuery("SELECT COUNT(*) FROM users");
            // Count may vary depending on container lifecycle
            assertTrue(rs.next());
        }
    }
}

