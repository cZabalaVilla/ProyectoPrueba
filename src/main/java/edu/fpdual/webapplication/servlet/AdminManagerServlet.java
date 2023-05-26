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
        String notFoundError = "El nombre de usuario no se encuentra en la base de datos.";
        String URL_Dispatcher = "jsp/admin/adminManager.jsp";

        try {
            User user = new UserService(new UserClient()).getUser(request.getParameter("userName"));
            if(request.getParameter("update") != null){
                user.setAdmn(true);
                new UserService(new UserClient()).updateUser(user);
            } else if(request.getParameter("delete") != null){
                user.setAdmn(false);
                new UserService(new UserClient()).updateUser(user);
            }
        } catch (NotFoundException e) {
            request.setAttribute("error", notFoundError);
            request.getRequestDispatcher(URL_Dispatcher).forward(request, response);
        }
    }
}