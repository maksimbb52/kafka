package com.example.producer.service.impl;

import com.example.producer.model.RateModel;
import com.example.producer.service.MessageService;
import com.example.producer.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<Long, RateModel> kafkaTemplate;
    private final RateService rateService;

    private Long counter = 1L;

    @Override
    public void send(RateModel rate) {
        kafkaTemplate.send("server.rate", rate);
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void scheduledSending() {
        if (counter > 16) {
            counter = 1L;
        }
        send(rateService.findById(counter++));
    }
}
