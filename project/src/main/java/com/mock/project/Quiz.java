package com.mock.project;


@Entity
@Table (name="quiz")
public class Quiz {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private long id;
    @column
    private long id_course;
    @Column
    private String question;
    @Column
    private String ans1;
    @Column
    private String ans2;
    @Column
    private String ans3;
    @Column
    private String ans4;
    @Column
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
