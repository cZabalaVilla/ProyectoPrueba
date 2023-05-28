<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../headTemplate.jsp" %>
    <title>Register Fit-Pocket</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>
</head>

<body>
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
    <form method="post" action="<%=GlobalInfo.URL_SERVLET_REGISTER%>">
        <label for="email">Correo Electrónico</label>
        <br/>
        <input type="email" id="email" name="email" placeholder="nombre@ejemplo.com"/>
        <br/>
        <br/>
        <label for="userName">Usuario</label>
        <br/>
        <input type="text" id="userName" name="userName" placeholder="PepePinillos12"/>
        <br/>
        <br/>
        <label for="userPassword">Contraseña</label>
        <br/>
        <input type="password" id="userPassword" name="userPassword" placeholder="Password"/>
        <br/>
        <br/>
        <% if (request.getAttribute("error") != null) { %>
        <div class="errorAlert">
            <p style="color:red"><%=request.getAttribute("error")%>
            </p>
        </div>
        <% } else if (request.getAttribute("ok") != null) { %>
        <p><%= request.getAttribute("ok") %>
        </p>
        <% } %>
        <button type="submit" name="submitBtn" value="" class="buttonA">Registrar</button>
        <br/>
        <br/>
        <p class="centerTxt"><a href=<%=GlobalInfo.URL_JSP_LOGIN%>>¿Ya tiene cuenta?</a></p>
    </form>
</section>
</body>

</html>