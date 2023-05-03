package edu.fpdual.web.servlet;

import edu.fpdual.web.servlet.dto.Sesion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final String URL_PROYECTO = "/ProyectoPrueba/";

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

        Sesion sesion = (Sesion) req.getSession().getAttribute("usuarioSesion");

        if (sesion != null) {
            resp.sendRedirect(URL_PROYECTO + "comun/home.jsp");
        } else {

            String usuarioConfigurado=getServletContext().getInitParameter("usuario");
            String passwordConfigurado=getServletContext().getInitParameter("userpassword");

            String usuarioIntroducido = req.getParameter("usuario");
            String passwordIntroducido = req.getParameter("userpassword");

            if ((usuarioIntroducido != null && usuarioIntroducido.equals(usuarioConfigurado))
                    && (passwordIntroducido != null && passwordIntroducido.equals(passwordConfigurado))) {

                sesion = Sesion.builder().usuario(usuarioIntroducido).userpassword(passwordIntroducido).build();

                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute("usuarioSesion", sesion);

                resp.sendRedirect(URL_PROYECTO + "comun/home.jsp");
            } else {
                req.setAttribute("error", "Error al insertar usuario o contraseña");
                req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
            }
        }
    }
}
