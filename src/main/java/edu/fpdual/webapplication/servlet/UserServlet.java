package edu.fpdual.webapplication.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "UserServlet", urlPatterns = {"/user-servlet"})
public class UserServlet extends HttpServlet {
}