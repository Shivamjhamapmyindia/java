package com.quiz.quizapp.services;

import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(String id, Question question) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    existingQuestion.setQuestionText(question.getQuestionText());
                    existingQuestion.setAnswer(question.getAnswer());
                    existingQuestion.setOptions(question.getOptions());
                    return questionRepository.save(existingQuestion);
                }).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    public void resetQuestions() {
        questionRepository.deleteAll();
    }
}