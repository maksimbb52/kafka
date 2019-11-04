package com.example.producer.controller;

import com.example.producer.model.CurrencyModel;
import com.example.producer.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping()
    public String getHello() {
        return "Hello-Post";
    }

    @PostMapping("/newCurrency")
    public CurrencyModel newCurrency(@RequestBody CurrencyModel currency) {
        return currencyService.save(currency);
    }

    @PostMapping("/newCurrencies")
    public List<CurrencyModel> newCurrencies(@RequestBody List<CurrencyModel> currencies) {
        return currencyService.saveAll(currencies);
    }
}
