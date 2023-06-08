<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Presupuesto</title>

    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css" />

</head>

<body>
    <div class="container">
       <%@ include file="../insert/header.jsp" %>
        <main>
            <%@ include file="../insert/mainNav.jsp" %>

            <div class="mainBlock">
                            <div class="contentList">
                                <h3 class="pageTitle1">Nombre del Presupuesto</h3>
                                <div class="descriptionTextBudget">
                                    <p><span>Descripcion:</span> </p>
                                    <p><span>Fecha:</span> </p>
                                    <p><span>Balance:</span> //moneda//</p>
                                </div>
                                <div class="budgetButtons">
                                    <form method="" action="">
                                        <input type="button" name="incomeBtn" value="Añadir Ingreso" class="buttonD" />
                                    </form>
                                    <form method="" action="">
                                       <input type="button" name="expenseBtn" value="Añadir Gasto" class="buttonD" />
                                    </form>
                                    <form method="" action="">
                                        <input type="button" name="expenseBtn" value="Borrar" class="buttonD" />
                                    </form>
                                </div>

                                <div class="listElement2">
                                    <h4>Nombre del Gasto/Ingreso </h4>
                                    <div class="descriptionTextBudget">
                                        <p>Descripcion:</p>
                                        <p>Categoría: </p>
                                        <p>Cantidad: </p>
                                        <p>Recurrente: </p>
                                        <p>Fecha: </p>
                                    </div>
                                    <form method="" action="">
                                        <input type="button" name="expenseBtn" value="Borrar" class="buttonD" />
                                    </form>
                                </div>
                            </div>
                        </div>
            <%@ include file="../insert/footer.jsp" %>
        </main>
    </div>
</body>

</html>