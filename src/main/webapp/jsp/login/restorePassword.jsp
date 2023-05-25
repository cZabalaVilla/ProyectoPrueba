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
    <form method="post" action="/ProyectoPrueba/restore-password-servlet">
        <label for="email">Email: </label>
        <input type="text" name="email" id="email" required>
        <br/>
        <br/>
        <input type="submit" value="Restablecer">
    </form>
</body>

</html>
