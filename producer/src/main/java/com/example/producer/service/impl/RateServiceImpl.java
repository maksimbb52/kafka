package com.example.producer.service.impl;

import com.example.producer.dao.RateRepository;
import com.example.producer.model.RateModel;
import com.example.producer.service.RateService;
import com.example.producer.util.mapper.RateMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    @Override
    public RateModel findById(Long id) {
        return rateMapper.entityToModel(rateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rate with id " + id + " was not found")));
    }

    @Override
    public List<RateModel> findAllById(List<Long> ids) {
        return rateRepository.findAllById(ids)
                .stream()
                .map(rateMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<RateModel> findAll() {
        return rateRepository.findAll()
                .stream()
                .map(rateMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public RateModel save(RateModel rate) {
        return rateMapper.entityToModel(rateRepository.save(rateMapper.modelToEntity(rate)));
    }

    @Override
    public List<RateModel> saveAll(List<RateModel> rates) {
        return rateRepository.saveAll(
                rates.stream()
                     .map(rateMapper::modelToEntity)
                     .collect(Collectors.toList())
        ).stream()
         .map(rateMapper::entityToModel)
         .collect(Collectors.toList());
    }
}
