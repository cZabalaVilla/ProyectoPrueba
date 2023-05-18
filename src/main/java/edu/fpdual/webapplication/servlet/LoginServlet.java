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
        String emptyError = "El campo usuario está vacío";

        try {
            String userNameReceived = request.getParameter("userName");
            String userPasswordReceived = request.getParameter("userPassword");

            User user = new UserClient().get(userNameReceived);
            Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);

            if (session != null) {
                response.sendRedirect(GlobalInfo.URL_JSP_HOME);
                return;
            }

            if (userNameReceived == null || userNameReceived.isEmpty()) {
                request.setAttribute("error", emptyError);
                request.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(request, response);
                return;
            }

            if (!user.getUserPassword().equals(userPasswordReceived)) {
                request.setAttribute("error", incorrectError);
                request.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(request, response);
                return;
            }

            session = Session.builder()
                    .userName(userNameReceived)
                    .userPassword(userPasswordReceived)
                    .admin(user.isAdmn())
                    .build();
            request.getSession().setMaxInactiveInterval(10);
            request.getSession().setAttribute(GlobalInfo.session, session);
            response.sendRedirect(GlobalInfo.URL_JSP_HOME);
        } catch (NotFoundException e) {
            request.setAttribute("error", incorrectError);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(request, response);
        }
    }

}
