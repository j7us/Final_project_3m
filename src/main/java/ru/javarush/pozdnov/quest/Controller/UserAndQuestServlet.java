package ru.javarush.pozdnov.quest.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.pozdnov.quest.Entity.User;
import ru.javarush.pozdnov.quest.Repository.AnswerRepository;
import ru.javarush.pozdnov.quest.Services.Quest;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UserAndQuestServlet", value = "/userAndQuestServlet")
public class UserAndQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Создание или получение сессии
        HttpSession session = request.getSession(true);

        //Создание пользователя и класса, управляющего квестом
        User user = new User(request.getParameter("name"));
        Quest quest = new Quest();

        //Добавление в сессию юзера и класс квеста
        session.setAttribute("user", user);
        session.setAttribute("quest", quest);

        //Расчет кол-ва попыток
        session.setAttribute("count", session.getAttribute("count") == null?
                1 : (Integer)session.getAttribute("count") + 1);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/questLogicServlet?questNumber=0");
        requestDispatcher.forward(request,response);
    }

}