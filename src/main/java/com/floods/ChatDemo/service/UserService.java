package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.User;
import com.floods.ChatDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to add a new user
    public User addUser(@NonNull User user) {
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

    // Additional methods as needed for your application can be added here
}
