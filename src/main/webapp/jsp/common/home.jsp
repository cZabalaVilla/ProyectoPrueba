<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>

<html>
    <head>
        <title>Home</title>
    </head>
    <body>
            <% Session sesionActual = (Session)session.getAttribute("session"); %>
            <h2>Bienvenido <%=sesionActual.getUserName()%></h2>
            <% if(sesionActual.isAdmin()){
            %>
                <form method="GET" action="/ProyectoPrueba/jsp/admin/controlPanel.jsp">
                    <input type="submit" value="Panel de administrador">
                </form>
            <%
            }
            %>
    </body>
</html>
