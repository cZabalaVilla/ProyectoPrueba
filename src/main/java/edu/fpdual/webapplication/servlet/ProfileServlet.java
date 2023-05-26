package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.client.ProfileClient;
import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.Profile;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.ProfileService;
import edu.fpdual.webapplication.service.UserService;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile-servlet"})
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ok = "Campos actualizados.";
        String error = "Ha ocurrido un error.";
        String dispatcherURLProfile = "jsp/common/profile.jsp";

        Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);
        User user = new UserService(new UserClient()).getUserByName(session.getUserName());

        try {
            Profile profile = new Profile(user.getUserId(),request.getParameter("description"),
                    request.getParameter("email"),
                    request.getParameter("link"),
                    request.getParameter("location"),
                    Integer.parseInt(request.getParameter("phone")));
            if(new ProfileService(new ProfileClient()).updateProfile(profile)){
                request.setAttribute("ok", ok);
                request.getRequestDispatcher(dispatcherURLProfile).forward(request, response);
            } else {
                request.setAttribute("error", error);
                request.getRequestDispatcher(dispatcherURLProfile).forward(request, response);
            }
        }catch (NumberFormatException e){
            request.setAttribute("error", error);
            request.getRequestDispatcher(dispatcherURLProfile).forward(request, response);
            e.printStackTrace();
        }

    }
}
