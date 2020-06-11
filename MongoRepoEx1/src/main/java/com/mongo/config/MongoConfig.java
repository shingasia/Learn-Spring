package com.mongo.config;

import java.util.Arrays;
import java.util.Collection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = "com.mongo.repositories")
@EnableMongoRepositories(basePackages = "com.mongo.repositories")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    protected String getDatabaseName() {
        return "spring";
    }

    // @Override
    // protected Collection<String> getMappingBasePackages() {

    // // return Arrays.asList("example.first", "example.second");
    // return Arrays.asList("com.mongo.repositories");
    // }
}