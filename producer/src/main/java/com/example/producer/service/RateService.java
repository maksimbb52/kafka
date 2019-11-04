package com.example.producer.service;

import com.example.producer.model.RateModel;

import java.util.List;

public interface RateService {

    RateModel findById(Long id);

    List<RateModel> findAllById(List<Long> ids);

    List<RateModel> findAll();

    RateModel save(RateModel rate);

    List<RateModel> saveAll(List<RateModel> rates);
}
