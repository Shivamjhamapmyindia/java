package com.quiz.quizapp.controllers;


import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String getAllQuestions(Model model) {
        List<Question> questions = quizService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/add")
    public String addQuestion(@ModelAttribute Question question) {
        quizService.addQuestion(question);
        return "redirect:/quiz/";
    }

    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable String id, @ModelAttribute Question question) {
        quizService.updateQuestion(id, question);
        return "redirect:/quiz/";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable String id) {
        quizService.deleteQuestion(id);
        return "redirect:/quiz/";
    }

    @GetMapping("/reset")
    public String resetQuestions() {
        quizService.resetQuestions();
        return "redirect:/quiz/";
    }
}