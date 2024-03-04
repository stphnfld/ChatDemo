package com.floods.ChatDemo.controller;

import com.floods.ChatDemo.model.Channel;
import com.floods.ChatDemo.model.Message;
import com.floods.ChatDemo.service.ChannelService;
import com.floods.ChatDemo.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;
    private final ChannelService channelService;

    public ChatController(MessageService messageService, ChannelService channelService) {
        this.messageService = messageService;
        this.channelService = channelService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody @NonNull Message message) {
        Message sentMessage = messageService.sendMessage(message);
        return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/messages/{channelId}")
    public ResponseEntity<List<Message>> getMessagesByChannel(@PathVariable @NonNull String channelId) {
        List<Message> messages = messageService.getMessagesByChannel(channelId);
        return messages.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(messages);
    }

    @PostMapping("/channel")
    public ResponseEntity<Channel> createChannel(@RequestBody @NonNull Channel channel) {
        Channel newChannel = channelService.addChannel(channel);
        return ResponseEntity.ok(newChannel);
    }

    @GetMapping("/channel/{id}")
    public ResponseEntity<Channel> getChannelById(@PathVariable @NonNull Long id) {
        return channelService.getChannelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Additional methods can be added here for more functionalities
}
