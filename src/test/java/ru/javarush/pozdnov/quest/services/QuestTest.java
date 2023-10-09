package ru.javarush.pozdnov.quest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class QuestTest {

    public Quest quest;

    @BeforeEach
    public void init(){
        quest = new Quest();
    }

    @Test
    public void getNextQuestion(){
        String testQuestion = quest.getNextQuestion(0);
        assertEquals("Начать учить Java?", testQuestion);
    }

    @Test
    public void getNextQuestionId(){
        int testId = quest.getNextQuestionId(0);
        assertEquals(1, testId);
    }

    @Test
    public void getAnswers(){
        quest.getNextQuestion(0);
        List<String> answersTest = quest.getAnswers();
        List<String> list = new ArrayList<>(List.of("Да", "Нет"));
        assertIterableEquals(list, answersTest);
    }
}
