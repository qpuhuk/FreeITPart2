package HomeWorks.hw2Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servPost")
public class ServletThree extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter printWriter = response.getWriter()) {
            String name = request.getParameter("username");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String country = request.getParameter("country");
            String[] courses = request.getParameterValues("courses");

            printWriter.println("<p>Name: " + name + "</p>");
            printWriter.println("<p>Age: " + age + "</p>");
            printWriter.println("<p>Gender: " + gender + "</p>");
            printWriter.println("<p>Country: " + country + "</p>");
            printWriter.println("<h4>Courses</h4>");
            for (String course : courses) {
                printWriter.println("<li>" + course + "</li>");
            }
        }
    }
}
