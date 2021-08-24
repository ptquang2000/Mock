package com.mock.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course addCourse(Course course) {
        if (courseRepository.findByName(course.getName()) != null)
            return null;
        return courseRepository.save(course);
    } 

    public Course updateCourse(Course course) {
        if (courseRepository.findById(course.getId()).isEmpty())
            return null;
        return courseRepository.save(course);
    }

    public void deleteCourse(Course course){
       courseRepository.delete(course);
    }
}
