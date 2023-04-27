<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Formulario de prueba</title>
</head>
<body>
    <h1>Formulario de prueba</h1>
    <form method="post" action="crear-usuario">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required><br>
        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" id="apellido" required><br>
        <label for="email">Correo electrónico:</label>
        <input type="email" name="email" id="email" required><br>
        <label for="password">Contraseña:</label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" value="Crear usuario">
    </form>
</body>
</html>
