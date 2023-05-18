package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.service.client.UserClient;
import edu.fpdual.webapplication.service.client.dto.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListsServlet", urlPatterns = {"/lists-servlet"})
public class ListsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> users = new UserClient().getAll();
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<table style=\"border: 1px solid black;" +
                "  border-collapse: collapse;\">");
        for (User user : users) {
            writer.println("<tr><td>");
            writer.println(user.toString());
            writer.println("</td></tr>");
        }
        writer.println("</table>");
        writer.println("</br></br>");
        writer.println("<button onclick=\"location.href='\\index.jsp'\">Volver al inicio</button>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
