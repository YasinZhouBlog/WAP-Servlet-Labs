package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator1
 */
@WebServlet("/Calculator1")
public class Calculator1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Test</title></head><body>");
		out.print("<form method='post'>");
		out.print("<input type='text' name='sum1'/> + " + "<input type='text' name='sum2'/> <br>");
		out.print("<input type='text' name='num1'/> * <input type='text' name='num2'/> <br>");
		out.print("<input type='submit' value='Submit'/>");
		out.print("</form>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Test</title></head><body>");
		String sum1 = request.getParameter("sum1");
		String sum2 = request.getParameter("sum2");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		if (sum1.length() > 0) {
			out.print("<p>" + sum1 + " + " + sum2 + " = " + 
		(Integer.parseInt(sum1) + Integer.parseInt(sum2)) + "</p>");
		}
		if (num1.length() > 0) {
			out.print("<p>" + num1 + " * " + num2 + " = " + 
		(Integer.parseInt(num1) * Integer.parseInt(num2)) + "</p>");
		}
		
		out.print("</body></html>");
	}

}
