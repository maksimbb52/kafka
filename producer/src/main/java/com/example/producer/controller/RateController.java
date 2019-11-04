package com.example.producer.controller;

import com.example.producer.model.RateModel;
import com.example.producer.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequiredArgsConstructor
@RequestMapping(value = "rate", produces = MediaType.APPLICATION_JSON_VALUE)
public class RateController {

    private final RateService rateService;

    @GetMapping("/")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/")
    public String getHello1() {
        return "Hello";
    }

    @GetMapping("/{id}")
    public RateModel getRate(@PathVariable Long id) {
        return rateService.findById(id);
    }

    @GetMapping("/all")
    public List<RateModel> getAllRates() {
        return rateService.findAll();
    }

    @PostMapping("/new")
    public RateModel newCurrency(@RequestBody RateModel rate) {
        return rateService.save(rate);
    }

    @PostMapping("/newRates")
    public List<RateModel> newCurrencies(@RequestBody List<RateModel> rates) {
        return rateService.saveAll(rates);
    }
}
