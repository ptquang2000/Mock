package com.mock.project;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Controller
public class PageController {
  @GetMapping("")
  public String getLesson(RestTemplate restTemplate, Model model, @RequestParam(value = "lessonID",required = false)String id){
    if (id == null){
      Course[] courses = restTemplate.getForObject("http://localhost:8080/courses", Course[].class);
      model.addAttribute("courses", courses);
      return "course";
    }
    Quiz[] quizzes = restTemplate.getForObject(
        "http://localhost:8080/courses/" + id, Quiz[].class);
    model.addAttribute("quizzes", quizzes);
    model.addAttribute("noQuiz", quizzes.length);
    return "quiz";
  }
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }
}



