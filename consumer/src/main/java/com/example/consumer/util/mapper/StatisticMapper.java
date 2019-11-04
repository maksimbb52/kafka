package com.example.consumer.util.mapper;

import com.example.consumer.entity.StatisticEntity;
import com.example.consumer.model.StatisticModel;

public class StatisticMapper {

    public StatisticModel entityToModel(StatisticEntity entity) {
        return StatisticModel.builder()
                .id(entity.getId())
                .average(entity.getAverage())
                .fromDt(entity.getFromDt())
                .toDt(entity.getToDt())
                .isGreater(entity.getIsGreater())
                .build();
    }

    public StatisticEntity modelToEntity(StatisticModel model) {
        return StatisticEntity.builder()
                .id(model.getId())
                .average(model.getAverage())
                .fromDt(model.getFromDt())
                .toDt(model.getToDt())
                .isGreater(model.getIsGreater())
                .build();
    }
}
