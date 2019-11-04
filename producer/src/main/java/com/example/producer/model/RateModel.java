package com.example.producer.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class RateModel {

    private Long id;
    private CurrencyModel currency;
    private Double price;
    private LocalDate date;
    private LocalTime time;
}
