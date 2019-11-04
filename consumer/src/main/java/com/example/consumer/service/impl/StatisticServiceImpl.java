package com.example.consumer.service.impl;

import com.example.consumer.dao.StatisticRepository;
import com.example.consumer.model.StatisticModel;
import com.example.consumer.service.StatisticService;
import com.example.consumer.util.mapper.StatisticMapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final StatisticMapper statisticMapper;

    @Override
    public StatisticModel findById(Long id) {
        return statisticMapper.entityToModel(
                statisticRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Statistic with id " + id + " was not found")
                )
        );
    }

    @Override
    public List<StatisticModel> findAll() {
        return statisticRepository.findAll()
                .stream()
                .map(statisticMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<StatisticModel> findAllById(List<Long> ids) {
        return statisticRepository.findAllById(ids)
                .stream()
                .map(statisticMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<StatisticModel> findByDateBetween(LocalDateTime from, LocalDateTime to) {
        return statisticRepository.findByDateBetween(from, to)
                .stream()
                .map(statisticMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public StatisticModel save(StatisticModel statistic) {
        return statisticMapper.entityToModel(statisticRepository.save(statisticMapper.modelToEntity(statistic)));
    }

    @Override
    public List<StatisticModel> saveAll(List<StatisticModel> statistics) {
        return statisticRepository.saveAll(
                statistics.stream()
                        .map(statisticMapper::modelToEntity)
                        .collect(Collectors.toList())
        ).stream()
                .map(statisticMapper::entityToModel)
                .collect(Collectors.toList());
    }
}
