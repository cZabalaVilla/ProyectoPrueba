<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../headTemplate.jsp" %>
    <title>Panel de control</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_pre.css"/>
</head>

<body>
<h2>Panel de control de administrador</h2>
<form method="post" action="<%=GlobalInfo.URL_JSP_HOME%>">
    <input type="submit" name="submitBtn" value="Volver">
</form>
<br/>
<form method="post" action="<%=GlobalInfo.URL_JSP_NEWADMIN%>">
    <input type="submit" name="submitBtn" value="Create admin">
</form>
<br/>
<form method="post" action="<%=GlobalInfo.URL_JSP_LISTS%>">
    <input type="submit" name="submitBtn" value="Database">
</form>
<br/>
<form method="post" action="<%=GlobalInfo.URL_JSP_REDIRECCION%>">
    <input type="submit" name="submitBtn" value="Redirection">
</form>
<br/>
<form action="">
    <input type="submit" name="submitBtn" value="empty">
</form>
<br/>
</body>

</html>
