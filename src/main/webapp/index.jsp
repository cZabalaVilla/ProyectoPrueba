<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import= "edu.fpdual.webapplication.GlobalInfo" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>

    <link rel="stylesheet" href="./css/style_v2.css" />
    <link rel="icon" href="http://localhost:8080/ProyectoPrueba/favicon.ico" type="image/x-icon">

</head>

<body>
    <div class="container">
    <% Session sesionActual = (Session) session.getAttribute("session");%>
    <% if(sesionActual != null) { %>
        <header>
            <a href="index.html" class="logoSidebar">
                <p>Fit-Pocket</p>
            </a>
            <nav>
                <a href="#">Menú 1</a>
                <a href="#">Menú 1</a>
                <a href="#">Menú 1</a>
                <a href="#">Menú 1</a>
                <a href="#">Menú 1</a>
                <a href="#">Menú 1</a>
            </nav>
        </header>
    <%} else {%>
        <main>
            <div class="mainNav">
                <div class="mainLinkNav">
                    <ul>
                        <li>
                            <a href="index.html" class="logoSidebarNoLog">
                                <p>Fit-Pocket</p>
                            </a>
                        </li>
                        <li>
                            <a href="index.html">Inicio</a>
                        </li>
                        <li>
                            <a href="#AboutUs">Nosotros</a>
                        </li>
                        <li>
                            <a href="#Contact">Contacto</a>
                        </li>
                    </ul>
                </div>
    <%}%>
    <%if(sesionActual!=null) {%>


                <div class="dropdown">
                    <img src="./img/userImg.png" />
                    <a href="#" class="username">Username</a>
                    <button class="dropBtn">Username</button>
                    <div class="dropdownContent">
                        <a href="#">Perfil</a>
                        <a href="#">Ajustes</a>
                        <a href="#">Cerrar sesión</a>
                    </div>
                </div>
    <%} else {%>
                <div class="leftNav">
                    <form method="get" action="<%=GlobalInfo.URL_JSP_LOGIN%>">
                        <button type="submit" name="submitBtn" class="buttonB">Login</button>
                    </form>
                    <form method="get" action="<%=GlobalInfo.URL_JSP_REGISTER%>">
                        <button type="submit" name="submitBtn" class="buttonB">Registro</button>
                    </form>
                </div>
    <%}%>
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
