package com.floods.ChatDemo.service;

import com.floods.ChatDemo.model.Channel;
import com.floods.ChatDemo.repository.ChannelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChannelServiceTest {

    @Mock
    private ChannelRepository channelRepository;

    @InjectMocks
    private ChannelService channelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Similar test methods for addChannel, updateChannel, getChannelById, getAllChannels, deleteChannel
    // Example for getChannelById
    @Test
    void testGetChannelById() {
        Long channelId = 1L;
        Channel channel = new Channel();
        channel.setId(channelId);
        when(channelRepository.findById(channelId)).thenReturn(Optional.of(channel));

        Optional<Channel> foundChannel = channelService.getChannelById(channelId);

        verify(channelRepository, times(1)).findById(channelId);
        assertTrue(foundChannel.isPresent());
        assertEquals(channelId, foundChannel.get().getId());
    }
}
