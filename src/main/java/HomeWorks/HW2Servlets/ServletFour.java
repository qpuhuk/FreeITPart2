package HomeWorks.HW2Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/four")
public class ServletFour extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            String name = request.getParameter("name");
            if (name == null) {
                String path = request.getContextPath();
                response.sendRedirect(path);
            } else {
                String login = request.getParameter("login");
                String pass = request.getParameter("password");
                List<String> params = Arrays.asList(name, login, pass);
                printWriter.println("The data of the user");
                params.forEach(p -> printWriter.println("<ul><li>" + p + "</li></ul>"));
                String pathJsp = "/index.jsp";
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher(pathJsp);
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
