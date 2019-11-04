package com.example.producer.service.impl;

import com.example.producer.dao.CurrencyRepository;
import com.example.producer.entity.CurrencyEntity;
import com.example.producer.model.CurrencyModel;
import com.example.producer.service.CurrencyService;
import com.example.producer.util.mapper.CurrencyMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Override
    public CurrencyModel findById(Short id) {
        return currencyMapper.entityToModel(currencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currency with id " + id + " was not found")));
    }

    @Override
    public List<CurrencyModel> findAllById(List<Short> ids) {
        return currencyRepository.findAllById(ids)
                .stream()
                .map(currencyMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CurrencyModel> findAll() {
        return currencyRepository.findAll()
                .stream()
                .map(currencyMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyModel save(CurrencyModel currency) {
        return currencyMapper.entityToModel(currencyRepository.save(currencyMapper.modelToEntity(currency)));
    }

    @Override
    public List<CurrencyModel> saveAll(List<CurrencyModel> currencies) {
        return currencyRepository.saveAll(
                currencies.stream()
                        .map(currencyMapper::modelToEntity)
                        .collect(Collectors.toList())
        ).stream()
                .map(currencyMapper::entityToModel)
                .collect(Collectors.toList());
    }
}
