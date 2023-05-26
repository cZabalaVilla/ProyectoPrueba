package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;

@WebServlet(name = "AdminManagerServlet", urlPatterns = {"/admin-manager-servlet"})
public class AdminManagerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String updated = "El usuario es ahora un administrador.";
        String deleted = "El usuario no es ahora un administrador.";
        String isAdminError = "El usuario ya era un administrador.";
        String isNotAdminError = "El usuario no es un administrador.";
        String notFoundError = "El nombre de usuario no se encuentra en la base de datos.";
        String URL_Dispatcher = "jsp/admin/adminManager.jsp";

        try {
            User user = new UserService(new UserClient()).getUserByName(request.getParameter("userName"));
            if(request.getParameter("action").equals("update")){
                if(!user.isAdmn()) {
                    user.setAdmn(true);
                    new UserService(new UserClient()).updateUser(user);
                    request.setAttribute("ok", updated);
                    request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
                } else {
                    request.setAttribute("error", isAdminError);
                    request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
                }
            } else if(request.getParameter("action").equals("delete")){
                if(user.isAdmn()) {
                    user.setAdmn(false);
                    new UserService(new UserClient()).updateUser(user);
                    request.setAttribute("ok", deleted);
                    request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
                } else {
                    request.setAttribute("error", isNotAdminError);
                    request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
                }
            }else {
                request.setAttribute("error", "Ha ocurrido un error inesperado.");
                request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
            }
        } catch (NotFoundException | NullPointerException e) {
            request.setAttribute("error", notFoundError);
            request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
        }
    }
}