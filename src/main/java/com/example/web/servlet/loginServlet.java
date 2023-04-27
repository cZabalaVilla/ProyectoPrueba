package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Si el usuario y contraseña son correctos, se crea una sesión para el usuario
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Se redirige a una página de bienvenida
            response.sendRedirect("welcome.jsp");
        } else {
            // Si las credenciales son incorrectas, se redirige a una página de error de login
            response.sendRedirect("login-error.jsp");
        }
    }
}
