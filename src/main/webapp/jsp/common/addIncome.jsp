<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>
<%@ page import="edu.fpdual.webapplication.dto.Category" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Ingreso</title>

    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css" />

</head>

<body>
    <div class="container">
        <%@ include file="../insert/header.jsp" %>
        <main>
            <%@ include file="../insert/mainNav.jsp" %>

            <div class="mainBlock">
                <div class="content">
                    <h3 class="pageTitle">Nuevo <br /> Ingreso</h3>
                    <br />
                    <form method="post" action="<%=GlobalInfo.URL_SERVLET_ADDINCOME%>" class="form">
                        <label for="form">Nombre</label>
                        <br />
                        <input type="text" id="incomeNameInput" name="incomeNameInput" required/>
                        <br />
                        <br />
                        <label for="form">Descripción</label>
                        <br />
                        <textarea id="incomeDescInput" name="incomeDescInput" rows="5"
                            cols="65"></textarea>
                        <br />
                        <br />
                        <label for="form">Cantidad</label>
                        <br />
                        <input type="number" id="incomeAmountInput" name="incomeAmountInput" required/>
                        <br />
                        <br />
                        <label for="form">Categoría</label>
                        <br />
                        <select id="categoryInput" name="categoryInput" required/>
                        <%List<Category> categoryList = (List<Category>)session.getAttribute("categoryList");
                            session.removeAttribute("categoryList");
                        if(categoryList!=null && categoryList.size() > 0){
                            for(Category category: categoryList){%>
                                <option value="<%=category.getCategoryId()%>"> <%=category.getCategoryName()%> </option>
                            <%}
                        }%>
                        </select>
                        <br />
                        <br />
                        <input type="checkbox" id="recurrentIncome" name="recurrentIncome" >
                        <label for="form"> Hacer ingreso mensual</label>
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