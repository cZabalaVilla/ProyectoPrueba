<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Nuevo administrador</title>
</head>

<body>
    <h1>Formulario de creacion de usuario</h1>
    <form method="post" action="/ProyectoPrueba/new-admin-servlet">
        <label for="username">Nombre de usuario: </label>
        <input type="text" name="username" id="username" required>
        <br/>
        <!-- Mensaje de error en caso de que haya algo incorrecto
        <% if (request.getAttribute("error") != null){
        %>
            <p style="color:red"><%= request.getAttribute("error") %></p><br/>
        <% }
        %>-->
        <br/>
        <input type="submit" value="Crear admin">
    </form>
</body>

</html>
