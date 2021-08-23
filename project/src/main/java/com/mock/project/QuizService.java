package com.mock.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
  
    public Quiz addQuiz(Quiz quiz){
      return quizRepository.save(quiz);
    }
  
    public List<Quiz> getAllQuiz(long id_course) {
      return quizRepository.findByIdCourse(id_course);
    }

    public Quiz getQuizById(long id){
      return quizRepository.findByid(id);
    }
}
