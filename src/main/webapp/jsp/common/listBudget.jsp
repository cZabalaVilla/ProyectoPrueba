<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>
<%@ page import="edu.fpdual.webapplication.dto.Budget" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Presupuestos</title>

    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>

</head>

<body>
<div class="container">
    <%@ include file="../insert/header.jsp" %>
    <main>
        <%@ include file="../insert/mainNav.jsp" %>

        <div class="mainBlock">
            <div class="contentList">
                <h3 class="pageTitle1">Lista de Presupuestos</h3>
                <%
                    List<Budget> budgetList = (List<Budget>) session.getAttribute("budgetList");
                    session.removeAttribute("budgetList");
                    if (budgetList != null && budgetList.size() > 0) {
                        for (Budget budget : budgetList) {
                %>
                <div class="listElement">
                    <h4><%= budget.getBudgetName() %>
                    </h4>
                    <form method="get" action="<%=GlobalInfo.URL_SERVLET_BUDGETDATA%>">
                        <input type="hidden" name="budgetName" value="<%= budget.getBudgetName() %>">
                        <button type="submit" name="submitBtn" class="buttonB">Revisar</button>
                    </form>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
        <%@ include file="../insert/footer.jsp" %>
    </main>
</div>
</body>

</html>