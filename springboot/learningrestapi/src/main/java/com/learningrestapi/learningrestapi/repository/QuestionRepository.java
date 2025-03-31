package com.learningrestapi.learningrestapi.repository;

import com.learningrestapi.learningrestapi.model.QuestionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<QuestionModel, String> {
    // You can define custom query methods here if needed
}
