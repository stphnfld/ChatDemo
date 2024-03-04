package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.User;
import com.floods.ChatDemo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        // Arrange
        User user = new User();
        // Set required fields on the user object here, for example:
        // user.setId(1L);
        // user.setName("Test User");
        // user.setEmail("test@email.com");
        // ... set other properties as needed

        when(userRepository.save(user)).thenReturn(user); // Use an actual User instance

        // Act
        User result = userService.addUser(user);

        // Assert
        verify(userRepository, times(1)).save(user); // Use the actual User instance for verification
        assertNotNull(result);
    }

    
    // Other test methods...
}
