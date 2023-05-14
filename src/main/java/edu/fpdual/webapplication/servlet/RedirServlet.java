package edu.fpdual.webapplication.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RedirServlet", urlPatterns = { "/redir-servlet" })
public class RedirServlet extends HttpServlet {

    private static final String LOGIN_URL = "/ProyectoPrueba/login/login.jsp";
    @Override
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
