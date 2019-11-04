package com.example.consumer.dao;

import com.example.consumer.entity.StatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticRepository extends MongoRepository<StatisticEntity, Long> {

    List<StatisticEntity> findAllById(List<Long> ids);

    @Query("{'date':{ $lt: ?0, $gt: ?1}}")
    List<StatisticEntity> findByDateBetween(LocalDateTime from, LocalDateTime to);
}
