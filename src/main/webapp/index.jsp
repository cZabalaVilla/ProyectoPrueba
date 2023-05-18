<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=chrome">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Inicio</title>

    <link rel="stylesheet" href="./css/style.css" />
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
</head>

<body>

    <section class="boxBody">
        <div>
            <a href="index.html" class="logoTxt">
                <h2 class="logoTxt">Fit-Pocket</h2>
            </a>
        </div>
        <br/>
        <br/>
        <p class="centerTxt"> <a href= <%=GlobalInfo.URL_JSP_LOGIN%> >Ir al login</a></p>
        <br/>
        <p class="centerTxt"> <a href= <%=GlobalInfo.URL_JSP_NOTIFICATION%> >Test de conexión</a></p>
    </section>

</body>

</html>
