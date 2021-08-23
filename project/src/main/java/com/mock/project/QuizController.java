package com.mock.project;

import java.io.Serializable;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
        return quizService.addQuiz(quiz);
    }

    @RequestMapping(value="/quiz", method=RequestMethod.PUT)
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return quizService.updateQuiz(quiz);
    }

    @RequestMapping(value="/quiz", method=RequestMethod.DELETE)
    public void deleteQuiz(@RequestBody Quiz quiz){
        quizService.deleteQuiz(quiz);
    }

    @RequestMapping(value="/courses/{id_course}", method=RequestMethod.GET)
    public ArrayList<Quiz> getAllQuizzesByCourseId(@PathVariable Long id_course){
        ArrayList<Quiz> list = new ArrayList<>(quizService.getAllQuiz(id_course));
        return list;
    }
}
