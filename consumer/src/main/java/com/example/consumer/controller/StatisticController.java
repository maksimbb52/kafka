package com.example.consumer.controller;

import com.example.consumer.model.StatisticModel;
import com.example.consumer.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequiredArgsConstructor
@RequestMapping(value = "/statistic", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/new")
    public StatisticModel newStatistic(@RequestBody StatisticModel statistic) {
        return statisticService.save(statistic);
    }

    @PostMapping("/newStatistics")
    public List<StatisticModel> newStatistics(@RequestBody List<StatisticModel> statistics) {
        return statisticService.saveAll(statistics);
    }

    @GetMapping("/all")
    public List<StatisticModel> getStatistics() {
        return statisticService.findAll();
    }
}
