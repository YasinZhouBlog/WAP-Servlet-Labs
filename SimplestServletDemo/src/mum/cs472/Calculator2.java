package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator2
 */
@WebServlet("/Calculator2")
public class Calculator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator2() {
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
		out.print("<input type='text' name='sum1'/> + "
				+ "<input type='text' name='sum2'/> = "
				+ "<input type='text'/> <br>");
		out.print("<input type='text' name='num1'/> * "
				+ "<input type='text' name='num2'/> = "
				+ "<input type='text'/><br><br>");
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
		out.print("<form method='post'>");
		String sum1 = request.getParameter("sum1");
		String sum2 = request.getParameter("sum2");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int sum = Integer.parseInt(sum1) + Integer.parseInt(sum2);
		int num = Integer.parseInt(num1) * Integer.parseInt(num2);
		out.print("<input type='text' name='sum1' value='"+sum1+"'/> + "
				+ "<input type='text' name='sum2' value='"+sum2+"'/> = "
				+ "<input type='text' value='"+sum+"'/> <br>");
		out.print("<input type='text' name='num1' value='"+num1+"'/> * "
				+ "<input type='text' name='num2' value='"+num2+"'/> = "
				+ "<input type='text' value='"+num+"'/><br><br>");
		out.print("<input type='submit' value='Submit'/>");
		out.print("</form>");
		out.print("</body></html>");
	}

}
