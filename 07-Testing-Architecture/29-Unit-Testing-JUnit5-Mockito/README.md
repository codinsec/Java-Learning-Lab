# Unit Testing with JUnit 5 and Mockito

## Overview
This topic covers unit testing in Java using JUnit 5 and Mockito. You'll learn how to write effective unit tests, mock dependencies, and follow testing best practices.

## Learning Objectives
- Understand unit testing principles and benefits
- Learn JUnit 5 annotations and assertions
- Master Mockito for mocking dependencies
- Understand test-driven development (TDD)
- Learn testing best practices

## Topics Covered
1. **JUnit 5**: @Test, @BeforeEach, @AfterEach, assertions
2. **Mockito**: @Mock, @InjectMocks, when().thenReturn()
3. **Test Structure**: Arrange-Act-Assert pattern
4. **Test Coverage**: What to test, edge cases
5. **Best Practices**: Test isolation, naming conventions

## Code Examples

### Basic JUnit Test
```java
@Test
void testAddition() {
    Calculator calc = new Calculator();
    int result = calc.add(2, 3);
    assertEquals(5, result);
}
```

### Mockito Mocking
```java
@Mock
private UserRepository userRepository;

@Test
void testFindUser() {
    when(userRepository.findById(1L)).thenReturn(new User("Alice"));
    User user = userService.findUser(1L);
    assertEquals("Alice", user.getName());
}
```

## How to Run

### Using Maven
```bash
cd 29-Unit-Testing-JUnit5-Mockito
mvn test
```

### Using IDE
1. Open the project in your IDE
2. Right-click on test class → Run Tests
3. Or use IDE's test runner

## Key Concepts

### Unit Testing
- **Purpose**: Test individual units in isolation
- **Scope**: Single class or method
- **Speed**: Fast execution
- **Isolation**: No external dependencies

### JUnit 5 Features
- **@Test**: Marks test method
- **@BeforeEach/@AfterEach**: Setup and teardown
- **Assertions**: assertEquals, assertTrue, assertNotNull
- **Parameterized Tests**: @ParameterizedTest

### Mockito Features
- **@Mock**: Create mock object
- **@InjectMocks**: Inject mocks into class
- **when().thenReturn()**: Define mock behavior
- **verify()**: Verify method calls

### Test Structure (AAA)
- **Arrange**: Set up test data
- **Act**: Execute code under test
- **Assert**: Verify results

## Exercises
1. Write unit tests for a Calculator class
2. Mock dependencies in a service layer test
3. Test exception scenarios
4. Write parameterized tests

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

