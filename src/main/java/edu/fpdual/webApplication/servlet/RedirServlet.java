package edu.fpdual.webApplication.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirServlet")
public class RedirServlet extends HttpServlet {

    private static final String LOGIN_URL = "/ProyectoPrueba/login/login.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el valor del botón de tipo submit
        String submitValue = request.getParameter("submitBtn");

        // Verificar si el botón de tipo submit tiene el valor "Ir a"
        if ("Ir a".equals(submitValue)) {
            // Redirigir a la página "otraPagina.jsp"
            response.sendRedirect(LOGIN_URL);
        }
    }
}
