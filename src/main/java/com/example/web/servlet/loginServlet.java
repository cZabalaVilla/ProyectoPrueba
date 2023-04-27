package com.example.web.servlet;

import com.example.persistence.manager.dao.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    private static final String URL_PROYECTO = "/ProyectoPrueba";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSesion");
        if (usuario != null) {
            response.sendRedirect(URL_PROYECTO + "/comun/home.jsp");
        } else {
            String usuarioConfigurado = getServletContext().getInitParameter("usuario");
            String passwordConfigurado = getServletContext().getInitParameter("userpassword");
            String usuarioIntroducido = request.getParameter("usuario");
            String passwordIntroducido = request.getParameter("userpassword");
            try {
                if ((usuarioIntroducido != null && usuarioIntroducido.equals(usuarioConfigurado))
                        && (passwordIntroducido != null && hashPassword(passwordIntroducido).equals(hashPassword(passwordConfigurado)))) {
                    usuario = Usuario.builder().usuario(usuarioIntroducido).userpassword(hashPassword(passwordIntroducido)).build();
                    request.getSession().setAttribute("usuarioSesion", usuario);
                    response.sendRedirect(URL_PROYECTO+"/comun/home.jsp");
                } else {
                    request.setAttribute("error", "Error al insertar usuario o contraseña");
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                }
            } catch (NoSuchAlgorithmException e) {
                // Manejar la excepción según tu necesidad
            }
        }
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashedBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
