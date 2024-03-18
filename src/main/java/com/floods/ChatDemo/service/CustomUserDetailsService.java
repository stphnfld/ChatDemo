package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.User;
import com.floods.ChatDemo.security.UserPrincipal;
import com.floods.ChatDemo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        try {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

            Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
            user.getRoles().forEach(role -> {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
                role.getPermissions().forEach(permission ->
                        grantedAuthorities.add(new SimpleGrantedAuthority(permission))); // Ensure your Permission model has a getName method or adjust accordingly
            });

            // Create and return a UserPrincipal instance
            return new UserPrincipal(user.getUsername(), user.getPassword(), grantedAuthorities);
        } catch (UsernameNotFoundException e) {
            logger.error("User not found with username: {}", username);
            throw e;
        } catch (Exception e) {
            logger.error("Error loading user by username: {}", username, e);
            throw new UsernameNotFoundException("Error loading user by username", e);
        }
    }

}
