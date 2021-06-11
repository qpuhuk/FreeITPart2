package HomeWorks.HW2Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletFive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = "/index.jsp";
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher(path);
        dispatcher.include(request, response);
        try (PrintWriter writer = response.getWriter()) {
            HttpSession session = request.getSession();
            String idUser = session.getId();
            String name = request.getParameter("username");
            String login = request.getParameter("login");
            String pass = request.getParameter("password");
            writer.println("<p>id: " + idUser + "</p>");
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Login: " + login + "</p>");
            writer.println("<p>Password: " + pass + "</p>");
        }
    }
}
