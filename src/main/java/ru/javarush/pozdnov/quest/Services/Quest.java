package ru.javarush.pozdnov.quest.Services;

import ru.javarush.pozdnov.quest.Entity.Answer;
import ru.javarush.pozdnov.quest.Entity.Question;
import ru.javarush.pozdnov.quest.Repository.AnswerRepository;
import ru.javarush.pozdnov.quest.Repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quest {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private List<Integer> nextQuestions;
    private Question question;

    public Quest(){
        questionRepository = new QuestionRepository();
        answerRepository = new AnswerRepository();
        nextQuestions = new ArrayList<>(List.of(1));
    }

    public String getNextQuestion(int numberInList){
       question = questionRepository.getQuestionById(nextQuestions.get(numberInList));
       return question.getTextQuestion();
    }

    public int getNextQuestionId(int numberInList){
        return questionRepository.getQuestionById(nextQuestions.get(numberInList)).getId();
    }

    public List<String> getAnswers(){
        List<String> answersText = new ArrayList<>();
        List<Integer> nextQuestions = new ArrayList<>();
        Arrays.stream(question.getAnswerId()).forEach(x ->{
            Answer answer = answerRepository.getAnswerById(x);
            nextQuestions.add(answer.getQuestionId());
            answersText.add(answer.getTextAnswer());
        });
        this.nextQuestions = nextQuestions;
        return answersText;
    }
}
