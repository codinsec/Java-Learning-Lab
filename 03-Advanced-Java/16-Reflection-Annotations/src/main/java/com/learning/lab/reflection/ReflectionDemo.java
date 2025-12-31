package com.learning.lab.reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Demonstrates Java reflection and annotations
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Reflection and Annotations Demo ===\n");
        
        // Reflection Basics
        demonstrateReflection();
        
        // Method Invocation
        demonstrateMethodInvocation();
        
        // Field Access
        demonstrateFieldAccess();
        
        // Annotations
        demonstrateAnnotations();
        
        // Custom Annotations
        demonstrateCustomAnnotations();
    }
    
    private static void demonstrateReflection() {
        System.out.println("--- Reflection Basics ---");
        
        // Get Class object
        Class<?> clazz = Person.class;
        
        System.out.println("Class name: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Package: " + clazz.getPackage().getName());
        
        // Get methods
        System.out.println("\nMethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  - " + method.getName() + 
                             "(" + method.getParameterCount() + " parameters)");
        }
        
        // Get fields
        System.out.println("\nFields:");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("  - " + field.getName() + " : " + 
                             field.getType().getSimpleName());
        }
        
        // Get constructors
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println("  - " + constructor.getName() + 
                             "(" + constructor.getParameterCount() + " parameters)");
        }
        
        System.out.println();
    }
    
    private static void demonstrateMethodInvocation() throws Exception {
        System.out.println("--- Method Invocation ---");
        
        Person person = new Person("Alice", 25);
        
        // Get method
        Method getNameMethod = Person.class.getMethod("getName");
        Method setAgeMethod = Person.class.getMethod("setAge", int.class);
        
        // Invoke method
        String name = (String) getNameMethod.invoke(person);
        System.out.println("Name via reflection: " + name);
        
        // Invoke setter
        setAgeMethod.invoke(person, 30);
        System.out.println("Age after reflection set: " + person.getAge());
        
        // Invoke private method
        Method privateMethod = Person.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);  // Allow access to private method
        privateMethod.invoke(person);
        
        System.out.println();
    }
    
    private static void demonstrateFieldAccess() throws Exception {
        System.out.println("--- Field Access ---");
        
        Person person = new Person("Bob", 20);
        
        // Get field
        Field nameField = Person.class.getDeclaredField("name");
        Field ageField = Person.class.getDeclaredField("age");
        
        // Make private fields accessible
        nameField.setAccessible(true);
        ageField.setAccessible(true);
        
        // Read field value
        String name = (String) nameField.get(person);
        int age = ageField.getInt(person);
        System.out.println("Name: " + name + ", Age: " + age);
        
        // Modify field value
        nameField.set(person, "Charlie");
        ageField.setInt(person, 35);
        System.out.println("After modification - Name: " + person.getName() + 
                         ", Age: " + person.getAge());
        
        System.out.println();
    }
    
    private static void demonstrateAnnotations() {
        System.out.println("--- Built-in Annotations ---");
        
        Class<?> clazz = AnnotatedClass.class;
        
        // Check for annotations
        if (clazz.isAnnotationPresent(Deprecated.class)) {
            System.out.println("Class is deprecated");
        }
        
        // Get method annotations
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Override.class)) {
                System.out.println("Method " + method.getName() + " overrides parent");
            }
            if (method.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Method " + method.getName() + " is deprecated");
            }
        }
        
        System.out.println();
    }
    
    private static void demonstrateCustomAnnotations() throws Exception {
        System.out.println("--- Custom Annotations ---");
        
        Class<?> clazz = User.class;
        
        // Check for class-level annotation
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name() + 
                             " (Version: " + author.version() + ")");
        }
        
        // Process method annotations
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Validate.class)) {
                Validate validate = method.getAnnotation(Validate.class);
                System.out.println("Method " + method.getName() + 
                                 " requires validation: " + validate.required());
            }
        }
        
        // Process field annotations
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                System.out.println("Field " + field.getName() + " cannot be null");
            }
        }
        
        System.out.println();
    }
}

// ========== Example Classes ==========

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    private void privateMethod() {
        System.out.println("Private method called via reflection");
    }
}

@Deprecated
class AnnotatedClass {
    @Override
    public String toString() {
        return "AnnotatedClass";
    }
    
    @Deprecated
    public void oldMethod() {
        // Old implementation
    }
}

// ========== Custom Annotations ==========

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
    int version() default 1;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Validate {
    boolean required() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
}

@Author(name = "John Doe", version = 2)
class User {
    @NotNull
    private String username;
    
    private String email;
    
    @Validate(required = true)
    public void save() {
        System.out.println("Saving user");
    }
    
    @Validate(required = false)
    public void delete() {
        System.out.println("Deleting user");
    }
}

