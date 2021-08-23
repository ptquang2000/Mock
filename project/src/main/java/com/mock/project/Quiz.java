package com.mock.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="quiz")
public class Quiz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private long id;
    @Column(name = "id_course")
    private long id_course;
    @Column(name = "question")
    private String question;
    @Column(name = "ans1")
    private String ans1;
    @Column(name = "ans2")
    private String ans2;
    @Column(name = "ans3")
    private String ans3;
    @Column(name = "ans4")
    private String ans4;
    @Column(name = "ans")
    private int ans;
    
    public Quiz(){

    }
  
    public Quiz(long id_course,String question,String ans1,String ans2,String ans3,String ans4,int ans) {
        this.id_course = id_course;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans = ans;
    }
    public int getAns() {
        return ans;
    }
    public String getAns1() {
        return ans1;
    }
    public String getAns2() {
        return ans2;
    }
    public String getAns3() {
        return ans3;
    }
    public String getAns4() {
        return ans4;
    }
    public long getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public void setAns(int ans) {
        this.ans = ans;
    }
    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }
    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }
    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }
    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public long getId_course() {
        return id_course;
    }
    public void setId_course(long id_course) {
        this.id_course = id_course;
    }
}
