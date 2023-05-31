<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../../headTemplate.jsp" %>
    <title>Lista de objetos</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_lists.css"/>
</head>

<body>
<h1>Listas de Objetos</h1>
<form method="post" action="<%=GlobalInfo.URL_SERVLET_LISTS%>">
    <input type="radio" name="classType" id="budget" value="budget" checked>
    <label for="budget">Presupuestos</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="category" value="category">
    <label for="category">Categorias</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="expense" value="expense">
    <label for="expense">Gastos</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="income" value="income">
    <label for="income">Ingresos</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="profile" value="profile">
    <label for="profile">Perfiles</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="report" value="report">
    <label for="report">Reportes</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="user" value="user">
    <label for="user">Usuarios</label>
    <br/>
    <br/>
    <input type="radio" name="classType" id="empty" value="empty">
    <label for="empty">Vacio</label>
    <br/>
    <br/>
    <button type="submit">Mostrar Lista</button>
</form>
<br/>
<button onclick="<%=GlobalInfo.URL_JSP_CONTROLPANEL%>">Volver al panel de control</button>
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
<% } else if (request.getAttribute("error") != null) { %>
<p><%= request.getAttribute("error") %>
</p>
<% } %>
</body>

</html>
