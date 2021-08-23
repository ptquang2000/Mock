package com.mock.project;

import java.io.Serializable;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class QuizController implements Serializable{

    @Autowired
    private QuizService quizService;
    @ExceptionHandler(SQLServerException.class)
    public String sqlExcpetionHandler(SQLServerException e){
        return e.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String httpMessageNotReadableExcpetionHandler(HttpMessageNotReadableException e){
        return e.getMessage();
    }

    @RequestMapping(value="/quiz", method=RequestMethod.POST)
    public Quiz addQuiz(@RequestBody Quiz quiz){
        Quiz _quiz = quizService.addQuiz(quiz);
        return  (quiz != null) ? quiz : quizService.addQuiz(
            new Quiz(_quiz.getId_course(),_quiz.getQuestion(),_quiz.getAns1(),_quiz.getAns2(),_quiz.getAns3(),_quiz.getAns4(),_quiz.getAns()));
    }

    @RequestMapping(value="/quiz", method=RequestMethod.GET)
    public void printAllQuiz(){
        ArrayList<Quiz> list = new ArrayList<>(quizService.getAllQuiz());
        list.forEach(System.out::println);
    }
}
