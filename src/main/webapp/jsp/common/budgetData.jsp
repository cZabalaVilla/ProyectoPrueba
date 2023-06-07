<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Presupuesto</title>

    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>

</head>

<body>
<div class="container">
    <%@ include file="../insert/header.jsp" %>
    <main>
        <%@ include file="../insert/mainNav.jsp" %>

        <div class="mainBlock">
            <div class="contentList">
                <h3 class="pageTitle1">Nombre del Presupuesto</h3>
                <div>
                    <p>Descripcion: </p>
                    <p>Fecha: </p>
                    <p>Balance: //moneda//</p>
                </div>
                <div>
                    <input type="button" name="incomeBtn" value="Añadir Ingreso" class="buttonD"/>
                    <input type="button" name="expenseBtn" value="Añadir Gasto" class="buttonD"/>
                </div>

                <div class="listElement">
                    <h4>Nombre del Gasto/Ingreso </h4>
                    <p>Revisar</p>
                    <p>Editar</p>
                    <p>Borrar</p>
                </div>
            </div>
        </div>
        <%@ include file="../insert/footer.jsp" %>
    </main>
</div>
</body>

</html>