package com.example.consumer.service;

import com.example.consumer.model.StatisticModel;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticService {

    StatisticModel findById(Long id);

    List<StatisticModel> findAll();

    List<StatisticModel> findAllById(List<Long> ids);

    List<StatisticModel> findByDateBetween(LocalDateTime from, LocalDateTime to);

    StatisticModel save(StatisticModel statistic);

    List<StatisticModel> saveAll(List<StatisticModel> statistics);
}
