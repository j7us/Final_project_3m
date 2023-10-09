package ru.javarush.pozdnov.quest.entity;

public class Answer {
    private int id;
    private String textAnswer;
    private  int questionId;

    public Answer(){}

    public Answer(int id, String textQuestion, int questionId){
        this.id = id;
        this.textAnswer = textQuestion;
        this.questionId = questionId;
    }

    public int getId(){
        return id;
    }

    public String getTextAnswer(){
        return textAnswer;
    }

    public int getQuestionId(){
        return questionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
