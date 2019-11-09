package com.example.producer.service;

import com.example.producer.model.RateModel;

public interface MessageService {

    void send(RateModel rate);
}
