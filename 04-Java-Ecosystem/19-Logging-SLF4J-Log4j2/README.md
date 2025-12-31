# Logging with SLF4J and Log4j2

## Overview
This topic covers logging in Java using SLF4J (Simple Logging Facade for Java) as the API and Log4j2 as the implementation. You'll learn best practices for application logging.

## Learning Objectives
- Understand logging levels and when to use them
- Learn SLF4J API and its benefits
- Master Log4j2 configuration
- Understand log appenders and layouts
- Learn about structured logging

## Topics Covered
1. **Logging Levels**: TRACE, DEBUG, INFO, WARN, ERROR
2. **SLF4J API**: Logger interface, parameterized logging
3. **Log4j2**: Configuration, appenders, layouts
4. **Log Configuration**: XML, JSON, properties files
5. **Best Practices**: What to log, performance considerations

## Code Examples

### Basic Logging
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);
    
    public void doSomething() {
        logger.info("Processing request");
        logger.error("Error occurred", exception);
    }
}
```

### Parameterized Logging
```java
logger.info("User {} logged in from {}", username, ipAddress);
logger.debug("Processing {} items", items.size());
```

### Log4j2 Configuration
```xml
<Configuration>
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

## How to Run

### Using Maven
```bash
cd 19-Logging-SLF4J-Log4j2
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.logging.LoggingDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `LoggingDemo.java`
3. Run the main method

## Key Concepts

### Logging Levels
- **TRACE**: Very detailed information
- **DEBUG**: Debugging information
- **INFO**: General informational messages
- **WARN**: Warning messages
- **ERROR**: Error messages

### SLF4J Benefits
- **Abstraction**: Switch implementations without code changes
- **Parameterized Logging**: Efficient string formatting
- **MDC**: Mapped Diagnostic Context for contextual logging

### Log4j2 Features
- **Performance**: Async logging, garbage-free
- **Appenders**: Console, File, RollingFile, etc.
- **Layouts**: Pattern, JSON, XML
- **Filters**: Filter log events

### Best Practices
- Use appropriate log levels
- Include context in log messages
- Use parameterized logging (not string concatenation)
- Don't log sensitive information
- Use structured logging for production

## Exercises
1. Configure different log levels for different packages
2. Set up file appender with rolling policy
3. Implement structured logging with JSON layout
4. Use MDC for request tracking

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

