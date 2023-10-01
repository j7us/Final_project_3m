package ru.javarush.pozdnov.quest.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.javarush.pozdnov.quest.Services.Quest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

public class QuestLogicServletTest {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;
    public RequestDispatcher requestDispatcher;
    public QuestLogicServlet questLogicServlet;
    public Quest quest;


    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        quest = Mockito.mock(Quest.class);
        questLogicServlet = new QuestLogicServlet();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Проигрыш", "Выигрыш", "AAAA"})
    public void doGetWinTest(String question) throws Exception{

        //Mock request doing
        Mockito.doReturn(session).when(request).getSession();
        Mockito.doReturn("0").when(request).getParameter("questNumber");
        Mockito.doReturn(requestDispatcher).when(request).getRequestDispatcher(any(String.class));

        //Mock session doing
        Mockito.doReturn(quest).when(session).getAttribute("quest");

        //Mock quest doing 1
        Mockito.doReturn(question).when(quest).getNextQuestion(0);
        Mockito.doReturn(1).when(quest).getNextQuestionId(0);
        Mockito.doReturn(new ArrayList<>(List.of("AAA","OOO"))).when(quest).getAnswers();

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        questLogicServlet.doGet(request,response);

        switch (question){
            case "Проигрыш":
                Mockito.verify(request).getRequestDispatcher(argumentCaptor.capture());
                assertEquals("/endGame.jsp?gameRes=2", argumentCaptor.getValue());
                break;
            case "Выигрыш":
                Mockito.verify(request).getRequestDispatcher(argumentCaptor.capture());
                assertEquals("/endGame.jsp?gameRes=1", argumentCaptor.getValue());
                break;
            default:
                Mockito.verify(request).getRequestDispatcher(argumentCaptor.capture());
                assertEquals("/game.jsp?question=AAAA&img=1", argumentCaptor.getValue());
        }

    }


    @Test
    public void doGetException() throws Exception{

        //Request return session Mock
        Mockito.doReturn(session).when(request).getSession();

        //Session return Object
        Mockito.doReturn(new Object()).when(session).getAttribute("quest");

        assertThrows(RuntimeException.class,() ->questLogicServlet.doGet(request,response));
    }


}
