package ru.javarush.pozdnov.quest.Repository;

import org.junit.jupiter.api.Test;
import ru.javarush.pozdnov.quest.Repository.QuestionRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionRepositoryTest {

    @Test
    public void getQuestionById(){
        try {
            QuestionRepository repository = new QuestionRepository();
            assertEquals("Начать учить Java?", repository.getQuestionById(1).getTextQuestion());
            assertEquals(1,repository.getQuestionById(1).getAnswerId()[0]);
        }catch (Exception e){e.getMessage();}
    }
}
