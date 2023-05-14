package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.service.client.NotificationClient;
import edu.fpdual.webapplication.service.client.UserClient;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login-servlet"})
public class LoginServlet extends TemplateServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            IOException, ServletException {

        Session session = (Session) req.getSession().getAttribute(super.session);
        String userNameGot = new UserClient().findByUserName(req.getParameter("userName")).getUserName();
        String userPasswordGot = new UserClient().findByUserName(req.getParameter("userPassword")).getUserPassword();
        String userNameReceived = req.getParameter("userName");
        String userPasswordReceived = req.getParameter("userPassword");

        //Comprobacion si hay una sesion abierta
        if (session != null) {
            resp.sendRedirect(URL_HOME);
            //Comprobacion si el campo usuario está vacío
        } else if (userNameReceived == null) {
            req.setAttribute("error", "EL campo usuario está vacío");
            //Comprobacion si hay un usuario en la base de datos que exista
        } else if (userNameGot != null) {
            //Comprobacion si los campos coinciden
            if (userNameReceived.equals(userNameGot) && userPasswordReceived.equals(userPasswordGot)) {
                session = Session.builder().userName(userNameReceived).userPassword(userPasswordReceived).build();
                //Cambiar el intervalo de sesión y añadir tiempo de la sesion
                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute(super.session, session);
                resp.sendRedirect(URL_HOME);
            } else {
                req.setAttribute("error", "Usuario o contraseña incorrectos");
                req.getRequestDispatcher(URL_LOGIN).forward(req, resp);
            }
        } else {
            req.setAttribute("error", "No existe el usuario");
        }
    }
}
