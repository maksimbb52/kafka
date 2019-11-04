package com.example.producer.util.mapper;

import com.example.producer.entity.CurrencyEntity;
import com.example.producer.model.CurrencyModel;

public class CurrencyMapper {

    public CurrencyModel entityToModel(CurrencyEntity entity) {
        return CurrencyModel.builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .build();
    }

    public CurrencyEntity modelToEntity(CurrencyModel model) {
        return CurrencyEntity.builder()
                             .id(model.getId())
                             .name(model.getName())
                             .build();
    }
}
