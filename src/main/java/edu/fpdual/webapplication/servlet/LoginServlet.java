package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login-servlet" })
public class LoginServlet extends TemplateServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            IOException, ServletException {

        Session session = (Session) req.getSession().getAttribute(super.session);

        if (session != null) {
            resp.sendRedirect(URL_HOME);
        } else {
            //String usuarioConfigurado=getServletContext().getInitParameter("usuario");
            //String passwordConfigurado=getServletContext().getInitParameter("userpassword");
            String userNameReceived = req.getParameter("userName");
            String userPasswordReceived = req.getParameter("userPassword");
            //Mandara una redireccion al webservice para obtener el usuario
            resp.sendRedirect("userName");
            /*
            * añadir comprobacion de si el username existe en la base de datos
            * */
            if ((userNameReceived != null && userNameReceived.equals(""/*username base de datos*/))
                    && (userPasswordReceived != null && userPasswordReceived.equals(""/*userpassword base de datos*/))) {

                session = Session.builder().userName(userNameReceived).userPassword(userNameReceived).build();

                //Cambiar el intervalo de sesión y añadir tiempo de la sesion
                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute(super.session, session);
                resp.sendRedirect(URL_HOME);
            } else {
                req.setAttribute("error", "Error al insertar usuario o contraseña");
                req.getRequestDispatcher(URL_LOGIN).forward(req, resp);
            }
        }
    }
}
