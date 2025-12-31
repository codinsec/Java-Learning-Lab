package com.learning.lab.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates Java multithreading and concurrency
 */
public class ConcurrencyDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java Multithreading and Concurrency Demo ===\n");
        
        // Thread Creation
        demonstrateThreadCreation();
        
        // Synchronization
        demonstrateSynchronization();
        
        // Thread Pools
        demonstrateThreadPools();
        
        // CompletableFuture
        demonstrateCompletableFuture();
        
        // Atomic Classes
        demonstrateAtomicClasses();
    }
    
    private static void demonstrateThreadCreation() {
        System.out.println("--- Thread Creation ---");
        
        // Extending Thread
        Thread thread1 = new MyThread("Thread-1");
        thread1.start();
        
        // Implementing Runnable
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        thread2.start();
        
        // Lambda expression
        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running (lambda)");
        }, "Thread-3");
        thread3.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    private static void demonstrateSynchronization() {
        System.out.println("--- Synchronization ---");
        
        Counter counter = new Counter();
        
        // Create multiple threads accessing shared counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter value (should be 2000): " + counter.getValue());
        System.out.println();
    }
    
    private static void demonstrateThreadPools() {
        System.out.println("--- Thread Pools ---");
        
        // Fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    private static void demonstrateCompletableFuture() {
        System.out.println("--- CompletableFuture ---");
        
        // Simple async operation
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        
        // Chain operations
        CompletableFuture<String> result = future
            .thenApply(s -> s + " World")
            .thenApply(String::toUpperCase);
        
        try {
            System.out.println("Result: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        // Combine multiple futures
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "First");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Second");
        
        CompletableFuture<String> combined = future1.thenCombine(future2, 
            (s1, s2) -> s1 + " + " + s2);
        
        try {
            System.out.println("Combined: " + combined.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        System.out.println();
    }
    
    private static void demonstrateAtomicClasses() {
        System.out.println("--- Atomic Classes ---");
        
        AtomicInteger atomicCounter = new AtomicInteger(0);
        
        // Multiple threads incrementing atomic counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Atomic counter value (should be 2000): " + 
                          atomicCounter.get());
        System.out.println();
    }
}

// ========== Thread Examples ==========

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        System.out.println(getName() + " running (extends Thread)");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + 
                         " running (implements Runnable)");
    }
}

// ========== Synchronization Example ==========

class Counter {
    private int value = 0;
    
    // Synchronized method
    public synchronized void increment() {
        value++;
    }
    
    public synchronized int getValue() {
        return value;
    }
}

