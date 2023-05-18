<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
   <title>Home</title>
</head>

<body>
   <% Session sesionActual = (Session)session.getAttribute("session"); %>
   <h2>Bienvenido <%=sesionActual.getUserName()%></h2>
   <% if(sesionActual.isAdmin()){
      %>
   <form method="GET" action=<%= GlobalInfo.URL_JSP_CONTROLPANEL %>>
      <input type="submit" value="Panel de administrador">
   </form>
   <%
      }
      %>
   <br/>
   <br/>
   <form method="GET" action=<%= GlobalInfo.URL_JSP_LOGIN %>>
      <input type="submit" value="Logout">
   </form>
</body>

</html>