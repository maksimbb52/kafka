package com.example.consumer.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StatisticModel {

    private String id;
    private LocalDateTime fromDt;
    private LocalDateTime toDt;
    private Double average;
    private Boolean isGreater;
}
