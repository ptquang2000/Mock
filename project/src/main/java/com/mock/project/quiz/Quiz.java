package com.mock.project.quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mock.project.course.Course;

@Entity
@Table (name="quiz")
public class Quiz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column(name = "id_course")
    private Long idCourse;
    @Column(name = "question", columnDefinition = "ntext")
    private String question;
    @Column(name = "ans1", columnDefinition = "ntext")
    private String ans1;
    @Column(name = "ans2", columnDefinition = "ntext")
    private String ans2;
    @Column(name = "ans3", columnDefinition = "ntext")
    private String ans3;
    @Column(name = "ans4", columnDefinition = "ntext")
    private String ans4;
    @Column(name = "ans")
    private int ans;

    @ManyToOne
    @JoinColumn(name="id_course", referencedColumnName = "id", insertable = false, updatable = false)
    private Course course;

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Quiz(){

    }

    public Quiz(Long id){
        this.id = id;
    }
  
    public Quiz(Long idCourse,String question,String ans1,String ans2,String ans3,String ans4,int ans) {
        this.idCourse = idCourse;
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
    public Long getId() {
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
    public Long getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idCourse='" + getIdCourse() + "'" +
            ", question='" + getQuestion() + "'" +
            ", ans1='" + getAns1() + "'" +
            ", ans2='" + getAns2() + "'" +
            ", ans3='" + getAns3() + "'" +
            ", ans4='" + getAns4() + "'" +
            ", ans='" + getAns() + "'" +
            ", course='" + getCourse() + "'" +
            "}";
    }

}
