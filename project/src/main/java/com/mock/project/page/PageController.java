package com.mock.project.page;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.course.Course;
import com.mock.project.form.CourseForm;
import com.mock.project.form.CourseFormService;
import com.mock.project.form.QuizForm;
import com.mock.project.form.QuizFormService;
import com.mock.project.quiz.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Controller
public class PageController {

  @Autowired
  private QuizFormService quizFormService;
  @Autowired
  private CourseFormService courseFormService;

  @PostMapping("/login-fail")
  public String loginFail(FormLoginConfigurer<?> config){
    return "redirect:/";
  }

  @GetMapping("")
  public String getPage(RestTemplate restTemplate,
  Model model,
  @RequestParam(value = "lessonID",required = false)String id,
  @RequestParam(value = "lessonName", required = false)String name){
    if (id == null){
      model.addAttribute("courseForm", new CourseForm());
      Course[] courses = restTemplate.getForObject("http://localhost:8080/courses",
      Course[].class);
      model.addAttribute("courses", courses);
      return "course";
    }
    model.addAttribute("quizForm", new QuizForm());
    Quiz[] quizzes = restTemplate.getForObject(
        "http://localhost:8080/courses/" + id, Quiz[].class);
    model.addAttribute("quizzes", quizzes);
    model.addAttribute("noQuiz", quizzes.length);
    model.addAttribute("course", name);
    return "quiz";
  }
  @PostMapping("/quiz-action")
  public String postQuizAction(@RequestParam(value = "action") String action, Quiz quiz){
    quizFormService.processForm(quiz, action);
    return "redirect:/?lessonID=" + Long.toString(quiz.getCourse().getId()) + "&lessonName=" + quiz.getCourse().getName();
  }
  @PostMapping("/course-action")
  public String postCourseAction(@RequestParam(value = "action") String action, Course course){
    courseFormService.processForm(course, action);
    return "redirect:/";
  }
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }
}


