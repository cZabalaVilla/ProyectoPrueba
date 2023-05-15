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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        User user = null;
        String errorInexistente = "Usuario o contraseña incorrectos";

        try {
            user = new UserClient().findByUserName(req.getParameter("userName"));
            Session session = (Session) req.getSession().getAttribute(GlobalInfo.session);

            String userNameGot = user.getUserName();
            String userPasswordGot = user.getUserPassword();
            boolean adminGot = user.isAdmn();
            String userNameReceived = req.getParameter("userName");
            String userPasswordReceived = req.getParameter("userPassword");
            String errorIncompleto = "El campo usuario está vacío";
            String errorIncorrecto = "Usuario o contraseña incorrectos";

            if (session != null) {
                resp.sendRedirect(GlobalInfo.URL_JSP_HOME);
            } else if (userNameReceived == null) {
                req.setAttribute("error", errorIncompleto);
                req.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(req, resp);
            } else if (!userNameReceived.equals(userNameGot) || !userPasswordReceived.equals(userPasswordGot)) {
                req.setAttribute("error", errorIncorrecto);
                req.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(req, resp);
            } else {
                session = Session.builder().userName(userNameReceived).userPassword(userPasswordReceived).admin(adminGot).build();
                //Cambiar el intervalo de sesión y añadir tiempo de la sesion
                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute(GlobalInfo.session, session);
                resp.sendRedirect(GlobalInfo.URL_JSP_HOME);
            }
        } catch (NotFoundException e) {
            req.setAttribute("error", errorInexistente);
            req.getRequestDispatcher(GlobalInfo.URL_JSP_LOGIN).forward(req, resp);
        }
    }
}
