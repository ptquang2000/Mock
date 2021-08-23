package com.mock.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    private QuizRepository QuizRepository;
  
    public Quiz addQuiz(Quiz quiz){
      return QuizRepository.save(Quiz);
    }
  
    public List<Quiz> getAllQuiz() {
      return QuizRepository.findAll();
    }
}
