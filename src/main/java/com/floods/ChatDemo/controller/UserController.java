package com.floods.ChatDemo.controller;

import com.floods.ChatDemo.model.User;
import com.floods.ChatDemo.exception.ErrorResponse;
import com.floods.ChatDemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.dao.DataIntegrityViolationException;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<Object> addUser(@NonNull @RequestBody User user) {
        try {
            User newUser = userService.addUser(user);
            return ResponseEntity.ok(newUser);
        } catch (DataIntegrityViolationException ex) {
            String errorMessage = parseDataIntegrityViolationMessage(ex);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(errorMessage));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("An error occurred while creating the user"));
        }
    }

    private String parseDataIntegrityViolationMessage(DataIntegrityViolationException ex) {
        if (ex.getMessage() != null) {
            if (ex.getMessage().contains("email")) {
                return "Email already exists";
            } else if (ex.getMessage().contains("username")) {
                return "Username already exists";
            }
        }
        return "Duplicate entry";
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    
    // PUT: Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable @NonNull Long id, @RequestBody @NonNull User user) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // GET: Retrieve a user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @NonNull Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // DELETE: Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @NonNull Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    // Additional handler methods can be added here as per your application requirements
}
