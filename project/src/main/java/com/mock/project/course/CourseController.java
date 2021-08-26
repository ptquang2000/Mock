package com.mock.project.course;

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

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.PUT)
    public Course updatCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.DELETE)
    public void deleteCourse(@RequestBody Course course) {
       courseService.deleteCourse(course);
    }
  
    @ExceptionHandler(SQLServerException.class)
    public String sqlExceptionHandler(SQLServerException e){
        return e.getMessage();
  }
}
