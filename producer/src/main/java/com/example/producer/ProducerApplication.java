package com.example.producer;

import com.example.producer.config.MainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainConfiguration.class, args);
	}

}
