package com.example.producer.config;

import com.example.producer.controller.CurrencyController;
import com.example.producer.dao.CurrencyRepository;
import com.example.producer.service.CurrencyService;
import com.example.producer.service.impl.CurrencyServiceImpl;
import com.example.producer.util.mapper.CurrencyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfiguration {

    @Bean
    public CurrencyMapper currencyMapper() {
        return new CurrencyMapper();
    }

    @Bean
    public CurrencyService currencyService(CurrencyRepository currencyRepository) {
        return new CurrencyServiceImpl(
                currencyRepository,
                currencyMapper()
        );
    }

    @Bean
    public CurrencyController currencyController() {
        return new CurrencyController(currencyService(null));
    }
}
