package com.example.demo.Config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration disable for moment
public class AppConfig {

    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://mongo:27017");
    }
}