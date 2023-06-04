<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>
<%@ page import="edu.fpdual.webapplication.dto.Currency" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Presupuesto</title>

    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css" />

</head>

<body>
    <div class="container">
        <%@ include file="../insert/header.jsp" %>
        <main>
           <%@ include file="../insert/mainNav.jsp" %>

            <div class="mainBlock">
                <div class="content">
                    <h3 class="pageTitle">Nuevo <br/> Presupuesto</h3>
                    <br/>
                    <form method="POST" action="/ProyectoPrueba/create-budget-servlet" class="form">
                        <label for="form">Nombre</label>
                        <br />
                        <input type="text" id="budgetNameInput" name="budgetNameInput" />
                        <br />
                        <br />
                        <label for="form">Moneda</label>
                        <br />
                        <select id="currencyInput" name="currencyInput"/>
                        <%List<Currency> currencyList = (List<Currency>)session.getAttribute("currencyList");
                            session.removeAttribute("currencyList");
                        if(currencyList!=null && currencyList.size() > 0){
                            for(Currency currency: currencyList){%>
                               <option value="<%=currency.getCurrencyId()%>"><%=currency.getCurrencyName()%> (<%=currency.getCurrencySymbol()%>)</option>
                            <%}
                        }%>
                        </select>
                        <br />
                        <br />
                        <label for="form">Descripción</label>
                        <br />
                        <textarea id="budgetDescInput" name="budgetDescInput" rows="5" cols="65"></textarea>
                        <br />
                        <br />
                        <button type="submit" name="submitBtn" value="Guardar" class="buttonC">Crear</button>
                        <button type="reset" name="resetBtn" value="Cancelar" class="buttonCancel">Cancelar</button>
                    </form>
                </div>
            </div>
           <%@ include file="../insert/footer.jsp" %>
        </main>
    </div>
</body>

</html>