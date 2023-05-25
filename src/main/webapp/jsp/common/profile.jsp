<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.dto.Profile" %>
<%@ page import="edu.fpdual.webapplication.dto.User" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <title>Formulario de Usuario</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h1 {
      text-align: center;
    }

    form {
      max-width: 400px;
      margin: 0 auto;
    }

    label {
      display: block;
      margin-bottom: 10px;
    }

    input[type="text"],
    input[type="password"],
    textarea {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-bottom: 10px;
    }

    textarea {
      height: 100px;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <h1>Formulario de Usuario</h1>
  <%
    Session session = Session session = (Session) request.getSession().getAttribute(GlobalInfo.session);
    User user = new UserService(new UserClient()).getUser(session.getUserName());
    Profile profile = new ProfileService(new ProfileClient()).getProfile(user.getUserId());
  %>
  <form method="post" action=<%= GlobalInfo.URL_SERVLET_PROFILE% >>
    <label for="description">Descripción:</label>
    <textarea id="description" name="description"></textarea>

    <label for="email">Correo Electrónico:</label>
    <input type="email" id="email" name="email" value=<%=profile.getEmail()%>>

    <label for="link">Enlace:</label>
    <input type="url" id="link" name="link" value=<%=profile.getLink()%>>

    <label for="location">Ubicación:</label>
    <input type="text" id="location" name="location" value=<%=profile.getLocation()%>>

    <label for="phone">Telefono:</label>
    <input type="number" id="phone" name="phone" value=<%=profile.getPhone()%>>
    <% if (request.getAttribute("error") != null){%>
      <p style="color:red"><%= request.getAttribute("error") %></p><br/>
    <% } else if (request.getAttribute("ok") != null){
     %> <p><%= request.getAttribute("ok") %></p>
       <%}%>
    <input type="submit" value="Guardar">
  </form>
</body>
</html>
