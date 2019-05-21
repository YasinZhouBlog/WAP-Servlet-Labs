package cs472;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.*;
import com.google.gson.Gson; //for json (Gson-2.8.5.jar)

/**
 * @Description TODO
 * @ClassName ${NAME}
 * @Author Administrator
 * @Date 2019/5/19 18:20
 * @Version V1.0
 */
@WebServlet("/dictServlet")
public class dictServlet extends HttpServlet {
    // JDBC DRIVER_Name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/entries?serverTimezone=UTC";

    // username and password
    static final String USER = "root";
    static final String PASS = "qplkP!=eG7t?";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        response.getWriter().write("Hello servlet!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String text = request.getParameter("word");

        Connection conn = null;
        Statement stmt = null;
        try{
            // register JDBC DRIVER
            Class.forName(JDBC_DRIVER);

            // creat a Connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // run SQL search
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT wordtype, definition FROM entries WHERE word=\'" + text +"\'";
            ResultSet rs = stmt.executeQuery(sql);

            List result = new ArrayList();
            // runloop ResultData
            while(rs.next()){
                // get the data
                String wordtype = rs.getString("wordtype");
                String definition = rs.getString("definition");

                // outprint data
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("wordtype", wordtype);
                map.put("definition", definition);
                result.add(map);
            }
            Gson gson = new Gson();
            out.print(gson.toJson(result));
            out.flush();
            out.close();

            // close
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // do the JDBC error
            se.printStackTrace();
            out.println(se);
        } catch(Exception e) {
            // do the Class.forName error
            e.printStackTrace();
            out.println(e);
        }finally{
            // close all of them
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
