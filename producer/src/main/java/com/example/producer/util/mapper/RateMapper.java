package com.example.producer.util.mapper;

import com.example.producer.entity.RateEntity;
import com.example.producer.model.RateModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RateMapper {

    private final CurrencyMapper currencyMapper;

    public RateModel entityToModel(RateEntity entity) {
        return RateModel.builder()
                .id(entity.getId())
                .currency(currencyMapper.entityToModel(entity.getCurrency()))
                .date(entity.getDate())
                .price(entity.getPrice())
                .time(entity.getTime())
                .build();
    }

    public RateEntity modelToEntity(RateModel model) {
        return RateEntity.builder()
                .id(model.getId())
                .currency(currencyMapper.modelToEntity(model.getCurrency()))
                .date(model.getDate())
                .price(model.getPrice())
                .time(model.getTime())
                .build();
    }
}
