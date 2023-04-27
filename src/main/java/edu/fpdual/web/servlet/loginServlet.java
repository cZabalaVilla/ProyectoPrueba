package edu.fpdual.web.servlet;

import edu.fpdual.persistence.dao.Database;
import edu.fpdual.persistence.dao.Usuario;

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
        Usuario user = (Usuario) request.getSession().getAttribute("usuarioSesion");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("userpassword");
        Database database = new Database();
        if (user != null) {
            response.sendRedirect(URL_PROYECTO + "/comun/home.jsp");
        } else {
/* Este fragmento de código se encarga de iniciar con un usuario y contraseña ya fijos en el web.xml
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
                    request.setAttribute("errorMsg", "Usuario o contraseña incorrectos");
                    request.getRequestDispatcher("/login/login.jsp").forward(request, response);
                }


            } catch (NoSuchAlgorithmException e) {
                // Manejar la excepción según tu necesidad
            }

*/
/* Este fragmento de código se encarga de crear un nuevo usuario en la base de datos.
            try (Connection connection = Database.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (usuario, password) VALUES (?, ?)");
                statement.setString(1, usuario);
                statement.setString(2, password);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // Aquí debes manejar el error de alguna manera
            }

            response.sendRedirect("/ProyectoPrueba/index.jsp");

 */

            if (database.validateUser(usuario, password)) {
                // Si el usuario es válido, redirige a la página de bienvenida
                try {
                    user = Usuario.builder().usuario(usuario).userpassword(hashPassword(password)).build();
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("/ProyectoPrueba/comun/home.jsp");
            } else {
                // Si el usuario no es válido, muestra un mensaje de error en la página de login
                request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
