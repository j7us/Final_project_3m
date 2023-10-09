package ru.javarush.pozdnov.quest.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.pozdnov.quest.entity.User;
import ru.javarush.pozdnov.quest.services.Quest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserAndQuestServletTest {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;
    public RequestDispatcher rd;
    public UserAndQuestServlet userAndQuestServlet;

    @BeforeEach
    public void init(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        rd = Mockito.mock(RequestDispatcher.class);
        userAndQuestServlet = new UserAndQuestServlet();
    }

    @Test
    @ExtendWith(MockitoExtension.class)
    public void doGet() throws Exception{

        //Mock request doing
        Mockito.doReturn(session).when(request).getSession(true);
        Mockito.doReturn(rd).when(request).getRequestDispatcher("/questLogicServlet?questNumber=0");

        //Mock session doing
        Mockito.doReturn(null).when(session).getAttribute("count");

        userAndQuestServlet.doGet(request, response);

        Mockito.verify(request).getSession(true);
        Mockito.verify(session, times(1)).setAttribute(eq("user"), any(User.class));
        Mockito.verify(session, times(1)).setAttribute(eq("quest"), any(Quest.class));
        Mockito.verify(session, times(1)).setAttribute(eq("count"), anyInt());
    }
}
