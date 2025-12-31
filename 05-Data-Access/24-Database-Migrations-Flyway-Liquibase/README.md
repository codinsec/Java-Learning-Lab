# Database Migrations with Flyway and Liquibase

## Overview
This topic covers database migration tools: Flyway and Liquibase. These tools help manage database schema changes in a version-controlled, repeatable way.

## Learning Objectives
- Understand database migration concepts
- Learn Flyway for SQL-based migrations
- Master Liquibase for XML/YAML-based migrations
- Understand version control for database schemas
- Learn best practices for database migrations

## Topics Covered
1. **Database Migrations**: Why and when to use
2. **Flyway**: SQL-based migrations, versioning
3. **Liquibase**: XML/YAML migrations, change sets
4. **Migration Strategies**: Versioned, repeatable migrations
5. **Best Practices**: Naming conventions, rollback strategies

## Code Examples

### Flyway Migration File
```sql
-- V1__Create_users_table.sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);
```

### Liquibase Changeset
```xml
<changeSet id="1" author="developer">
    <createTable tableName="users">
        <column name="id" type="BIGINT" autoIncrement="true">
            <constraints primaryKey="true"/>
        </column>
        <column name="name" type="VARCHAR(100)">
            <constraints nullable="false"/>
        </column>
    </createTable>
</changeSet>
```

## How to Run

### Using Maven
```bash
cd 24-Database-Migrations-Flyway-Liquibase
mvn compile
mvn flyway:migrate
mvn exec:java -Dexec.mainClass="com.learning.lab.migrations.MigrationDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `MigrationDemo.java`
3. Run the main method

## Key Concepts

### Why Migrations?
- **Version Control**: Track database schema changes
- **Reproducibility**: Same schema across environments
- **Team Collaboration**: Share schema changes
- **Rollback**: Revert changes if needed

### Flyway
- **SQL-based**: Write SQL migration scripts
- **Versioning**: V{version}__{description}.sql
- **Simple**: Easy to understand and use
- **Java API**: Programmatic migration control

### Liquibase
- **Multi-format**: SQL, XML, YAML, JSON
- **Change Sets**: Atomic changes
- **Rollback**: Built-in rollback support
- **Flexible**: More features than Flyway

### Migration Naming
- **Flyway**: V1__Create_table.sql, V2__Add_column.sql
- **Liquibase**: Changeset IDs and author

### Best Practices
- One change per migration
- Never modify existing migrations
- Test migrations in development first
- Use descriptive names
- Keep migrations small and focused

## Exercises
1. Create Flyway migrations for a user management system
2. Implement Liquibase changesets for the same system
3. Add rollback scripts
4. Use programmatic migration control

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

