package ru.javarush.pozdnov.quest.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.pozdnov.quest.Entity.Answer;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class AnswerRepository {
    private List<Answer> answers;

    public AnswerRepository(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream resourceAsStream = AnswerRepository.class.getClassLoader().getResourceAsStream("json/answer.json");
            answers = Arrays.asList(mapper.readValue(returnJson(resourceAsStream), Answer[].class));
        }
        catch (Exception e){
            throw new RuntimeException("drugoe");
        }
    }


    public Answer getAnswerById(int id){
        return answers.get(id-1);
    }

    public String returnJson(InputStream intStream) throws IOException{
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(intStream))){
            while (reader.ready()){
                builder.append(reader.readLine());
            }
        }
        return builder.toString();
    }
}
