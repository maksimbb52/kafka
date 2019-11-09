package com.example.consumer.service.impl;

import com.example.consumer.service.MessageService;
import com.example.producer.model.RateModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final ObjectMapper objectMapper;

    @Override
    @KafkaListener(id = "Rate", topics = {"server.rate"}, containerFactory = "singleFactory")
    public void consume(RateModel rate) {
        log.info("=> consumed {}", writeValueAsString(rate));
    }

    private String writeValueAsString(RateModel rate) {
        try {
            return objectMapper.writeValueAsString(rate);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + rate.toString());
        }
    }
}
