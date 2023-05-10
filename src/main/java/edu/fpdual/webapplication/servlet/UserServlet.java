package edu.fpdual.webapplication.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/usuarioServlet")
public class UserServlet extends HttpServlet {
/*
    private UsuarioService service;
    private final String URL_PROYECTO = "/ProyectoPrueba/";

    @Override
    public void init()
            throws
            ServletException {
        service = new UsuarioService(new MySQLConnector(), new UsuarioManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws
            ServletException,
            IOException {

        try {
            if (req.getParameter("usuario") != null && !req.getParameter("usuario").trim().isEmpty()) {
                String usuario = req.getParameter("usuario");
                req.getSession().setAttribute("usuario", service.findUserByUsuario(usuario));
            } else {
                req.getSession().setAttribute("usuarios", service.findAllUsers());
            }
    req.
            resp.sendRedirect(URL_PROYECTO + "bbdd/userList.jsp");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

 */
}