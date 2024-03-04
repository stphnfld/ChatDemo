package com.floods.ChatDemo.repository;

import com.floods.ChatDemo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Find messages by sender
    List<Message> findBySender(String sender);

    // Find messages in a specific channel
    List<Message> findByChannel(String channel);

    // Find messages within a specific time range
    List<Message> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    // Additional custom queries can be added here based on application needs
}
