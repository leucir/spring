package com.example.marin.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent implements Serializable {
    
    private String eventType;
    private Long userId;
    private String username;
    private LocalDateTime timestamp = LocalDateTime.now();
    
    public UserEvent(String eventType, Long userId, String username) {
        this.eventType = eventType;
        this.userId = userId;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }
    
    // Explicit getters and setters
    public String getEventType() {
        return eventType;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
} 