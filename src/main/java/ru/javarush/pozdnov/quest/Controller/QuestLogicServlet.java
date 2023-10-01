package ru.javarush.pozdnov.quest.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.pozdnov.quest.Services.Quest;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestLogicServlet", value = "/questLogicServlet")
public class QuestLogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получение сессии
        HttpSession session = request.getSession();

        //Получение класса квеста из сессии
        Quest quest = extractQuest(session);

        //Получение номера вопроса
        int numberInList = Integer.parseInt(request.getParameter("questNumber"));

        //Получение текста вопроса, его id для img и вариантов ответа
        String question = quest.getNextQuestion(numberInList);
        int idImg = quest.getNextQuestionId(numberInList);
        List<String> answers = quest.getAnswers();


        switch (question){
            case "Проигрыш" :
                request.getRequestDispatcher("/endGame.jsp?gameRes=2").forward(request,response);
                break;
            case "Выигрыш" :
                request.getRequestDispatcher("/endGame.jsp?gameRes=1").forward(request,response);
                break;
            default :
                request.setAttribute("answers", answers);
                request.getRequestDispatcher("/game.jsp?question=" + question +"&img=" + idImg).forward(request,response);
                break;
        }

    }

    private Quest extractQuest(HttpSession session){
        Object object = session.getAttribute("quest");
        if (!(object instanceof Quest)){
            session.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Quest) object;
    }

}