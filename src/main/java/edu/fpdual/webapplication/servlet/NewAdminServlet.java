package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
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
import java.io.PrintWriter;

@WebServlet(name = "NewAdminServlet", urlPatterns = {"/new-admin-servlet"})
public class NewAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        UserService userService = new UserService(new UserClient());
        String notFoundError = "El nombre de usuario no se encuentra en la base de datos.";

        try {
            User user = userService.getUser(request.getParameter("userName"));
            user.setAdmn(true);
            userService.updateUser(user);
        } catch (NotFoundException e) {
            request.setAttribute("error", notFoundError);
            request.getRequestDispatcher("jsp/admin/newAdmin.jsp").forward(request, response);
        }
    }
}