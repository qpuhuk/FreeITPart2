package HomeWorks.HW3Authorization;

import HomeWorks.HW3Authorization.dao.UserDao;
import HomeWorks.HW3Authorization.dao.UserDaoImpl;
import HomeWorks.HW3Authorization.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        session.setAttribute("login",login);
        session.setAttribute("name", name);
        UserDao userDao = new UserDaoImpl();
        boolean result = userDao.addUser(new UserService().createUser(login, password, name));
        if (result) {
            getServletContext().getRequestDispatcher("/pageHello.jsp").forward(req,resp);
        } else {
            getServletContext().getRequestDispatcher("/registrationFix.html").forward(req,resp);
        }
    }
}
