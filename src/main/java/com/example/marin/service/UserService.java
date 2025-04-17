package com.example.marin.service;

import com.example.marin.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    
    Optional<User> findById(Long id);
    
    Optional<User> findByUsername(String username);
    
    Optional<User> findByEmail(String email);
    
    User save(User user);
    
    void deleteById(Long id);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
} 