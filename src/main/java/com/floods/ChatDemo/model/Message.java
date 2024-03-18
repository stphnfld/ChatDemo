package com.floods.ChatDemo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Assuming the sender is referenced by their username
    @Column(nullable = false)
    private String sender;

    // Referencing the channel by its ID
    @Column(name = "channel_id", nullable = false)
    private Long channelId;

    public Message() {
        // JPA requires a no-arg constructor
    }

    public Message(String content, LocalDateTime timestamp, String sender, Long channelId) {
        this.content = content;
        this.timestamp = timestamp;
        this.sender = sender;
        this.channelId = channelId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    // Override methods like equals(), hashCode(), and toString()
}