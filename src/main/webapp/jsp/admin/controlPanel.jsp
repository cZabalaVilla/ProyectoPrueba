<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
        <title>Panel de control</title>
</head>

<body>
    <h2>Panel de control de administrador</h2>
    <form method="post" action="/ProyectoPrueba/jsp/notificationTest.jsp">
        <input type="submit" name="submitBtn" value="Connection Test"></a>
    </form>
    <br/>
    <form method="post" action="/ProyectoPrueba/jsp/login/login.jsp">
        <input type="submit" name="submitBtn" value="Login"></a>
    </form>
    <br/>
    <form method="post" action="/ProyectoPrueba/jsp/admin/adminManager.jsp">
        <input type="submit" name="submitBtn" value="Create admin"></a>
    </form>
    <br/>
    <form method="post" action="/ProyectoPrueba/jsp/admin/database/lists.jsp">
        <input type="submit" name="submitBtn" value="Database"></a>
    </form>
    <br/>
    <form method="post" action="/ProyectoPrueba/jsp/redir/redireccion.jsp">
        <input type="submit" name="submitBtn" value="Redirection"></a>
    </form>
    <br/>
    <form method="" action="">
        <input type="submit" name="submitBtn" value="empty"></a>
    </form>
    <br/>
</body>

</html>
