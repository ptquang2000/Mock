package com.mock.project.quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
    List<Quiz> findByIdCourse(Long id_course);
    Quiz findByQuestionLike(String question);
    Quiz findByIdCourseAndQuestionLike(@Param("id_course") Long id, @Param("question") String question);
    Quiz findByIdNotAndIdCourseAndQuestionLike(@Param("id") Long id, @Param("id_course") Long idCourse, @Param("question") String question);
}
