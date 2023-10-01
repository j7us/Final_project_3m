package ru.javarush.pozdnov.quest.Repository;

import ru.javarush.pozdnov.quest.Entity.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
public class QuestionRepository {
    private List<Question> questions;


    public QuestionRepository(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream resourceAsStream = AnswerRepository.class.getClassLoader().getResourceAsStream("json/question.json");
            questions = Arrays.asList(mapper.readValue(returnJson(resourceAsStream), Question[].class));
        }catch (Exception e){e.getMessage();}
    }

    public Question getQuestionById(int id){
        return questions.get(id-1);
    }

    public String returnJson(InputStream intStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(intStream))){
            while (reader.ready()){
                builder.append(reader.readLine());
            }
        }
        return builder.toString();
    }
}
