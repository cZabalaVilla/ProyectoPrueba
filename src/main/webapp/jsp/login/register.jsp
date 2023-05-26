<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Fit-Pocket</title>

    <link rel="stylesheet" href="/ProyectoPrueba/css/style_v2.css" />

</head>
<body>
   <!-- Cuerpo -->
   <section class="boxBody">
        <div>
            <a href="/ProyectoPrueba/" class="logoTxt">
                <h3 class="logoTxt">Fit-Pocket</h3>
            </a>
            <br/>
            <h3>Registro</h3>
        </div>
        <!-- Para que salga el error
        <div class="errorAlert">
            <p>E-Mail o contraseña incorrecto.</p>
        </div>-->
        <br/>
        <form method="post" action="/ProyectoPrueba/new-user-servlet" >
            <label for="floatingInput">Correo Electrónico</label>
            <br/>
            <input type="email" id="floatingInput" placeholder="nombre@ejemplo.com" />
            <br/>
            <br/>
            <label for="floatingPassword">Contraseña</label>
            <br/>
            <input type="password" id="floatingPassword" placeholder="Password" />
            <br/>
            <br/>
            <label for="floatingPassword">Contraseña</label>
            <br/>
            <input type="password" id="floatingPassword" placeholder="Password" />
            <br/>
            <br/>
            <button type="submit" name="submitBtn" value="" class="buttonA">Registrar</button>
            <br/>
            <br/>
            <p class="centerTxt"> <a href= <%=GlobalInfo.URL_JSP_LOGIN%> >¿Ya tiene cuenta?</a></p>
        </form>

   </section>
   <!-- Fin Cuerpo -->

</body>
</html>