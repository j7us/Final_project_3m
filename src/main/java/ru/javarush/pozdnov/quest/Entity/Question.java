package ru.javarush.pozdnov.quest.Entity;

import java.util.List;

public class Question {

    private int id;
    private String textQuestion;
    private int[] answerId;

    public Question(){}

    public Question(int id, String textQuestion, int[] answerId){
        this.id = id;
        this.textQuestion = textQuestion;
        this.answerId = answerId;
    }

    public int getId(){
        return id;
    }

    public String getTextQuestion(){
        return textQuestion;
    }

    public int[] getAnswerId(){
        return answerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public void setAnswerId(int[] answerId) {
        this.answerId = answerId;
    }
}
