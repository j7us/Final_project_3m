package ru.javarush.pozdnov.quest.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerRepositoryTest {
    @Test
    public void getAnswerById(){
        try {
            AnswerRepository rep = new AnswerRepository();
            assertEquals("Да",rep.getAnswerById(1).getTextAnswer());
            assertEquals("Нет",rep.getAnswerById(2).getTextAnswer());
        }catch (Exception e){e.getMessage();}
    }
}
