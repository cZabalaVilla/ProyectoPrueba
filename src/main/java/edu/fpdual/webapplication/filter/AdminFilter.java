package edu.fpdual.webapplication.filter;

import edu.fpdual.webapplication.GlobalInfo;
import edu.fpdual.webapplication.servlet.dto.Session;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "adminFilter", urlPatterns = {"/jsp/admin/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws
            IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);

        if (session == null) {
            ((HttpServletResponse) servletResponse).sendRedirect(GlobalInfo.URL_JSP_LOGIN);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
