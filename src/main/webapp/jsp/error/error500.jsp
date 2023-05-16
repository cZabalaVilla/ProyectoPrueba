<%@ page isErrorPage="true" %>

<html>
    <body>
        <h3>Ha ocurrido una excepcion !</h3>
        Exception : <%= exception %>
        <br>
        <button onclick="location.href='\index.jsp'">Volver al inicio</button>
    </body>
</html>