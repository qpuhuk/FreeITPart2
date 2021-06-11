package HomeWorks.HW2Servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class ServletOne extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            printWriter.println("<h1>hello!</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
