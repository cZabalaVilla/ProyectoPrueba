package edu.fpdual.webApplication.filter;


import edu.fpdual.webApplication.servlet.dto.Session;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
