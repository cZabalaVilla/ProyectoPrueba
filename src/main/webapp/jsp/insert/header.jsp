<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<header>
    <a href="<%=GlobalInfo.URL_INDEX%>" class="logoSidebar">
       <p>Fit-Pocket</p>
    </a>
    <div class="userSettings">
       <nav>
          <a href="<%=GlobalInfo.URL_SERVLET_ADDBUDGET%> ">Crear Presupuesto</a>
          <a href="<%=GlobalInfo.URL_SERVLET_LISTBUDGETS%>">Listar Presupuestos</a>
          <a href="#">Informes</a>
          <a href="#">Categorías</a>
       </nav>
    </div>
</header>