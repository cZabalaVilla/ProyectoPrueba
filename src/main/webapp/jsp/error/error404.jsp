<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vaya...</title>
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/ProyectoPrueba/css/style-error404.css" />
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
</head>

<body>
  <div class="mainbox">
    <div class="err">4</div>
    <i class="far fa-question-circle fa-spin"></i>
    <div class="err2">4</div>
    <div class="msg">Quizás esta página ya no está aquí... <br/>O se ha borrado... <br/>O acaso se ha escondido?<br/>Y si nunca llegó a existir?<p>
    Volvamos al <a href="<%=GlobalInfo.URL_JSP_HOME%>">inicio</a> y probemos desde ahí.</p>
    </div>
  </div>
</body>

</html>