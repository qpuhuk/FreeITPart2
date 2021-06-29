package HomeWorks.HW3Authorization.servlets;

import HomeWorks.HW3Authorization.dao.entity.User;
import HomeWorks.HW3Authorization.service.UserService;
import HomeWorks.HW3Authorization.service.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("username");
        User user = null;
        if (login == null || login.equals("")) {
            getServletContext().getRequestDispatcher("/registration.html").forward(request, response);
        } else {
            user = userService.getByName(login);
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
