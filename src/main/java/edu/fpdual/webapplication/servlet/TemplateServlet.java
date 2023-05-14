package edu.fpdual.webapplication.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class TemplateServlet extends HttpServlet {

    protected final String URL_PROYECTO = "/ProyectoPrueba";
    /*
     * URL de los .jsp
     */
    protected final String URL_HOME = URL_PROYECTO + "/jsp/common/home.jsp";
    protected final String URL_LOGIN = URL_PROYECTO + "/jsp/login/login.jsp";
    protected final String session = "session";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
