<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="insert/headTemplate.jsp" %>
    <title>Contacto</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>

</head>

<body>
    <div class="container">
        <main>
            <div class="mainNav">
                <div class="mainLinkNav">
                    <ul>
                        <li>
                            <a href="#" class="logoSidebarNoLog">
                                <p>Fit-Pocket</p>
                            </a>
                        </li>
                        <li>
                            <a class="active" href="#home">Home</a>
                        </li>
                        <li>
                            <a class="active" href="#AboutUs">About Us</a>
                        </li>
                        <li>
                            <a class="active" href="#Contact">Contact</a>
                        </li>
                    </ul>
                </div>
                <div class="leftNav">
                    <form method="get" action="url">
                        <button type="submit" name="submitBtn" value="" class="buttonB">Login</button>
                    </form>
                    <form method="get" asction="url">
                        <button type="submit" name="submitBtn" value="" class="buttonB">Registro</button>
                    </form>
                </div>
            </div>

            <div class="mainBlock">
                <div class="content">
                    <h3 class="pageTitle">Contáctanos</h3>
                    <br/>
                    <form method="" action="" class="form">
                        <label for="form">Nombre</label>
                        <br />
                        <input type="text" id="nameContact" name="nameContact"/>
                        <br />
                        <br />
                        <label for="form">Correo Electrónico</label>
                        <br />
                        <input type="email" id="emailContact" name="emailContact"/>
                        <br />
                        <br />
                        <label for="form">Mensaje</label>
                        <br />
                        <textarea id="contactMessage" name="contactMessage" rows="5" cols="65"></textarea>
                        <br />
                        <br />
                        <button type="submit" name="submitBtn" value="" class="buttonC">Enviar</button>
                    </form>
                </div>
            </div>
            <%@ include file="../insert/footer.jsp" %>
        </main>
    </div>
</body>

</html>