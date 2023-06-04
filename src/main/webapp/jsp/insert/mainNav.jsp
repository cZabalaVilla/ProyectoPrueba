<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<div class="mainNav">
    <div class="mainLinkNav">
        <ul>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_INDEX%>">Inicio</a>
            </li>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_ABOUTUS%>">Nosotros</a>
            </li>
            <li>
                <a class="active" href="<%=GlobalInfo.URL_JSP_CONTACTUS%>">Contacto</a>
            </li>
        </ul>
                </div>
                <div class="dropdown">
                    <button class="dropBtn">Username</button>
                    <div class="dropdownContent">
                        <a href="<%= GlobalInfo.URL_JSP_PROFILE %>">Perfil</a>
                        <a href="<%= GlobalInfo.URL_SERVLET_LOGOUT %>">Cerrar sesión</a>
                    </div>
                </div>
</div>