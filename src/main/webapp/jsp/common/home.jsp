<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.web.servlet.dto.Sesion" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
<title>Home</title>
</head>
    <body>
        <%
        if(session.getAttribute("usuarioSesion")!=null){
            Sesion sesion = (Sesion)session.getAttribute("usuarioSesion");
            %>
            <h2> Bienvenido <%=sesion.getUsuario()%> </h2>
        <%} else {%>
        <form action="/ProyectoPrueba/login/loginJSP.jsp" method="GET">
            <h2> No ha iniciado sesión, por favor ir al login </h2></br>
            <button type="submit">Ir a inicio de sesión</button>
        </form>
        <%
        }

        Enumeration<String> parameters = request.getParameterNames();%>

        <table>
        <tr>
            <th>Nombre</th>
            <th>Valor</th>
        </tr>
        <%while(parameters.hasMoreElements()){
            String name = parameters.nextElement();
            String valor = request.getParameter(name);%>
            <tr>
                <td><%=name%></td>
                <td><%=valor%></td>
            </tr>
        <%}%>
        </table>
    </body>
</html>
