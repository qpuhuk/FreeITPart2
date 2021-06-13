package HomeWorks.HW3Authorization;

import HomeWorks.HW3Authorization.dao.UserCheckDao;
import HomeWorks.HW3Authorization.dao.UserCheckImpl;
import HomeWorks.HW3Authorization.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        UserCheckDao userCheckDao = new UserCheckImpl();
        boolean result = userCheckDao.addUser(new UserService().createUser(login, password, name));
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher;
        if (result) {
            dispatcher = context.getRequestDispatcher("/pageHello.jsp");
        } else {
            dispatcher = context.getRequestDispatcher("/registrationFix.html");
        }
        dispatcher.forward(req, resp);
    }
}
