package com.floods.ChatDemo.repository;

import com.floods.ChatDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username
    Optional<User> findByUsername(String username);

    // Find a user by email
    Optional<User> findByEmail(String email);

    // Check if a username exists
    Boolean existsByUsername(String username);

    // Check if an email exists
    Boolean existsByEmail(String email);

}
