package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.NotificationClient;
import edu.fpdual.webapplication.dto.Notification;
import edu.fpdual.webapplication.service.NotificationService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet(name = "NotificationServlet", urlPatterns = {"/notification-servlet"})
public class NotificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            NotificationService notificationService = new NotificationService(new NotificationClient());
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.println(notificationService.ping());
            writer.println("</br>");
            writer.println(notificationService.getNotification("8"));
            writer.println("</br>");
            writer.println(notificationService.getNotification("82", ":D"));
            writer.println("</br>");
            writer.println(notificationService.putNotification(Notification.builder().id(82).body(":D").title("Prueba").build()));
            writer.println("</br>");
            writer.println(notificationService.postNotification(
                    Notification.builder().id(9).body("Prueba de consumo de servicio").title("Prueba").build())
            );
            writer.println("</br>");
            writer.println("<button onclick=\"location.href='\\index.jsp'\">Volver al inicio</button>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception e) {
            //Mirar que excepcion produce
            e.printStackTrace();
        }
    }
}
