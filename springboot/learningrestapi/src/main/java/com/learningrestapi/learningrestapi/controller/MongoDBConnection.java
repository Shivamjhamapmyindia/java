package com.learningrestapi.learningrestapi.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.context.annotation.Bean;
// import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class MongoDBConnection implements CommandLineRunner {

    private final MongoTemplate mongoTemplate;

    // Inject MongoTemplate using constructor-based dependency injection
    public MongoDBConnection(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoDBConnection.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // This method runs after the application starts
        // Use MongoTemplate to interact with the database and verify the connection
        System.out.println("Connected to MongoDB: " + mongoTemplate.getDb().getName());
    }

    // // Optionally, you can define a MongoOperations bean if needed (MongoTemplate is a subclass of MongoOperations)
    // @Bean
    // public MongoOperations mongoOperations() {
    //     return mongoTemplate;
    // }
}
