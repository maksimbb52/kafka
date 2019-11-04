package com.example.producer.service;

import com.example.producer.model.CurrencyModel;

import java.util.List;

public interface CurrencyService {

    CurrencyModel findById(Short id);

    List<CurrencyModel> findAllById(List<Short> ids);

    List<CurrencyModel> findAll();

    CurrencyModel save(CurrencyModel currency);

    List<CurrencyModel> saveAll(List<CurrencyModel> currencies);
}
