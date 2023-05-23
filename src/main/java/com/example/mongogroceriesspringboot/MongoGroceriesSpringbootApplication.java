package com.example.mongogroceriesspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan("com.example.mongogroceriesspringboot")
public class MongoGroceriesSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoGroceriesSpringbootApplication.class, args);
    }

}
