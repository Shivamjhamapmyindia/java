package com.learningrestapi.learningrestapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "questions")
public class QuestionModel {

    @Id
    private String id;

    @NotNull
    private String question;

    @NotNull
    private List<String> options;  // Use a List to store options

    @NotNull
    private String correctOption;

    // Constructor
    public QuestionModel(String question, List<String> options, String correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Getter and setter for ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter and setter for options
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    // Getter and setter for correctOption
    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
