<%@ page pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.persistence.dao.Usuario" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de usuarios</title>
</head>
<html>
    <body>
        <form action="/ProyectoPrueba/usuarioServlet" method="GET">
                <p>Nombre Usuario: </p> <input type="text" name="usuario"/></br>
                <button type="submit">Buscar</button>
                <button type="reset">Cancelar</button>
        </form>
        <%
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        List<Usuario> usuarios = (List<Usuario>)session.getAttribute("usuarios");
        session.removeAttribute("usuario");
        session.removeAttribute("usuarios");
        if(usuario!=null){%>
            <h2>Usuario Seleccionado</h2>
            <table>
            <tr>
                <th>Usuario</th>
                <th>Password</th>
                <th>Codigo Pais</th>
            </tr>
            <tr>
                <td><%=usuario.getUsuario()%></td>
                <td><%=usuario.getUserPassword()%></td>
            </tr>
            </table>
        <%}

        if(usuarios!=null && usuarios.size() > 0){%>
            <h2>Listado de Usuarios</h2>
            <table>
            <tr>
                <th>Usuario</th>
                <th>Password</th>
            </tr>
            <%for(Usuario usuario1: usuarios){%>
                <tr>
                    <td><%=usuario1.getUsuario()%></td>
                    <td><%=usuario1.getUserPassword()%></td>
                </tr>
            <%}%>
            </table>
        <%}%>
    </body>
</html>
