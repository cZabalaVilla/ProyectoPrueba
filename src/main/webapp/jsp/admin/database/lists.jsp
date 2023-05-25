<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Listas de objetos</title>
</head>

<body>
    <h1>Listas de Objetos</h1>

    <form method="post" action="<%= request.getContextPath() %>/lists-servlet">
        <input type="radio" name="classType" id="user" value="user">Usuarios
        <br/>
        <br/>
        <input type="radio" name="classType" id="category" value="category">Categorías
        <br/>
        <br/>
        <input type="radio" name="classType" id="profile" value="profile">Perfiles
        <br/>
        <br/>
        <input type="radio" name="classType" id="empty" value="empty">Empty
        <br/>
        <br/>
        <button type="submit">Mostrar Lista</button>
    </form>
    <br/>
    <button onclick="href='/ProyectoPrueba/index.jsp'">Volver al inicio</button>
    <br/>
    <br/>

    <% List<String> objectList = (List<String>) request.getAttribute("objectList"); %>
        <% if (objectList != null && !objectList.isEmpty()) { %>
            <ul>
                <% for (String obj : objectList) { %>
                    <li>
                        <%= obj %>
                    </li>
                    <% } %>
            </ul>
            <% } else if(request.getAttribute("error") != null){ %>
                    <p style="color:red"><%= request.getAttribute("error") %></p>
              <% } %>
</body>

</html>