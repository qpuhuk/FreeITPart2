package HomeWorks.HW3Authorization.servlets;

import HomeWorks.HW3Authorization.service.UserService;
import HomeWorks.HW3Authorization.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username", req.getParameter("username"));
        session.setAttribute("pass", req.getParameter("password"));
        session.setAttribute("name", req.getParameter("name"));
        boolean result = userService.addUserInDB((String) session.getAttribute("username"),
                (String) session.getAttribute("pass"), (String) session.getAttribute("name"));
        if (result) {
            getServletContext().getRequestDispatcher("/pageHello.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/registrationFix.html").forward(req, resp);
        }
    }
}
