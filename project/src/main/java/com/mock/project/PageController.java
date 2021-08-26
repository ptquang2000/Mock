package com.mock.project;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Controller
public class PageController {
  @GetMapping("/{lesson}")
  public String getLesson(@PathVariable String lesson, RestTemplate restTemplate, Model model, @RequestParam(value = "lessonName",required = false)String name){
    Quiz[] quizzes = restTemplate.getForObject(
        "http://localhost:8080/courses/1", Quiz[].class);
    model.addAttribute("quizzes", quizzes);
    model.addAttribute("lessonName", name);
    model.addAttribute("noQuiz", quizzes.length);
    return "addQuiz";
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }



}



