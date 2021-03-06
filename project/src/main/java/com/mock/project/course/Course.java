package com.mock.project.course;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mock.project.form.CourseForm;

@Entity
@Table(name = "course")
public class Course implements Serializable{
    @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Course(){}

    public Course(CourseForm courseForm){
        this.id = Long.parseLong(courseForm.getId());
        this.name = courseForm.getName();
    }

    public Course(String name) {
        this.name = name;
    }
    
    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nCourse{" +
			"\n\tid='" + getId() + "'" +
			",\n\tname='" + getName() + "'" +
			"\n}";
    }
}
