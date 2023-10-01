package ru.javarush.pozdnov.quest.Entity;

import org.junit.jupiter.api.Test;
import ru.javarush.pozdnov.quest.Entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    public User user = new User("Vasya");

    @Test
    public void getName(){
        assertEquals("Vasya", user.getName());
    }
}
