package com.learning.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Mockito test examples
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    void testFindUser() {
        // Arrange
        Long userId = 1L;
        User expectedUser = new User("Alice", "alice@example.com");
        expectedUser.setId(userId);
        
        when(userRepository.findById(userId)).thenReturn(expectedUser);
        
        // Act
        User result = userService.findUser(userId);
        
        // Assert
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals("alice@example.com", result.getEmail());
        
        // Verify interaction
        verify(userRepository, times(1)).findById(userId);
    }
    
    @Test
    void testCreateUser() {
        // Arrange
        User newUser = new User("Bob", "bob@example.com");
        User savedUser = new User("Bob", "bob@example.com");
        savedUser.setId(1L);
        
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        
        // Act
        User result = userService.createUser("Bob", "bob@example.com");
        
        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(userRepository, times(1)).save(any(User.class));
    }
}

