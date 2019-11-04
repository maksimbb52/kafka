package com.example.producer.config;

import com.example.producer.controller.RateController;
import com.example.producer.dao.RateRepository;
import com.example.producer.service.RateService;
import com.example.producer.service.impl.RateServiceImpl;
import com.example.producer.util.mapper.CurrencyMapper;
import com.example.producer.util.mapper.RateMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateConfiguration {

    @Bean
    public RateMapper rateMapper(CurrencyMapper currencyMapper) {
        return new RateMapper(currencyMapper);
    }

    @Bean
    public RateService rateService(RateRepository rateRepository) {
        return new RateServiceImpl(
                rateRepository,
                rateMapper(null)
        );
    }

    @Bean
    public RateController rateController() {
        return new RateController(rateService(null));
    }
}
