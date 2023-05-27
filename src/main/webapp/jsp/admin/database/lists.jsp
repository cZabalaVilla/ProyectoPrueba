<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de objetos</title>
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="radio"] {
            margin-right: 10px;
        }

        button[type="submit"],
        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover,
        button:hover {
            background-color: #0056b3;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        p {
            color: red;
        }
    </style>
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
    <button onclick="location.href='/ProyectoPrueba/index.jsp'">Volver al inicio</button>
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
    <p><%= request.getAttribute("error") %></p>
    <% } %>
</body>

</html>
