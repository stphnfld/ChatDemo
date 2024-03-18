package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.Message;
import com.floods.ChatDemo.repository.MessageRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Method to send (add) a new message
    public Message sendMessage(@NonNull Message message) {
        return messageRepository.save(message);
    }

    // Method to update an existing message
    public Message updateMessage(@NonNull Message message) {
        return messageRepository.save(message);
    }

    // Method to retrieve a list of messages by channelId
    public List<Message> getMessagesByChannelId(@NonNull Long channelId) {
        return messageRepository.findByChannelId(channelId);
    }

    // Method to get a message by its ID
    public Optional<Message> getMessageById(@NonNull Long id) {
        return messageRepository.findById(id);
    }

    // Method to delete a message
    public void deleteMessage(@NonNull Long id) {
        messageRepository.deleteById(id);
    }

    // Additional methods can be added here as per your application requirements
}