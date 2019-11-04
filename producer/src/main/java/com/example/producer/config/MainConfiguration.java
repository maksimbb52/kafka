package com.example.producer.config;

import com.example.producer.controller.SecurityController;
import com.example.producer.dao.CurrencyRepository;
import com.example.producer.dao.RateRepository;
import com.example.producer.entity.CurrencyEntity;
import com.example.producer.entity.RateEntity;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
        CurrencyRepository.class,
        RateRepository.class
})
@EntityScan(basePackageClasses = {
        CurrencyEntity.class,
        RateEntity.class
})
public class MainConfiguration {

    @Bean
    public SecurityController securityController() {
        return new SecurityController();
    }
}
