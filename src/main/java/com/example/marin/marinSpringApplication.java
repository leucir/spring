package com.example.marin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class marinSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(marinSpringApplication.class, args);
    }
} 