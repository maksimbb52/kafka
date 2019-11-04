package com.example.producer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyModel {

    private Short id;
    private String name;
}
