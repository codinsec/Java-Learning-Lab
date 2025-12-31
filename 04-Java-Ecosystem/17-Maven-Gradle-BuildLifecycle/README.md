# Maven and Gradle Build Lifecycle

## Overview
This topic covers Java build tools: Maven and Gradle. You'll learn about build lifecycles, dependency management, and project structure.

## Learning Objectives
- Understand Maven project structure and POM
- Learn Maven build lifecycle phases
- Understand Gradle build system
- Master dependency management
- Learn about build profiles and plugins

## Topics Covered
1. **Maven**: Project Object Model (POM), lifecycle phases
2. **Gradle**: Build scripts, tasks, dependencies
3. **Dependency Management**: Central repositories, versioning
4. **Build Lifecycle**: Clean, compile, test, package, install, deploy
5. **Plugins**: Compiler, testing, packaging plugins

## Code Examples

### Maven POM Structure
```xml
<project>
    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0.0</version>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
        </dependency>
    </dependencies>
</project>
```

### Maven Lifecycle
```bash
mvn clean          # Clean previous builds
mvn compile        # Compile source code
mvn test           # Run tests
mvn package        # Create JAR/WAR
mvn install        # Install to local repository
```

### Gradle Build Script
```gradle
plugins {
    id 'java'
}

dependencies {
    testImplementation 'junit:junit:4.13.2'
}
```

## How to Run

### Using Maven
```bash
cd 17-Maven-Gradle-BuildLifecycle
mvn clean compile
mvn test
mvn package
```

### Using IDE
1. Open the project in your IDE
2. Right-click on `pom.xml` → Run Maven goals
3. Or use IDE's built-in Maven support

## Key Concepts

### Maven Lifecycle Phases
1. **validate**: Validate project
2. **compile**: Compile source code
3. **test**: Run unit tests
4. **package**: Package compiled code
5. **verify**: Run integration tests
6. **install**: Install to local repository
7. **deploy**: Deploy to remote repository

### Maven Coordinates
- **groupId**: Organization/company (e.g., `com.learning.lab`)
- **artifactId**: Project name (e.g., `my-app`)
- **version**: Version number (e.g., `1.0.0`)

### Dependency Scope
- **compile**: Default scope, available in all classpaths
- **test**: Only for test compilation and execution
- **provided**: Provided by JDK or container
- **runtime**: Not needed for compilation, needed at runtime

### Gradle vs Maven
- **Maven**: XML-based, convention over configuration
- **Gradle**: Groovy/Kotlin DSL, more flexible, faster builds

## Exercises
1. Create a multi-module Maven project
2. Add dependencies with different scopes
3. Configure Maven plugins for specific tasks
4. Convert a Maven project to Gradle

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

