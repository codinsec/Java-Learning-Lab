package com.learning.lab.build;

/**
 * Demonstrates Maven and Gradle build lifecycle concepts
 * 
 * This class serves as an example for understanding build tools.
 * Actual build configuration is in pom.xml (Maven) or build.gradle (Gradle).
 */
public class BuildDemo {
    public static void main(String[] args) {
        System.out.println("=== Maven and Gradle Build Lifecycle Demo ===\n");
        
        System.out.println("This project demonstrates:");
        System.out.println("1. Maven POM structure (see pom.xml)");
        System.out.println("2. Build lifecycle phases");
        System.out.println("3. Dependency management");
        System.out.println("4. Project structure");
        
        System.out.println("\nMaven Lifecycle Phases:");
        System.out.println("  - validate: Validate project");
        System.out.println("  - compile: Compile source code");
        System.out.println("  - test: Run unit tests");
        System.out.println("  - package: Package compiled code");
        System.out.println("  - verify: Run integration tests");
        System.out.println("  - install: Install to local repository");
        System.out.println("  - deploy: Deploy to remote repository");
        
        System.out.println("\nCommon Maven Commands:");
        System.out.println("  mvn clean          - Remove target directory");
        System.out.println("  mvn compile        - Compile source code");
        System.out.println("  mvn test           - Run tests");
        System.out.println("  mvn package         - Create JAR/WAR");
        System.out.println("  mvn install        - Install to local repo");
        System.out.println("  mvn clean install  - Clean and install");
        
        System.out.println("\nProject Structure:");
        System.out.println("  src/main/java     - Source code");
        System.out.println("  src/main/resources - Resources");
        System.out.println("  src/test/java     - Test code");
        System.out.println("  src/test/resources- Test resources");
        System.out.println("  target/           - Build output (Maven)");
        System.out.println("  build/             - Build output (Gradle)");
    }
}

