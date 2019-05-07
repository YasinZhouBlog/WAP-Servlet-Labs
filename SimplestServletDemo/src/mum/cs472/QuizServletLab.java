package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuizServletLab
 */
@WebServlet("/QuizServletLab")
public class QuizServletLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String[] questions = {
			"3, 1, 4, 1, 5",
			"1, 1, 2, 3, 5",
			"1, 4, 9, 16, 25",
			"2, 3, 5, 7, 11",
			"1, 2, 4, 8, 16"
	};
	
	private static int[] answers = {9, 8, 36, 13, 32};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServletLab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		s.invalidate();
		this.showPage(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int answer = Integer.valueOf(request.getParameter("answer"));
		System.out.println(answer);
		HttpSession s = request.getSession();
		Object obj = s.getAttribute("scroe");
		int scroe = obj != null ? Integer.valueOf(obj.toString()) : 0;
		if (answer == answers[scroe]) {
			scroe += 1;
			s.setAttribute("scroe", scroe);
			if (scroe == answers.length) {
				this.showResultPage(request, response);
			} else {
				this.showPage(request, response);
			}
		} else {
			this.showResultPage(request, response);
		}
	}

	private void showPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();
		Object obj = s.getAttribute("scroe");
		int scroe = obj != null ? Integer.valueOf(obj.toString()) : 0;
		PrintWriter out = response.getWriter();
		out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("	<form method='post'>");
        out.print("<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: " + scroe + "</p>");
        out.print("<p>Guess the next number in the sequence! </p>");
        out.println("<p>" + questions[scroe] + "</p>");
        out.print("<p>Your answer: <input type='text' name='answer'/></p> ");
        out.print("<input type='submit'/></p> ");
        out.print("</form>");
        out.print("</body></html>");
	}
	
	private void showResultPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession s = request.getSession();
		Object obj = s.getAttribute("scroe");
		int scroe = obj != null ? Integer.valueOf(obj.toString()) : 0;
		PrintWriter out = response.getWriter();
		out.print("<html>");
        out.print("<head>");
        out.print("	<title>NumberQuiz</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: " + scroe + "</p>");
        out.print("<p>You have completed the Number Quiz, with a score of " + scroe + " out of 5</p>");
        out.print("</body></html>");
	}
}
