package com.learning.lab.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Demonstrates Aspect-Oriented Programming (AOP)
 * Aspects can intercept method execution at any level
 */
@Aspect
@Component
public class LoggingAspect {
    
    @Around("@annotation(Loggable)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        System.out.println("Aspect: Before method execution - " + 
                          joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Aspect: Method executed in " + executionTime + "ms");
        
        return result;
    }
}

