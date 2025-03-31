package com.learningrestapi.learningrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testHtml2")
public class Test2HtmlController {
        @GetMapping("/")
        public String test2Html(){
                return "test2";
        }
}
