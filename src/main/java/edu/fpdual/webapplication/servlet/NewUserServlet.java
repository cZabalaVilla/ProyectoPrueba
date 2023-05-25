package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewUserServlet", urlPatterns = {"/new-user-servlet"})
public class NewUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String userNameReceived = request.getParameter("userName");
        String userPasswordReceived = request.getParameter("userPassword");
        String incompleteError = "El campo usuario está vacío";
        String espaceFoundError = "El nombre de usuaio no puede tener espacios";
        String errorExiste = "El nombre de usuario ya está registrado";
        UserService userService = new UserService(new UserClient());

        if (userNameReceived == null || userPasswordReceived == null) {
            request.setAttribute("error", incompleteError);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_FORMNEWUSER).forward(request, response);
        } else if (userService.getUser(userNameReceived) != null) {
            request.setAttribute("error", errorExiste);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_FORMNEWUSER).forward(request, response);
        } else if (userNameReceived.contains(" ")) {
            request.setAttribute("error", espaceFoundError);
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        } else if (userNameReceived.length() > 5 && userNameReceived.length() < 20) {
            User user = new User(userNameReceived, userPasswordReceived, false);
            if (userService.createUser(user)) {
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