<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manejo de administrador</title>
    <link rel="stylesheet" href="/ProyectoPrueba/css/style-pre.css" />
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
</head>

<body>
  <div class="container">
    <h1>Manejo de administradores</h1>
    <form method="post" action="<%=GlobalInfo.URL_SERVLET_ADMINMANAGER%>">
      <label for="userName">Nombre de usuario:</label>
      <input type="text" name="userName" id="userName" required>
      <br/>
      <!-- Mensaje de error en caso de que haya algo incorrecto-->
      <% if (request.getAttribute("error") != null){ %>
        <p style="color:red"><%= request.getAttribute("error") %></p><br/>
      <% } else if(request.getAttribute("ok") != null){ %>
        <p><%= request.getAttribute("ok") %></p><br/>
      <% } %>
      <br/>
      <button type="submit" name="action" value="update">Crear admin</button>
      <button type="submit" name="action" value="delete">Borrar admin</button>
      <br/>
      <br/>
    </form>
  </div>
</body>

</html>
