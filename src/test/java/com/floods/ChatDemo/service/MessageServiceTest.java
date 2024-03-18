package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.Message;
import com.floods.ChatDemo.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Similar test methods for addMessage, updateMessage, getMessageById, getAllMessages, deleteMessage
    // Example for getMessageById
    @Test
    void testGetMessageById() {
        Long messageId = 1L;
        Message message = new Message();
        message.setId(messageId);
        when(messageRepository.findById(messageId)).thenReturn(Optional.of(message));

        Optional<Message> foundMessage = messageService.getMessageById(messageId);

        verify(messageRepository, times(1)).findById(messageId);
        assertTrue(foundMessage.isPresent());
        assertEquals(messageId, foundMessage.get().getId());
    }
}
