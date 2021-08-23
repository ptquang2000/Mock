package com.mock.project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
    List<Quiz> findByid_course(long id_course);

    Quiz findByid(long id);

    static Quiz update(Quiz quiz) {
        return null;
    }
}
