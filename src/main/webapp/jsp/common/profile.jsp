<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.dto.Profile" %>
<%@ page import="edu.fpdual.webapplication.dto.User" %>
<%@ page import="edu.fpdual.webapplication.service.UserService" %>
<%@ page import="edu.fpdual.webapplication.service.ProfileService" %>
<%@ page import="edu.fpdual.webapplication.client.UserClient" %>
<%@ page import="edu.fpdual.webapplication.client.ProfileClient" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../insert/headTemplate.jsp" %>
    <title>Perfil</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css" />

</head>
<body>
    <div class="container">
        <%@ include file="../insert/header.jsp" %>
        <main>
            <%@ include file="../insert/mainNav.jsp" %>
            <div class="mainBlock">
                <div class="content">
                    <% Session thisSession = (Session) request.getSession().getAttribute(GlobalInfo.session); %>
                    <% User user = new UserService(new UserClient()).getUserByName(thisSession.getUserName()); %>
                    <% Profile profile = new ProfileService(new ProfileClient()).getProfile(user.getUserId()); %>
                    <img src="./img/userImg.png" class="profileImg" />
                    <form method="post" action="<%= GlobalInfo.URL_SERVLET_PROFILE %>" >
                        <label for="form">Nombre</label>
                        <br />
                        <input type="text" id="userName" name="userName" value="<%= user.getUserName() %>" />
                        <br />
                        <br />
                        <label for="form">Correo Electrónico</label>
                        <br />
                        <input type="email" id="email" name="email" value="<%= profile.getEmail() %>" />
                        <br />
                        <br />
                        <label for="form">Página Web</label>
                        <br />
                        <input type="url" id="link" name="link" value="<%= profile.getLink() %>" />
                        <br />
                        <br />
                        <label for="form">Ubicación</label>
                        <br />
                        <input type="text" id="location" name="location" value="<%= profile.getLocation() %>" />
                        <br />
                        <br />
                        <label for="form">Teléfono</label>
                        <br />
                        <input type="number" id="phone" name="phone" value="<%= profile.getPhone() %>" />
                        <br />
                        <br />
                        <label for="form">Bio</label>
                        <br />
                        <textarea id="description" name="description" rows="5" cols="65"><%= profile.getDescription() %></textarea>
                        <br />
                        <br />
                        <% if (request.getAttribute("error") != null) { %>
                            <p class="errorAlert"><%= request.getAttribute("error") %></p><br/>
                        <% } else if (request.getAttribute("ok") != null) { %>
                            <p><%= request.getAttribute("ok") %></p>
                        <% } %>
                        <button type="submit" name="submitBtn" value="Guardar" class="buttonC">Actualizar</button>
                    </form>
                </div>
            </div>
            <%@ include file="../insert/footer.jsp" %>
        </main>
    </div>
</body>

</html>
