package com.floods.ChatDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
        // Registering the WebSocket endpoint that clients will use to connect
        registry.addEndpoint("/chat-websocket").withSockJS();
    }

    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry registry) {
        // Setting up a message broker for in-memory messaging (simple broker)
        registry.enableSimpleBroker("/topic");

        // Setting application destination prefixes for client-to-server communication
        registry.setApplicationDestinationPrefixes("/app");
    }
}
