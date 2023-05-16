package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.service.client.UserClient;
import edu.fpdual.webapplication.service.client.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static edu.fpdual.webapplication.GlobalInfo.USERCREATED;

@WebServlet(name = "NewUserServlet", urlPatterns = {"/new-user-servlet"})
public class NewUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String userNameReceived = request.getParameter("userName");
        String userPasswordReceived = request.getParameter("userPassword");
        String incompleteError = "El campo usuario está vacío";
        String errorExiste = "El nombre de usuario ya está registrado";

        if (userNameReceived == null || userPasswordReceived == null) {
            request.setAttribute("error", incompleteError);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_FORMNEWUSER).forward(request, response);
            return;
        }

        UserClient userClient = new UserClient();
        if (userClient.findByUserName(userNameReceived) != null) {
            request.setAttribute("error", errorExiste);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_FORMNEWUSER).forward(request, response);
            return;
        }

        if (userNameReceived.length() < 5) {
            User user = new User(userNameReceived, userPasswordReceived, false);
            int ok = userClient.create(user);
            if (ok == USERCREATED) {
                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();
                writer.println("<p>Usuario creado correctamente</p>");
                writer.flush();

                try {
                    Thread.sleep(5000);
                    response.sendRedirect(GlobalInfo.URL_JSP_LOGIN);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
