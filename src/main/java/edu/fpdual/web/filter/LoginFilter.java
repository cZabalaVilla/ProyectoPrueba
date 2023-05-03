package edu.fpdual.web.filter;


import edu.fpdual.persistence.dao.Usuario;
import edu.fpdual.web.servlet.dto.Sesion;

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

@WebFilter(filterName="loginFilter", urlPatterns={"/comun/*"}, dispatcherTypes= {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class LoginFilter implements  Filter {

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

        HttpServletRequest req = (HttpServletRequest)servletRequest;

        Sesion sesion = (Sesion)req.getSession().getAttribute("usuarioSesion");

        if(sesion == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/ProyectoPrueba/login/login.jsp");
        } else {
            System.out.println("Antes de pasar filtro");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Despues de pasar filtro");
        }
    }

    @Override
    public void destroy() {

    }
}
