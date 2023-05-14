package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.service.client.NotificationClient;
import edu.fpdual.webapplication.service.client.dto.Notification;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NotificationServlet", urlPatterns = { "/notification-servlet" })
public class NotificationServlet extends TemplateServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(new NotificationClient().ping());
        writer.println("</br>");
        writer.println(new NotificationClient().getNotification("8"));
        writer.println("</br>");
        writer.println(new NotificationClient().getNotification("82", ":D"));
        writer.println("</br>");
        writer.println(new NotificationClient().putNotification("82", ":D"));
        writer.println("</br>");
        writer.println(new NotificationClient().postNotification(
                Notification.builder().id(9).body("Prueba de consumo de servicio").title("Prueba").build()));
        writer.println("</br>");
        writer.println("<button onclick=\"location.href='\\index.jsp'\">Volver al inicio</button>");
        writer.println("</body>");
        writer.println("</html>");
    }
}