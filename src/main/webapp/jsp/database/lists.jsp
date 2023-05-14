<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <form method="post" action="/ProyectoPrueba/login-servlet">
        <label for="usuario">Usuario:</label>
        <input type="text" id="usuario" name="usuario"><br><br>
        <label for="userpassword">Password:</label>
        <input type="password" id="userpassword" name="userpassword"><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
