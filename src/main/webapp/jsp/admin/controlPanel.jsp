<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../insert/headTemplate.jsp" %>
    <title>Panel de control</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>
</head>

<body>
<div class="container">
    <%@ include file="../insert/header.jsp" %>
    <main>
        <%@ include file="../insert/mainNav.jsp" %>
        <div class="mainBlock">
            <h2>Panel de control de administrador</h2>
            <div class="content">
                <form method="post" action="<%=GlobalInfo.URL_JSP_NEWADMIN%>">
                    <input type="submit" name="submitBtn" value="Create admin">
                </form>
                <br/>
                <form method="post" action="<%=GlobalInfo.URL_JSP_LISTS%>">
                    <input type="submit" name="submitBtn" value="Database">
                </form>
                <br/>
                <form action="">
                    <input type="submit" name="submitBtn" value="empty">
                </form>
                <br/>
            </div>
        </div>
        <%@ include file="../insert/footer.jsp" %>
    </main>
</div>
</body>

</html>
