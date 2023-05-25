<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Formulario de usuario</title>
</head>

<body>
    <h1>Formulario de creacion de usuario</h1>
    <form method="post" action="/ProyectoPrueba/new-user-servlet">
        <label for="userName">Nombre de usuario: </label>
        <input type="text" name="userName" id="userName" required>
        <br/>
        <br/>
        <label for="userPassword">Password: </label>
        <input type="text" name="userPassword" id="userPassword" required>
        <br/>
        <br/>
        <input type="submit" value="Crear usuario">
    </form>
</body>

</html>
