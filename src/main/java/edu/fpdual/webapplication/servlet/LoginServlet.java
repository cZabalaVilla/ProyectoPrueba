package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.service.client.UserClient;
import edu.fpdual.webapplication.service.client.dto.User;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login-servlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String incorrectError = "Usuario o contraseña incorrectos";
        String emptyError = "Rellene todos los campos";

        try {
            String userNameReceived = request.getParameter("userName").toLowerCase();
            String userPasswordReceived = request.getParameter("userPassword");
            User user = new UserClient().get(userNameReceived);
            Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);

            if (session != null) {
                response.sendRedirect(GlobalInfo.URL_JSP_HOME);
            } else if (userNameReceived == null || userNameReceived.isEmpty() || userPasswordReceived == null
                    || userPasswordReceived.isEmpty() || user.getUserName() == null || user.getUserPassword() == null) {
                request.setAttribute("error", emptyError);
                //Cuidado con poner un '/' al principio, toma la ruta como relativa.
                request.getRequestDispatcher("jsp/login/login.jsp").forward(request, response);
            } else if (!user.getUserPassword().equals(userPasswordReceived)) {
                request.setAttribute("error", incorrectError);
                //Cuidado con poner un '/' al principio, toma la ruta como relativa.
                request.getRequestDispatcher("jsp/login/login.jsp").forward(request, response);
            } else {
                session = Session.builder()
                        .userName(userNameReceived)
                        .userPassword(userPasswordReceived)
                        .admin(user.isAdmn())
                        .build();
                request.getSession().setMaxInactiveInterval(0);
                request.getSession().setAttribute(GlobalInfo.session, session);
                response.sendRedirect(GlobalInfo.URL_JSP_HOME);
            }
        } catch (NotFoundException e) {
            request.setAttribute("error", incorrectError);
            request.getRequestDispatcher("jsp/login/login.jsp").forward(request, response);
        }
    }

}
