package HomeWorks.HW3Authorization.servlets;

import HomeWorks.HW3Authorization.entity.User;
import HomeWorks.HW3Authorization.service.UserService;
import HomeWorks.HW3Authorization.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        User user = null;
        if (login == null || login.equals("")) {
            getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
        } else {
            try {
                user = userService.createUserFromBD(login);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (user == null) {
                getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
            } else {
                if (user.getPassword().equals(request.getParameter("pass"))) {
                    HttpSession session = request.getSession();
                    session.setAttribute("name", user.getName());
                    getServletContext().getRequestDispatcher("/pageHello.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/incorrectPass.html").forward(request, response);
                }
            }
        }
    }
}
