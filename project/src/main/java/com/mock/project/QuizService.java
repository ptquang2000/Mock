package com.mock.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private CourseRepository courseRepository;
  
    public Quiz addQuiz(Quiz quiz){
      if (courseRepository.findById(quiz.getIdCourse()).isEmpty())
        return null;
      if (quizRepository.findByIdCourseAndQuestionLike(quiz.getIdCourse(), quiz.getQuestion()) != null)
        return null;
      if (quiz.getAns() > 4 || quiz.getAns() < 1)
        return null;
      return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Quiz quiz){
      if (quizRepository.findById(quiz.getId()).isEmpty())
        return null;
      if (courseRepository.findById(quiz.getIdCourse()).isEmpty())
        return null;
      if (quiz.getAns() > 4 || quiz.getAns() < 1)
        return null;
      if (quizRepository.findByIdNotAndIdCourseAndQuestionLike(quiz.getId() ,quiz.getIdCourse(), quiz.getQuestion()) != null)
        return null;
      return quizRepository.save(quiz);
    }

    public void deleteQuiz(Quiz quiz){
      quizRepository.delete(quiz);
    }
  
    public List<Quiz> getAllQuiz(long id_course) {
      return quizRepository.findByIdCourse(id_course);
    }
}
