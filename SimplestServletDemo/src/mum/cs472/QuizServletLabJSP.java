package mum.cs472;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QuizServletLabJsp")
public class QuizServletLabJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int answer = Integer.valueOf(request.getParameter("answer"));
        HttpSession s = request.getSession();
        Quiz q = (Quiz) s.getAttribute("quiz");
        if (q.answerCompute(answer)) {
            if (q.isFinish()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "./QuizServletLabJSP/result.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(
                        "./QuizServletLabJSP/index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "./QuizServletLabJSP/result.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
        Quiz q = (Quiz) s.getAttribute("quiz");
        if (q == null) {
            q = new Quiz();
            s.setAttribute("quiz", q);
        }
        q.resetScore();
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "./QuizServletLabJSP/index.jsp");
        dispatcher.forward(request, response);
    }
}
