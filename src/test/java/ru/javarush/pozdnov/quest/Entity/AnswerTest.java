package ru.javarush.pozdnov.quest.Entity;

import org.junit.jupiter.api.Test;
import ru.javarush.pozdnov.quest.Entity.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {
    public Answer answer = new Answer(1,"Da",3);

    @Test
    public void getId(){
        assertEquals(1, answer.getId());
    }

    @Test
    public void getTextAnswer(){
        assertEquals("Da", answer.getTextAnswer());
    }

    @Test
    public void getQuestionId(){
        assertEquals(3, answer.getQuestionId());
    }
}
