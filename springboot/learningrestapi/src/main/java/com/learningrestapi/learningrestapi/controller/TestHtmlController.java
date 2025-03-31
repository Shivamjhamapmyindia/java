package com.learningrestapi.learningrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Define a simple data class (DTO) to return for the `/object` route
class MyObject {
    private String field1;
    private String field2;

    // Constructor
    public MyObject(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    // Getters
    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    // Setters
    public void setField1(String field1) {
        this.field1 = field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}

@Controller
@RequestMapping("/testHtml")
public class TestHtmlController {

    @GetMapping("/")
    public String index() {
        // This will render "test.html" from the templates folder
        return "test";  // Ensure the template exists in the "templates" folder
    }

    @GetMapping("/text")
    @ResponseBody
    public String text() {
        // Return plain text
        return "text mnm,sb.njbjh";
    }

    @GetMapping("/object")
    @ResponseBody
    public MyObject object() {
        // Return a custom object that will be automatically serialized to JSON
        return new MyObject("text mnm,sb.njbjh", "text mnm,sb.njbjh");
    }
}
