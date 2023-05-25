package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dfo.Email;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.UserService;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;

@WebServlet(name = "RestorePasswordServlet", urlPatterns = {"/restore-password-servlet"})
public class RestorePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String notFoundError = "Email no encontrado";
        String invalidError = "Email no válido";
        String dispatcherURLRestore = "jsp/login/restorePassword.jsp";

        try {
            Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);
            UserService userService = new UserService(new UserClient());
            User user = userService.getUser(session.getUserName());
            Email email = new Email(request.getParameter("email"));

        } catch (NotFoundException | NullPointerException e) {
            request.setAttribute("error", notFoundError);
            request.getRequestDispatcher(dispatcherURLRestore).forward(request, response);
        }
    }
}
