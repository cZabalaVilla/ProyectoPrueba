<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="./css/style-pre.css" />
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
</head>

<body>
   <div class="container">
      <% Session sesionActual = (Session) session.getAttribute("session"); %>
      <h2>Bienvenido <%= sesionActual.getUserName().toLowerCase() %></h2>

      <% if (sesionActual.isAdmin()) { %>
         <div class="admin-panel-btn">
            <form method="GET" action="<%= GlobalInfo.URL_JSP_CONTROLPANEL %>">
               <input type="submit" value="Panel de administrador">
            </form>
         </div>
      <% } %>

      <div class="logout-btn">
         <form method="POST" action="<%= GlobalInfo.URL_SERVLET_LOGOUT %>">
            <input type="submit" value="Logout">
         </form>
      </div>

    <div class="profile-btn">
       <form method="POST" action="<%= GlobalInfo.URL_JSP_PROFILE %>">
          <input type="submit" value="Profile">
       </form>
    </div>

   </div>
</body>

</html>
