package com.mock.project;

import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(value = "/courses/add", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
  
    @ExceptionHandler(SQLServerException.class)
    public String sqlExceptionHandler(SQLServerException e){
        return e.getMessage();
  }
}
