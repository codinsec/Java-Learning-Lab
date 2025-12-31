package com.learning.lab.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates Java Streams API
 */
public class StreamsDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Streams API Demo ===\n");
        
        // Stream Creation
        demonstrateStreamCreation();
        
        // Intermediate Operations
        demonstrateIntermediateOperations();
        
        // Terminal Operations
        demonstrateTerminalOperations();
        
        // Collectors
        demonstrateCollectors();
        
        // Parallel Streams
        demonstrateParallelStreams();
    }
    
    private static void demonstrateStreamCreation() {
        System.out.println("--- Stream Creation ---");
        
        // From collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Stream<String> stream1 = names.stream();
        System.out.println("Stream from list: " + stream1.count() + " elements");
        
        // From array
        String[] array = {"Apple", "Banana", "Cherry"};
        Stream<String> stream2 = Arrays.stream(array);
        System.out.println("Stream from array: " + stream2.count() + " elements");
        
        // Using Stream.of
        Stream<String> stream3 = Stream.of("One", "Two", "Three");
        System.out.println("Stream.of: " + stream3.count() + " elements");
        
        // Generate infinite stream
        Stream<Integer> infinite = Stream.iterate(0, n -> n + 2);
        System.out.println("First 5 even numbers: ");
        infinite.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
    }
    
    private static void demonstrateIntermediateOperations() {
        System.out.println("--- Intermediate Operations ---");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter and map
        System.out.println("Even numbers squared:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * n)
               .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // Sorted and distinct
        List<Integer> unsorted = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        System.out.println("Sorted and distinct: ");
        unsorted.stream()
                .distinct()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // FlatMap
        List<List<String>> nested = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("C", "D", "E"),
            Arrays.asList("F")
        );
        System.out.println("Flattened list: ");
        nested.stream()
              .flatMap(List::stream)
              .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");
    }
    
    private static void demonstrateTerminalOperations() {
        System.out.println("--- Terminal Operations ---");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Collect
        List<Integer> doubled = numbers.stream()
                                        .map(n -> n * 2)
                                        .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled);
        
        // Reduce
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // FindFirst
        Optional<Integer> firstEven = numbers.stream()
                                             .filter(n -> n % 2 == 0)
                                             .findFirst();
        firstEven.ifPresent(n -> System.out.println("First even: " + n));
        
        // AnyMatch, AllMatch
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Has even: " + hasEven);
        System.out.println("All positive: " + allPositive);
        
        // Count
        long count = numbers.stream().filter(n -> n > 3).count();
        System.out.println("Count > 3: " + count);
        
        System.out.println();
    }
    
    private static void demonstrateCollectors() {
        System.out.println("--- Collectors ---");
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "New York"),
            new Person("Bob", 30, "London"),
            new Person("Charlie", 25, "New York"),
            new Person("David", 35, "London")
        );
        
        // Grouping by city
        Map<String, List<Person>> byCity = people.stream()
                                                  .collect(Collectors.groupingBy(Person::getCity));
        System.out.println("Grouped by city: " + byCity);
        
        // Partitioning by age
        Map<Boolean, List<Person>> byAge = people.stream()
                                                  .collect(Collectors.partitioningBy(p -> p.getAge() >= 30));
        System.out.println("Partitioned by age >= 30: " + byAge);
        
        // Joining
        String names = people.stream()
                             .map(Person::getName)
                             .collect(Collectors.joining(", "));
        System.out.println("Joined names: " + names);
        
        // Averaging
        double avgAge = people.stream()
                              .collect(Collectors.averagingInt(Person::getAge));
        System.out.println("Average age: " + avgAge);
        
        System.out.println();
    }
    
    private static void demonstrateParallelStreams() {
        System.out.println("--- Parallel Streams ---");
        
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            numbers.add(i);
        }
        
        // Sequential stream
        long start = System.currentTimeMillis();
        long sum1 = numbers.stream()
                           .mapToLong(Integer::longValue)
                           .sum();
        long sequentialTime = System.currentTimeMillis() - start;
        System.out.println("Sequential sum: " + sum1 + " (Time: " + sequentialTime + "ms)");
        
        // Parallel stream
        start = System.currentTimeMillis();
        long sum2 = numbers.parallelStream()
                          .mapToLong(Integer::longValue)
                          .sum();
        long parallelTime = System.currentTimeMillis() - start;
        System.out.println("Parallel sum: " + sum2 + " (Time: " + parallelTime + "ms)");
        
        System.out.println();
    }
}

// Helper class for examples
class Person {
    private String name;
    private int age;
    private String city;
    
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getCity() {
        return city;
    }
    
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

