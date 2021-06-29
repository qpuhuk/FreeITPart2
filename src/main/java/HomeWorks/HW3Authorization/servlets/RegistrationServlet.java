package HomeWorks.HW3Authorization.servlets;

import HomeWorks.HW3Authorization.service.UserService;
import HomeWorks.HW3Authorization.service.UserServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl();
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.setAttribute("username", req.getParameter("username"));
        session.setAttribute("pass", req.getParameter("password"));
        session.setAttribute("name", req.getParameter("name"));
        boolean result = userService.create((String) session.getAttribute("username"),
                (String) session.getAttribute("pass"), (String) session.getAttribute("name"));
        if (result) {
            getServletContext().getRequestDispatcher("/pageHello.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/registrationFix.html").forward(req, resp);
        }
    }
}
