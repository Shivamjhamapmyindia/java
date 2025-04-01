package com.learningrestapi.learningrestapi.service;

import com.learningrestapi.learningrestapi.model.QuestionModel;
import com.learningrestapi.learningrestapi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.validation.Valid;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public class ResponseObject {
        private String status;
        private String message;
        private Object data;

        public ResponseObject(String status, String message) {
            this.status = status;
            this.message = message;
            this.data = null;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public ResponseEntity<ResponseObject> addQuestion(@Valid QuestionModel question) {
        try {
            questionRepository.save(question);
            ResponseObject response = new ResponseObject("success", "Question added successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseObject response = new ResponseObject("error", "Error adding question: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseObject> getQuestions() {
        try {
            List<QuestionModel> questions = questionRepository.findAll();
            ResponseObject response = new ResponseObject("success", "Questions retrieved successfully");
            response.setData(questions);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseObject response = new ResponseObject("error", "Error getting questions: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseObject> deleteQuestion(String id) {
        try {
            questionRepository.deleteById(id);
            ResponseObject response = new ResponseObject("success", "Question deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseObject response = new ResponseObject("error", "Error deleting question: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ResponseObject> updateQuestion(String id, QuestionModel question) {
        try {
            QuestionModel existingQuestion = questionRepository.findById(id).orElse(null);

            if (existingQuestion == null) {
                ResponseObject response = new ResponseObject("error", "Question not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            existingQuestion.setQuestion(question.getQuestion());
            existingQuestion.setOptions(question.getOptions());
            existingQuestion.setCorrectOption(question.getCorrectOption());
            questionRepository.save(existingQuestion);
            ResponseObject response = new ResponseObject("success", "Question updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseObject response = new ResponseObject("error", "Error updating question: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
