# Integration Testing with Testcontainers

## Overview
This topic covers integration testing using Testcontainers, which allows you to run tests against real databases and services in Docker containers. This provides more realistic testing than mocks.

## Learning Objectives
- Understand integration testing vs unit testing
- Learn Testcontainers for Docker-based testing
- Master testing with real databases
- Understand test lifecycle management
- Learn best practices for integration tests

## Topics Covered
1. **Integration Testing**: Testing multiple components together
2. **Testcontainers**: Docker containers for testing
3. **Database Testing**: PostgreSQL, MySQL, MongoDB containers
4. **Service Testing**: Testing with external services
5. **Test Lifecycle**: Container startup, cleanup

## Code Examples

### Testcontainers Setup
```java
@Testcontainers
class IntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
}
```

### Database Integration Test
```java
@Test
void testDatabaseOperation() {
    String jdbcUrl = postgres.getJdbcUrl();
    // Use real database connection
}
```

## How to Run

### Prerequisites
- Docker must be installed and running

### Using Maven
```bash
cd 30-Integration-Testing-Testcontainers
mvn test
```

### Using IDE
1. Ensure Docker is running
2. Open the project in your IDE
3. Run integration tests

## Key Concepts

### Integration Testing
- **Purpose**: Test multiple components together
- **Scope**: Multiple classes, services, databases
- **Real Dependencies**: Use real databases/services
- **Slower**: Takes more time than unit tests

### Testcontainers Benefits
- **Real Environment**: Actual databases/services
- **Isolated**: Each test gets fresh container
- **Reproducible**: Same environment every time
- **No Manual Setup**: Automatic container management

### Test Lifecycle
- **@Testcontainers**: Enables Testcontainers
- **@Container**: Defines container
- **Startup**: Container starts before tests
- **Cleanup**: Container stops after tests

### Best Practices
- Use @Container static for shared containers
- Use @Container instance for per-test containers
- Clean up test data between tests
- Use appropriate container images

## Exercises
1. Create integration tests for a repository
2. Test database transactions
3. Test with multiple containers
4. Implement test data setup and cleanup

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

