package com.example.marin.messaging;

import com.example.marin.config.RabbitMQConfig;
import com.example.marin.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventProducer {

    private final RabbitTemplate rabbitTemplate;
    
    // Explicit constructor
    public UserEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendUserCreatedEvent(User user) {
        UserEvent event = new UserEvent("CREATED", user.getId(), user.getUsername());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
    }
    
    public void sendUserUpdatedEvent(User user) {
        UserEvent event = new UserEvent("UPDATED", user.getId(), user.getUsername());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
    }
    
    public void sendUserDeletedEvent(Long userId, String username) {
        UserEvent event = new UserEvent("DELETED", userId, username);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
    }
} 