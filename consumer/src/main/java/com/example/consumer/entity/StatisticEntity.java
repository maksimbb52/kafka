package com.example.consumer.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "statistic")
public class StatisticEntity {

    @Id
    private String id;

    @Field(value = "from_dt")
    private LocalDateTime fromDt;

    @Field(value = "to_dt")
    private LocalDateTime toDt;

    private Double average;

    @Field(value = "is_greater")
    private Boolean isGreater;
}

