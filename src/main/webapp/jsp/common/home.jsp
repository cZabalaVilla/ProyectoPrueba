<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="edu.fpdual.webapplication.servlet.dto.Session" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
   <title>Home</title>
   <style>
      body {
         font-family: Arial, sans-serif;
         background-color: #f5f5f5;
         margin: 0;
         padding: 0;
      }

      h2 {
         color: #333;
         text-align: center;
         padding: 20px 0;
      }

      .container {
         max-width: 600px;
         margin: 0 auto;
         padding: 20px;
         background-color: #fff;
         box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      }

      .admin-panel-btn {
         display: flex;
         justify-content: center;
         margin-top: 20px;
      }

      .logout-btn {
         display: flex;
         justify-content: center;
         margin-top: 20px;
      }

        .profile-btn {
           display: flex;
           justify-content: center;
           margin-top: 20px;
            }

      input[type="submit"] {
         padding: 10px 20px;
         background-color: #007bff;
         color: #fff;
         border: none;
         border-radius: 4px;
         font-size: 16px;
         cursor: pointer;
      }

      input[type="submit"]:hover {
         background-color: #0056b3;
      }
   </style>
</head>

<body>
   <div class="container">
      <% Session sesionActual = (Session) session.getAttribute("session"); %>
      <h2>Bienvenido <%= sesionActual.getUserName().toLowerCase() %></h2>

      <% if (sesionActual.isAdmin()) { %>
         <div class="admin-panel-btn">
            <form method="GET" action="<%= GlobalInfo.URL_JSP_CONTROLPANEL %>">
               <input type="submit" value="Panel de administrador">
            </form>
         </div>
      <% } %>

      <div class="logout-btn">
         <form method="POST" action="<%= GlobalInfo.URL_SERVLET_LOGOUT %>">
            <input type="submit" value="Logout">
         </form>
      </div>

    <div class="profile-btn">
       <form method="POST" action="<%= GlobalInfo.URL_JSP_PROFILE %>">
          <input type="submit" value="Profile">
       </form>
    </div>

   </div>
</body>

</html>
