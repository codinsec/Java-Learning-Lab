# Reflection and Annotations

## Overview
This topic covers Java reflection (runtime inspection of classes) and annotations (metadata for code). These features enable frameworks and libraries to work with your code dynamically.

## Learning Objectives
- Understand reflection API and its use cases
- Learn how to inspect classes, methods, and fields at runtime
- Master annotations and creating custom annotations
- Understand annotation processing
- Learn about retention policies and target types

## Topics Covered
1. **Reflection**: Class inspection, method invocation, field access
2. **Annotations**: Built-in and custom annotations
3. **Annotation Retention**: SOURCE, CLASS, RUNTIME
4. **Annotation Targets**: TYPE, METHOD, FIELD, PARAMETER, etc.
5. **Annotation Processing**: Reading annotations at runtime

## Code Examples

### Reflection
```java
Class<?> clazz = MyClass.class;
Method method = clazz.getMethod("methodName", String.class);
Object result = method.invoke(instance, "argument");
```

### Custom Annotation
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value() default "";
}
```

### Using Annotations
```java
@MyAnnotation("test")
public void myMethod() {
    // ...
}
```

## How to Run

### Using Maven
```bash
cd 16-Reflection-Annotations
mvn compile
mvn exec:java -Dexec.mainClass="com.learning.lab.reflection.ReflectionDemo"
```

### Using IDE
1. Open the project in your IDE
2. Navigate to `ReflectionDemo.java`
3. Run the main method

## Key Concepts

### Reflection
- **Purpose**: Inspect and manipulate classes at runtime
- **Use Cases**: Frameworks, serialization, dependency injection
- **Performance**: Slower than direct calls, use sparingly

### Annotations
- **Purpose**: Add metadata to code
- **Types**: Built-in (@Override, @Deprecated) and custom
- **Retention**: When annotation is available (SOURCE, CLASS, RUNTIME)

### Annotation Targets
- **@Target**: Where annotation can be applied
- **Types**: TYPE, METHOD, FIELD, PARAMETER, CONSTRUCTOR, etc.

### Common Use Cases
- **Frameworks**: Spring, Hibernate use annotations extensively
- **Validation**: JSR-303 validation annotations
- **Serialization**: Jackson, Gson use annotations

## Exercises
1. Create a custom annotation for validation
2. Use reflection to inspect a class structure
3. Build a simple dependency injection using reflection
4. Process annotations at runtime

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

