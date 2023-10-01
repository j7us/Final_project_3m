package ru.javarush.pozdnov.quest.Entity;

import org.junit.jupiter.api.Test;
import ru.javarush.pozdnov.quest.Entity.Question;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    public Question question = new Question(5, "Hai", new int[]{3,5});

    @Test
    public void getId(){
        assertEquals(5,question.getId());
    }

    @Test
    public void getTextQuestion(){
        assertEquals("Hai", question.getTextQuestion());
    }

    @Test
    public void getAnswerId(){
        assertArrayEquals(new int[]{3,5}, question.getAnswerId());
    }
}
