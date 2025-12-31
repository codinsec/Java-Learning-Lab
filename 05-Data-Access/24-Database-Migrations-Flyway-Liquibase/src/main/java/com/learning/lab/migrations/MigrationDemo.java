package com.learning.lab.migrations;

import org.flywaydb.core.Flyway;

/**
 * Demonstrates database migrations with Flyway
 */
public class MigrationDemo {
    public static void main(String[] args) {
        System.out.println("=== Database Migrations Demo ===\n");
        
        // Flyway configuration
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "";
        
        // Create Flyway instance
        Flyway flyway = Flyway.configure()
            .dataSource(url, user, password)
            .locations("classpath:db/migration")
            .load();
        
        // Run migrations
        System.out.println("--- Running Migrations ---");
        flyway.migrate();
        System.out.println("Migrations completed successfully");
        
        // Get migration info
        System.out.println("\n--- Migration Info ---");
        var info = flyway.info();
        System.out.println("Current version: " + info.current());
        System.out.println("Pending migrations: " + info.pending().length);
        System.out.println("Applied migrations: " + info.applied().length);
        
        System.out.println("\nMigration files should be in:");
        System.out.println("  src/main/resources/db/migration/");
        System.out.println("  Format: V{version}__{description}.sql");
        System.out.println("  Example: V1__Create_users_table.sql");
    }
}

