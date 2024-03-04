package com.floods.ChatDemo.repository;

import com.floods.ChatDemo.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    // Find a channel by name
    Optional<Channel> findByName(String name);

    // You can add more custom queries here as needed
    // For example, finding channels by a specific attribute or criteria
}
