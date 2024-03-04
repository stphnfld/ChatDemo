package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.Channel;
import com.floods.ChatDemo.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    // Method to add a new channel
    public Channel addChannel(@NonNull Channel channel) {
        return channelRepository.save(channel);
    }

    // Method to update an existing channel
    public Channel updateChannel(@NonNull Channel channel) {
        return channelRepository.save(channel);
    }

    // Method to find a channel by id
    public Optional<Channel> getChannelById(@NonNull Long id) {
        return channelRepository.findById(id);
    }

    // Method to find a channel by name
    public Optional<Channel> getChannelByName(@NonNull String name) {
        return channelRepository.findByName(name);
    }

    // Method to find all channels
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    // Method to delete a channel
    public void deleteChannel(@NonNull Long id) {
        channelRepository.deleteById(id);
    }

    // Additional methods as needed for your application can be added here
}
