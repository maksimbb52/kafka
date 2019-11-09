package com.example.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateModel {

    private Long id;
    private CurrencyModel currency;
    private Double price;
    private LocalDate date;
    private LocalTime time;
}
