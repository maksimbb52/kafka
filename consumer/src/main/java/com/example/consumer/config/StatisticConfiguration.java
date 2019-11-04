package com.example.consumer.config;

import com.example.consumer.controller.StatisticController;
import com.example.consumer.dao.StatisticRepository;
import com.example.consumer.service.StatisticService;
import com.example.consumer.service.impl.StatisticServiceImpl;
import com.example.consumer.util.mapper.StatisticMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StatisticConfiguration {

    @Bean
    public StatisticMapper statisticMapper() {
        return new StatisticMapper();
    }

    @Bean
    public StatisticService statisticService(StatisticRepository statisticRepository) {
        return new StatisticServiceImpl(
                statisticRepository,
                statisticMapper()
        );
    }

    @Bean
    public StatisticController statisticController() {
        return new StatisticController(statisticService(null));
    }
}
