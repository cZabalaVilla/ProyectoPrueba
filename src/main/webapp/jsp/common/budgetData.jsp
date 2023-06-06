<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.fpdual.webapplication.GlobalInfo" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Presupuesto</title>

    <link rel="stylesheet" href="./css/style_v2.css" />

</head>

<body>
    <div class="container">
        <header>
            <a href="#" class="logoSidebar">
                <p>Fit-Pocket</p>
            </a>
            <div class="userSettings">
                <nav>
                    <a href="#">Crear Presupuesto</a>
                    <a href="#">Listar Presupuestos</a>
                    <a href="#">Informes</a>
                    <a href="#">Categorías</a>
                </nav>
            </div>


        </header>
        <main>
            <div class="mainNav">
                <div class="mainLinkNav">
                    <ul>
                        <li>
                            <a class="active" href="#home">Home</a>
                        </li>
                        <li>
                            <a class="active" href="#AboutUs">Nosotros</a>
                        </li>
                        <li>
                            <a class="active" href="#Contact">Contacto</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown">
                    <button class="dropBtn">Username</button>
                    <div class="dropdownContent">
                        <a href="#">Perfil</a>
                        <a href="#">Ajustes</a>
                        <a href="#">Cerrar sesión</a>
                    </div>
                </div>
            </div>

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

            <footer>
                <div>
                    <p>Aquí va el footer</p>
                </div>
            </footer>
        </main>
    </div>
</body>

</html>