package com.example.consumer;

import com.example.consumer.config.MainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainConfiguration.class, args);
    }

}
