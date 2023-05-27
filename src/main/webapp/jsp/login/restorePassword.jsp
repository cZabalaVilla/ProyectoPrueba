<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Fit-Pocket</title>

    <link rel="stylesheet" href="/ProyectoPrueba/css/style_v2.css" />

</head>
<body>
   <!-- Cuerpo -->
   <div class="boxBody">
        <div>
            <a href="/ProyectoPrueba/" class="logoTxt">
                <h3 class="logoTxt">Fit-Pocket</h3>
            </a>
            <br/>
            <h3>Restaurar Contraseña</h3>
        </div>
        <!-- Para que salga el error
        <div class="errorAlert">
            <p>E-Mail o contraseña incorrecto.</p>
        </div>-->
        <br/>
        <form method="post" action="/ProyectoPrueba/restore-password-servlet" >
            <label for="floatingInput">Correo Electrónico</label>
            <br/>
            <br/>
            <input type="text" name="email" id="email" placeholder="nombre@ejemplo.com" />
            <br/>
            <br/>
                  <!-- Mensaje de error en caso de que haya algo incorrecto-->
                  <% if (request.getAttribute("error") != null){ %>
                    <p style="color:red"><%= request.getAttribute("error") %></p><br/>
                  <% } else if(request.getAttribute("ok") != null){ %>
                    <p><%= request.getAttribute("ok") %></p><br/>
                  <% } %>
            <br/>
            <br/>
                  <%if(request.getAttribute("ok") == null){ %>
                    <button type="submit" name="submitBtn" value="Restablecer" class="buttonA">Enviar</button>
                  <% } else { %>
                    <a href="<%=GlobalInfo.URL_JSP_LOGIN%>">Volver al login</a>
                  <% } %>
            <br/>
            <br/>
        </form>
    </div>
   <!-- Fin Cuerpo -->

</body>
</html>
