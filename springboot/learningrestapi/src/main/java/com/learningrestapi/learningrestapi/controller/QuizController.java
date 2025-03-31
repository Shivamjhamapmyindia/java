package com.learningrestapi.learningrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learningrestapi.learningrestapi.model.QuestionModel;
import com.learningrestapi.learningrestapi.service.QuestionService;
import com.learningrestapi.learningrestapi.service.QuestionService.ResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/home")
    public String quizhtml() {
        return "quiz";
    }

    @GetMapping("/login")
    public String loginhtml() {
        return "login";
    }

    @GetMapping("/addQuestions")
    public String registerhtml() {
        return "addQuestions";
    }

    @PostMapping("/addNewQuestion")
    public ResponseEntity<ResponseObject> addNewQuestion(@RequestBody QuestionModel question) {
        return questionService.addQuestion(question); // Delegate to the service
    }
    
    @GetMapping("/getQuestions")
    @ResponseBody
    public ResponseEntity<ResponseObject> getQuestions() {
        return questionService.getQuestions(); // Delegate to the service
    }
}
