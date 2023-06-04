<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="jsp/insert/headTemplate.jsp" %>
    <title>Fit-Pocket</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>
</head>

<body>
<div class="container">
    <main>
        <div class="mainNav">
            <div class="mainLinkNav">
                <ul>
                    <li>
                        <a href="<%=GlobalInfo.URL_INDEX%>" class="logoSidebarNoLog">
                            <p>Fit-Pocket</p>
                        </a>
                    </li>
                    <li>
                        <a href="<%=GlobalInfo.URL_INDEX%>">Inicio</a>
                    </li>
                    <li>
                        <a href="<%=GlobalInfo.URL_JSP_ABOUTUS%>">Nosotros</a>
                    </li>
                    <li>
                        <a href="<%=GlobalInfo.URL_JSP_CONTACTUS%>">Contacto</a>
                    </li>
                </ul>
            </div>

            <div class="leftNav">
                <form method="get" action="<%=GlobalInfo.URL_JSP_LOGIN%>">
                    <button type="submit" name="submitBtn" class="buttonB">Login</button>
                </form>
                <form method="get" action="<%=GlobalInfo.URL_JSP_REGISTER%>">
                    <button type="submit" name="submitBtn" class="buttonB">Registro</button>
                </form>
            </div>

        </div>
        <div class="mainBlock">
            <div class="content">
                <p>contenido aquí</p>
            </div>
        </div>
        <footer>
            <div>
                <p>Aquí va el footer</p>
            </div>
        </footer>
    </main>
</div>
</body>

</html>
