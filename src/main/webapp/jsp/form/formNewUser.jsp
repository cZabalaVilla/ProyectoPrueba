<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Formulario de prueba</title>
</head>

<body>
    <h1>Formulario de creacion de usuario</h1>
    <form method="post" action="/ProyectoPrueba/new-user-servlet">
        <label for="username">Nombre de usuario: </label>
        <input type="text" name="username" id="username" required>
        <br/>
        <br/>
        <label for="password">Password: </label>
        <input type="text" name="password" id="password" required>
        <br/>
        <br/>
        <input type="submit" value="Crear usuario">
    </form>
</body>

</html>
