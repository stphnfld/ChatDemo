package com.floods.ChatDemo.controller;

import com.floods.ChatDemo.model.Channel;
import com.floods.ChatDemo.model.Message;
import com.floods.ChatDemo.model.Confirmation;
import com.floods.ChatDemo.service.ChannelService;
import com.floods.ChatDemo.service.MessageService;
import com.floods.ChatDemo.exception.InvalidMessageException;
import com.floods.ChatDemo.exception.RecipientNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Confirmation> sendMessage(@RequestBody @NonNull Message message) {
        try {
            messageService.sendMessage(message);
            return ResponseEntity.ok(new Confirmation(true));
        } catch (InvalidMessageException e) {
            return ResponseEntity.badRequest().body(new Confirmation(false, e.getMessage()));
        } catch (RecipientNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Confirmation(false, e.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Confirmation(false, "An error occurred while sending the message"));
        }
    }

    @GetMapping("/messages/{channelId}")
    public ResponseEntity<List<Message>> getMessagesByChannelId(@PathVariable @NonNull Long channelId) {
        List<Message> messages = messageService.getMessagesByChannelId(channelId);
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