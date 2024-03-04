package com.floods.ChatDemo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500) // Assuming a longer text for description
    private String description;

    // Assuming a many-to-many relationship with users
    @ManyToMany
    @JoinTable(
        name = "channel_users",
        joinColumns = @JoinColumn(name = "channel_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    // Assuming a one-to-many relationship with messages
    @OneToMany(mappedBy = "channel")
    private Set<Message> messages;

    public Channel() {
        // JPA requires a no-arg constructor
    }

    public Channel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    // Override methods like equals(), hashCode(), and toString() for better data handling

}
