package com.mock.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class CourselistController {

    @GetMapping("/courselist")
    public String hello(RestTemplate restTemplate, Model model) {
        Course[] courses = restTemplate.getForObject("http://localhost:8080/courses", Course[].class);
        model.addAttribute("courses", courses);
        return "courselist";
    }
}