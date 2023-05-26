<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Login</title>
    <!-- El css hay que ponerlo como ruta absoluta. -->
   <link rel="stylesheet" href="/ProyectoPrueba/css/style_v2.css" />
   <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">
</head>

<body>
    <section class="boxBody">
        <div>
            <a href="/ProyectoPrueba/" class="logoTxt">
                <h3 class="logoTxt">Fit-Pocket</h3>
            </a>
            <br/>
            <h3>Entrar</h3>
        </div>
        <br/>
        <form method="POST" action= <%=GlobalInfo.URL_SERVLET_LOGIN%> >
            <!-- Verificación de la sesión por si estuviera creada -->
            <% if (session.getAttribute(GlobalInfo.session) != null) {
                response.sendRedirect(GlobalInfo.URL_JSP_HOME);
            } %>
            <label for="form">Nombre de usuario</label>
            <br/>
            <input type="text" id="userName" name="userName" placeholder="Nombre123" required/>
            <br/>
            <br/>
            <label for="form">Contraseña</label>
            <br/>
            <input type="password" id="userPassword" name="userPassword" placeholder="Contraseña" required/>
            <br/>
            <br/>
            <% if (request.getAttribute("error") != null){
            %>
                <p class="errorAlert"><%= request.getAttribute("error") %></p><br/>
                <br/>
            <% } %>
            <p class="centerTxt"><a href= <%=GlobalInfo.URL_JSP_RESTOREPASSWORD%> >¿Olvidó la contraseña?</a></p>
            <br/>
            <input type="submit" value="Entrar" class="buttonA"/>
            <br/>
            <br/>
            <p class="centerTxt"> <a href= <%=GlobalInfo.URL_JSP_REGISTER%> >¿No tiene cuenta? Cree una</a></p>
        </form>
    </section>

</body>

</html>