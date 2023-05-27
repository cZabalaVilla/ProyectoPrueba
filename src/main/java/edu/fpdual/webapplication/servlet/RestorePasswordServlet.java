package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dfo.Email;
import edu.fpdual.webapplication.dfo.InvalidEmailException;
import edu.fpdual.webapplication.dfo.Password;
import edu.fpdual.webapplication.dfo.email.Sender;
import edu.fpdual.webapplication.dto.Profile;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.ProfileService;
import edu.fpdual.webapplication.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;

@WebServlet(name = "RestorePasswordServlet", urlPatterns = {"/restore-password-servlet"})
public class RestorePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String notFoundError = "Email no encontrado";
        String dispatcherURLRestore = "jsp/login/restorePassword.jsp";
        String generalError = "Ha ocurrido un error.";
        String ok = "Se ha enviado un email con tu nueva contraseña";

        try {
            ProfileService profileService = new ProfileService(new ProfileClient());
            try {
                Email email = new Email(request.getParameter("email"));
                Profile profile = profileService.getProfile(email.toString());
                String newPassword = Password.resetPassword();
                String bodyMesage = "Esta es tu nueva contraseña: " + newPassword;

                if (new Sender().send(profile.getEmail(), "Restauración de contraseña", "<b>" + bodyMesage + "<b>")) {
                    UserService userService = new UserService(new UserClient());
                    User user = userService.getUserById(profile.getUserId());
                    user.setUserPassword(new Password(newPassword).toString());
                    userService.updateUser(user);
                    request.setAttribute("ok", ok);
                    request.getRequestDispatcher(dispatcherURLRestore).forward(request, response);
                } else {
                    request.setAttribute("error", generalError);
                    request.getRequestDispatcher(dispatcherURLRestore).forward(request, response);
                }
            }catch(InvalidEmailException e){
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher(dispatcherURLRestore).forward(request, response);
            }
        } catch (NotFoundException | NullPointerException | BadRequestException e) {
            request.setAttribute("error", notFoundError);
            request.getRequestDispatcher(dispatcherURLRestore).forward(request, response);
        }
    }
}
