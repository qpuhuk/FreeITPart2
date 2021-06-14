package HomeWorks.HW3Authorization;

import HomeWorks.HW3Authorization.dao.UserDao;
import HomeWorks.HW3Authorization.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/check")
public class Authorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        if (login == null || login.equals("")) {
            getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
        } else {
            UserDao userDao = new UserDaoImpl();
            if (userDao.checkLogin(login)) {
                String password = request.getParameter("pass");
                if (userDao.checkPass(password)) {
                    HttpSession session = request.getSession();
                    String nameUser = userDao.getNameOfUser(login);
                    session.setAttribute("login", login);
                    session.setAttribute("name", nameUser);
                    getServletContext().getRequestDispatcher("/pageHello.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/incorrectPass.html").forward(request, response);
                }
            } else {
                getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
            }
        }
    }
}
