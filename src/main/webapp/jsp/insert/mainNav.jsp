<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>

<% Session thisSession = (Session) session.getAttribute("session"); %>

<div class="mainNav">
    <div class="mainLinkNav">
        <ul>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_HOME%>">Inicio</a>
            </li>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_ABOUTUS%>">Nosotros</a>
            </li>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_CONTACTUS%>">Contacto</a>
            </li>
            <% if (thisSession.isAdmin()){ %>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_CONTACTUS%>">Panel de administrador</a>
            </li>
            <% } %>
        </ul>
    </div>
    <div class="dropdown">
        <button class="dropBtn"><%= thisSession.getUserName() %></button>
        <div class="dropdownContent">
            <form method="Get" action="<%= GlobalInfo.URL_JSP_PROFILE %>">
                <input type="submit" value="Perfil">
            </form>
            <form method="POST" action="<%= GlobalInfo.URL_SERVLET_LOGOUT %>">
                <input type="submit" value="Cerrar Sesión">
            </form>
        </div>
    </div>
</div>