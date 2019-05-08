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
import java.util.List;

/**
 * @Description TODO
 * @ClassName ${NAME}
 * @Author Administrator
 * @Date 2019/5/7 22:00
 * @Version V1.0
 */
@WebServlet("/BeerServlet")
public class BeerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");   // 处理get请求乱码问题
        response.getWriter().write("你好 servlet!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("color");
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);
        HttpSession s = request.getSession();
        s.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./result.jsp");
        dispatcher.forward(request, response);
    }
}
