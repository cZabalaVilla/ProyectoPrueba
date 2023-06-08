<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../insert/headTemplate.jsp" %>
    <title>Manejo de administrador</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_pre.css"/>
</head>

<body>
<div class="container">
    <h1>Manejo de administradores</h1>
    <form method="post" action="<%=GlobalInfo.URL_SERVLET_ADMINMANAGER%>">
        <label for="userName">Nombre de usuario:</label>
        <input type="text" name="userName" id="userName" required>
        <br/>
        <% if (request.getAttribute("error") != null) { %>
        <p style="color:red"><%= request.getAttribute("error") %>
        </p><br/>
        <% } else if (request.getAttribute("ok") != null) { %>
        <p><%= request.getAttribute("ok") %>
        </p><br/>
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
