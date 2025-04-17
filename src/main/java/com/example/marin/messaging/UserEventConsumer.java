package com.example.marin.messaging;

import com.example.marin.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserEventConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleUserEvent(UserEvent event) {
        log.info("Received user event: {}", event);
        
        switch (event.getEventType()) {
            case "CREATED":
                log.info("User created: ID={}, Username={}", event.getUserId(), event.getUsername());
                break;
            case "UPDATED":
                log.info("User updated: ID={}, Username={}", event.getUserId(), event.getUsername());
                break;
            case "DELETED":
                log.info("User deleted: ID={}, Username={}", event.getUserId(), event.getUsername());
                break;
            default:
                log.warn("Unknown event type: {}", event.getEventType());
        }
    }
} 