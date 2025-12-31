# Filters, Interceptors, and Aspects

## Overview
This topic covers cross-cutting concerns in Spring Boot applications: filters, interceptors, and aspects (AOP). These mechanisms allow you to add functionality that applies across multiple endpoints.

## Learning Objectives
- Understand the difference between filters, interceptors, and aspects
- Learn to create and configure filters
- Master Spring interceptors for request/response handling
- Understand Aspect-Oriented Programming (AOP)
- Learn when to use each approach

## Topics Covered
1. **Filters**: Servlet filters, @Component filters
2. **Interceptors**: HandlerInterceptor, WebMvcConfigurer
3. **Aspects**: @Aspect, @Before, @After, @Around
4. **Pointcuts**: @Pointcut, execution expressions
5. **Use Cases**: Logging, authentication, performance monitoring

## Code Examples

### Filter
```java
@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain chain) {
        // Pre-processing
        chain.doFilter(request, response);
        // Post-processing
    }
}
```

### Interceptor
```java
@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, 
                           HttpServletResponse response, Object handler) {
        // Before controller execution
        return true;
    }
}
```

### Aspect
```java
@Aspect
@Component
public class LoggingAspect {
    @Around("@annotation(Loggable)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) {
        // Around method execution
    }
}
```

## How to Run

### Using Maven
```bash
cd 27-Filters-Interceptors-Aspects
mvn spring-boot:run
```

### Using IDE
1. Open the project in your IDE
2. Run `AopApplication.java` as Spring Boot application
3. Access endpoints to see filters/interceptors/aspects in action

## Key Concepts

### Filters vs Interceptors vs Aspects
- **Filters**: Servlet level, before/after servlet processing
- **Interceptors**: Spring MVC level, before/after controller execution
- **Aspects**: Method level, can intercept any method call

### Execution Order
1. Filter (doFilter)
2. Interceptor (preHandle)
3. Controller method
4. Interceptor (postHandle)
5. Interceptor (afterCompletion)
6. Filter (after doFilter)

### Use Cases
- **Filters**: CORS, encoding, security headers
- **Interceptors**: Request logging, authentication checks
- **Aspects**: Transaction management, logging, caching

### AOP Concepts
- **Aspect**: Modularization of cross-cutting concerns
- **Join Point**: Point in execution (method call)
- **Pointcut**: Expression matching join points
- **Advice**: Action taken at join point

## Exercises
1. Create a filter for request/response logging
2. Implement an interceptor for authentication
3. Create an aspect for method execution time
4. Combine filters, interceptors, and aspects

---
**Created by:** [Codinsec](https://codinsec.com) | [info@codinsec.com](mailto:info@codinsec.com)  
**Author:** Barbaros Kaymak

