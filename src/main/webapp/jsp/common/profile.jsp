<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.dto.Profile" %>
<%@ page import="edu.fpdual.webapplication.dto.User" %>
<%@ page import="edu.fpdual.webapplication.service.UserService" %>
<%@ page import="edu.fpdual.webapplication.service.ProfileService" %>
<%@ page import="edu.fpdual.webapplication.client.UserClient" %>
<%@ page import="edu.fpdual.webapplication.client.ProfileClient" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../headTemplate.jsp" %>
    <title>Perfil</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_profile.css"/>
</head>

<body>
<h1>Formulario de Usuario</h1>
<% Session thisSession = (Session) request.getSession().getAttribute(GlobalInfo.session); %>
<% User user = new UserService(new UserClient()).getUserByName(thisSession.getUserName()); %>
<% Profile profile = new ProfileService(new ProfileClient()).getProfile(user.getUserId()); %>
<form method="post" action="<%= GlobalInfo.URL_SERVLET_PROFILE %>">
    <label for="description">Descripción:</label>
    <textarea id="description" name="description"></textarea>

    <label for="email">Correo Electrónico:</label>
    <input type="email" id="email" name="email" value="<%= profile.getEmail() %>">

    <label for="link">Enlace:</label>
    <input type="url" id="link" name="link" value="<%= profile.getLink() %>">

    <label for="location">Ubicación:</label>
    <input type="text" id="location" name="location" value="<%= profile.getLocation() %>">

    <label for="phone">Teléfono:</label>
    <input type="number" id="phone" name="phone" value="<%= profile.getPhone() %>">
    <% if (request.getAttribute("error") != null) { %>
    <p style="color:red"><%= request.getAttribute("error") %>
    </p><br/>
    <% } else if (request.getAttribute("ok") != null) { %>
    <p><%= request.getAttribute("ok") %>
    </p>
    <% } %>
    <input type="submit" value="Guardar">
</form>
</body>

</html>
