package edu.fpdual.webapplication.filter;


import edu.fpdual.webapplication.servlet.dto.Session;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/comun/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    String URL_LOGIN = "/ProyectoPrueba/login/login.jsp";
    private final String sessionAtributte = "sesion";
    @Override
    public void init(FilterConfig filterConfig)
            throws
            ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws
            IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Session session = (Session) req.getSession().getAttribute(sessionAtributte);

        if (session == null) {
            ((HttpServletResponse) servletResponse).sendRedirect(URL_LOGIN);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
