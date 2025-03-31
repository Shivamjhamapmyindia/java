package com.quiz.quizapp.repository;

import com.quiz.quizapp.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {
}