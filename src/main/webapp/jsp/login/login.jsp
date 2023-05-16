<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red"><%= request.getAttribute("error") %></p>
    <% } %>
    <% if (session.getAttribute(GlobalInfo.session) != null) {
     response.sendRedirect("/ProyectoPrueba/jsp/redir/redireccion.jsp");
     } %>
    <form method="post" action=<%= GlobalInfo.URL_SERVLET_LOGIN %>>
        <label for="userName">Usuario:</label>
        <input type="text" id="userName" name="userName"><br><br>
        <label for="userPassword">Password:</label>
        <input type="password" id="userPassword" name="userPassword"><br><br>
        <input type="submit" value="Login">
    </form>
    <a href="/ProyectoPrueba/jsp/form/formNewUser.jsp">Crear una nueva cuenta.</a>

</body>
</html>
