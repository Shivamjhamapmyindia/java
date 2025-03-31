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
        private Object data; // Use Object type to store the actual data (questions)
    
        // Constructor
        public ResponseObject(String status, String message) {
            this.status = status;
            this.message = message;
            this.data = null; // Initialize as null, data can be set later
        }
    
        // Getters and setters
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
            // Save the question to the database
            questionRepository.save(question);

            // Create response object with success status and message
            ResponseObject response = new ResponseObject("success", "Question added successfully");

            // Return the response object with HTTP status CREATED
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // Create response object with error status and message
            ResponseObject response = new ResponseObject("error", "Error adding question: " + e.getMessage());

            // Return the response object with HTTP status INTERNAL_SERVER_ERROR
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  public ResponseEntity<ResponseObject> getQuestions() {
    try {
        // Retrieve all questions from the database
        List<QuestionModel> questions = questionRepository.findAll();

        // Create a success response object with status "success" and questions as the data
        ResponseObject response = new ResponseObject("success", "Questions retrieved successfully");
        response.setData(questions); // Set the questions as part of the response data
        // Return response with HTTP status OK (200)
        return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
        // Create error response object with status "error" and error message
        ResponseObject response = new ResponseObject("error", "Error getting questions: " + e.getMessage());

        // Return response with HTTP status INTERNAL_SERVER_ERROR (500)
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
