package com.floods.ChatDemo.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordCheck {

    public static void main(String[] args) {
        // The raw password entered by the user
        String rawPassword = "bacon19";
        
        // The BCrypt hash stored in your database for the user
        String storedHash = "$2a$10$IvS1v6CWvNMbmzzlnaToFeeyRcxbaRjm3AWvafNnb1Z6PrUuRY.0a";

        // Create an instance of the BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // Check whether the raw password matches the stored hash
        boolean isMatch = passwordEncoder.matches(rawPassword, storedHash);

        // Output the result
        System.out.println(passwordEncoder.encode(rawPassword));
        System.out.println("Password match: " + isMatch);
    }
}
