package com.mock.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
    List<Quiz> findByIdCourse(Long id_course);
}
