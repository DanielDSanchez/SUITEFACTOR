<%-- 
    Document   : Prueba
    Created on : 31/03/2022, 08:21:52 AM
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/style.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/IniciarSesion.css" />
        <title>Login y registro</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="forms-container">
                <div class="signin-signup">
                    <form action = "Usuarios" class="sign-in-form" method="post">
                        <a href="menu.jsp">
                            <img src="img/LogoFinal.svg" class="image" alt="" height="115" />
                        </a>
                        <h2 class="title">Iniciar Sesión</h2>
                        <div class="input-field">
                            <i class="fas fa-user"></i>
                            <input type="text" name="txtDocumento" placeholder="Usuario" />
                        </div>
                        <div class="input-field d">
                            <i class="fas fa-lock"></i>
                            <input ID="txtContrasena" name="txtContrasena" type="Password" Class="" placeholder="Contraseña">
                        </div>
                        <div>
                            ver
                            <button id="show_password" type="button"
                            onclick="mostrarPassword()" class="Boton"><img src="img/ver.svg" height="30"> </button>
                            
                        </div>

                        <button class="btn solid"> Ingresar </button>
                        <input type="hidden" value="4" name="opcion">
                        <a href="recuperarContrasenaUsuario.jsp">¿Olvido su Contraseña?</a>
                        <div class="mensaje">
                            <%
                        if (request.getAttribute("mensajeError") != null) {%>
                            ${mensajeError}                              

                            <%}%>
                        </div>
                    </form>
                </div>
            </div>

            <div class="panels-container">
                <div class="panel left-panel">
                    <div class="content">
                        <h3>¿Nuevo usuario?</h3>
                        <p>
                            Si es nuevo usuario y no tiene cuente puede crear una a continuación:
                        </p>
                        <button onclick="location.href = 'registrarUsuario.jsp'"  class="btn transparent" id="sign-up-btn">
                            Registrarse
                        </button>
                    </div>
                    <img src="img/Login/Login.svg" class="image" alt="" />
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function mostrarPassword() {
                var cambio = document.getElementById("txtContrasena");
                if (cambio.type == "password") {
                    cambio.type = "text";
                    
                } else {
                    cambio.type = "password";
                    
                }
            }
        </script>
    </body>
</html>
