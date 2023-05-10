package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.servlet.dto.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final String URL_PROYECTO = "/ProyectoPrueba/";
    private final String URL_HOME = URL_PROYECTO + "comun/home.jsp";
    private final String URL_LOGIN = "/login/login.jsp";
    private final String URL_USERCONTROLLER = URL_PROYECTO+"/user/";
    private final String sessionAtributte = "session";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws
            ServletException,
            IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException,
            IOException {

        Session session = (Session) req.getSession().getAttribute(sessionAtributte);

        if (session != null) {
            resp.sendRedirect(URL_HOME);
        } else {
            //String usuarioConfigurado=getServletContext().getInitParameter("usuario");
            //String passwordConfigurado=getServletContext().getInitParameter("userpassword");
            String userNameReceived = req.getParameter("userName");
            String userPasswordReceived = req.getParameter("userPassword");
            resp.sendRedirect(URL_USERCONTROLLER + "userName");
            /*
            * añadir comprobacion de si el username existe en la base de datos
            * */
            if ((userNameReceived != null && userNameReceived.equals(""/*username base de datos*/))
                    && (userPasswordReceived != null && userPasswordReceived.equals(""/*userpassword base de datos*/))) {

                session = Session.builder().userName(userNameReceived).userPassword(userNameReceived).build();

                //Cambiar el intervalo de sesión y añadir tiempo de la sesion
                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute(sessionAtributte, session);

                resp.sendRedirect(URL_HOME);
            } else {
                req.setAttribute("error", "Error al insertar usuario o contraseña");
                req.getRequestDispatcher(URL_LOGIN).forward(req, resp);
            }
        }
    }
}
