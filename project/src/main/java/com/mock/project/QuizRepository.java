package com.mock.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class QuizRepository extends JpaRepository<Quiz, Long>{
    List<Quiz> findByid_course(long id_course);
}
