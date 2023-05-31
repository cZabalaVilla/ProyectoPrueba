package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.Profile;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.ProfileService;
import edu.fpdual.webapplication.service.UserService;
import edu.fpdual.webapplication.utilities.Email;
import edu.fpdual.webapplication.utilities.InvalidEmailException;
import edu.fpdual.webapplication.utilities.InvalidPasswordException;
import edu.fpdual.webapplication.utilities.Password;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register-servlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String incompleteError = "El campo usuario está vacío";
        String espaceFoundError = "El nombre de usuaio no puede tener espacios";
        String userAlreadyError = "El nombre de usuario ya está registrado";
        String incorrectUserNameError = "El nombre de usuario tiene que estar entre 5 y 20 caracteres y no contener caracteres especiales";
        String ok = "Usuario creado correctamente.";

        String userNameReceived = request.getParameter("userName");
        String userPasswordReceived = request.getParameter("userPassword");
        String emailReceived = null;
        try {
            emailReceived = new Email(request.getParameter("email")).toString();
        } catch (InvalidEmailException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher(GlobalInfo.URL_JSP_REGISTER).forward(request, response);
        }

        UserService userService = new UserService(new UserClient());

        if (userNameReceived == null || userPasswordReceived == null) {
            request.setAttribute("error", incompleteError);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_REGISTER).forward(request, response);
        } else if (userService.getUserByName(userNameReceived) != null) {
            request.setAttribute("error", userAlreadyError);
            request.getRequestDispatcher(GlobalInfo.URL_JSP_REGISTER).forward(request, response);
        } else if (userNameReceived.contains(" ")) {
            request.setAttribute("error", espaceFoundError);
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        } else if (userNameReceived.length() > 5 && userNameReceived.length() < 20 && userNameReceived.matches("[a-zA-Z0-9]+")) {
            User user = null;
            try {
                user = new User(userNameReceived, new Password(userPasswordReceived).toString(), false);
            } catch (InvalidPasswordException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher(request.getContextPath()).forward(request, response);
            }
            if (userService.createUser(user)) {
                Profile profile = new Profile(new UserService(new UserClient()).getUserByName(userNameReceived).getUserId(), emailReceived);
                new ProfileService(new ProfileClient()).createProfile(profile);
                request.setAttribute("ok", ok);
                request.getRequestDispatcher(request.getContextPath()).forward(request, response);
            }
        } else {
            request.setAttribute("error", incorrectUserNameError);
            request.getRequestDispatcher(request.getContextPath()).forward(request, response);
        }
    }
}