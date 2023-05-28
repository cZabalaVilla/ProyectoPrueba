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
<form method="post" action="<%=GlobalInfo.URL_PROYECTO%>/lists-servlet">
    <label for="user">Usuarios</label>
    <input type="radio" name="classType" id="user" value="user">
    <br/>
    <br/>
    <label for="category">Categorias</label>
    <input type="radio" name="classType" id="category" value="category">
    <br/>
    <br/>
    <label for="profile">Perfiles</label>
    <input type="radio" name="classType" id="profile" value="profile">
    <br/>
    <br/>
    <label for="empty">Vacio</label>
    <input type="radio" name="classType" id="empty" value="empty">
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
