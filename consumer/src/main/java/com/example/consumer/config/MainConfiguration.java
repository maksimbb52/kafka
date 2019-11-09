package com.example.consumer.config;

import com.example.consumer.controller.SecurityController;
import com.example.consumer.dao.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(
        exclude = { SecurityAutoConfiguration.class }
)
@EnableMongoRepositories(basePackageClasses = {
        StatisticRepository.class
})
public class MainConfiguration {

    @Autowired
    MongoDbFactory mongoDbFactory;

    @Bean
    public MongoTemplate mongoTemplate() {

        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());

        //CALL THIS MANUALLY, so that all the default converters will be registered!
        converter.afterPropertiesSet();

        return new MongoTemplate(mongoDbFactory, converter);

    }

    @Bean
    public SecurityController securityController() {
        return new SecurityController();
    }


}
