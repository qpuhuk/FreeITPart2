package HomeWorks.HW3Authorization;

import HomeWorks.HW3Authorization.dao.UserCheckDao;
import HomeWorks.HW3Authorization.dao.UserCheckImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/check")
public class Authorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("username");
        ServletContext context = getServletContext();
        if (login == null || login.equals("")) {
            RequestDispatcher dispatcher = context.getRequestDispatcher("/registration.html");
            dispatcher.forward(request, response);
        } else {
            UserCheckDao userCheckDao = new UserCheckImpl();
            if (userCheckDao.checkLogin(login)) {
                String password = request.getParameter("pass");
                RequestDispatcher dispatcher;
                if (userCheckDao.checkPass(password)) {
                    dispatcher = context.getRequestDispatcher("/pageHello.jsp");
                } else {
                    dispatcher = context.getRequestDispatcher("/indexPass.html");
                }
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = context.getRequestDispatcher("/registration.html");
                dispatcher.forward(request, response);
            }
        }
    }
}
