package edu.fpdual.webapplication.servlet;

import com.mysql.cj.protocol.x.Notice;
import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout-servlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    request.getSession().invalidate();
    response.sendRedirect(GlobalInfo.URL_INDEX);
    }
}
