package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.User;
import com.floods.ChatDemo.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to add a new user
    public User addUser(@NonNull User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Method to update an existing user
    public User updateUser(@NonNull User user) {
        return userRepository.save(user);
    }

    // Method to find a user by id
    public Optional<User> getUserById(@NonNull Long id) {
        return userRepository.findById(id);
    }

    // Method to find all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to delete a user
    public void deleteUser(@NonNull Long id) {
        userRepository.deleteById(id);
    }
    
    // Method to find a user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
