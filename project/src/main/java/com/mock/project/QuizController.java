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
        return  (quiz != null) ? quiz : quizService.addquiz(
            new Quiz(quiz.getId_course(),quiz.getQuestion(),quiz.getAns1(),quiz.getAns2(),quiz.getAns3(),quiz.getAns4(),quiz.getAns()));
    }

    @RequestMapping(value="/quiz", method=RequestMethod.GET)
    public void printAllQuiz(){
        ArrayList<Quiz> list = new ArrayList<>(quizService.getAllquiz());
        list.forEach(System.out::println);
    }
}
