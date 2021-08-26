package com.mock.project;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.course.Course;
import com.mock.project.form.QuizForm;
import com.mock.project.form.QuizFormService;
import com.mock.project.quiz.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Controller
public class PageController {

  @Autowired
  private QuizFormService quizFormService;

  @GetMapping("")
  public String getPage(RestTemplate restTemplate,
  Model model,
  @RequestParam(value = "lessonID",required = false)String id,
  @AuthenticationPrincipal User user){
    model.addAttribute("quizForm", new QuizForm());
    if (id == null){
      Course[] courses = restTemplate.getForObject("http://localhost:8080/courses", Course[].class);
      model.addAttribute("courses", courses);
      return "course";
    }
    Quiz[] quizzes = restTemplate.getForObject(
        "http://localhost:8080/courses/" + id, Quiz[].class);
    model.addAttribute("quizzes", quizzes);
    model.addAttribute("noQuiz", quizzes.length);
    model.addAttribute("course", quizzes[0].getCourse().getName());
    return "quiz";
  }
  @PostMapping("/quiz-form")
  public String postQuiz(@ModelAttribute QuizForm quizForm, RedirectAttributes redirectAttributes){
    return quizFormService.processForm(quizForm);
  }
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }
}



