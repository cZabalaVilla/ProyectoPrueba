<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Algo ha ocurrido.</title>
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/ProyectoPrueba/css/style-error500.css" />
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper">
        <div class="box">
            <h1>500</h1>
            <p>Lo siento, soy yo, no eres tú.</p>
            <p>&#58;&#40;</p>
            <p><a href="<%=GlobalInfo.URL_JSP_HOME%>">Volvamos al inicio.</a></p>
        </div>
    </div>
</body>

</html>