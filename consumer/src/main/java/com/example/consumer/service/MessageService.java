package com.example.consumer.service;

import com.example.producer.model.RateModel;

public interface MessageService {

    void consume(RateModel rate);
}
