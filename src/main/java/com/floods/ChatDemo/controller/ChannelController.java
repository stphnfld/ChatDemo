package com.floods.ChatDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.floods.ChatDemo.model.Channel;
import com.floods.ChatDemo.model.Message;
import com.floods.ChatDemo.service.ChannelService;
import com.floods.ChatDemo.service.MessageService;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.lang.NonNull;



@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;
    
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @PostMapping
    public Channel createChannel(@NonNull @RequestBody Channel channel) {
        return channelService.save(channel);
    }
    
    @GetMapping("{channelId")
    public ResponseEntity<List<Message>> getMessagesForChannel(@NonNull @PathVariable Long channelId) {
        List<Message> messages = messageService.getMessagesByChannelId(channelId);
        return ResponseEntity.ok(messages);
    }
    // Additional CRUD operations
}
