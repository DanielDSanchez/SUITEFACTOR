<%-- 
    Document   : recuperarContrasenaUsuario
    Created on : 30-abr-2022, 23:20:41
    Author     : 1Usuario
--%>
 
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Recuperar Contraseña</title>
    </head>
    <body>
        <div class="col-md-3 justify-content-center mx-auto caja border border-info  m">
            <h1 class="text-center fs-4 mt-2">Ingrese su Email</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("error") != null) {%>
                <p class="text-danger text-center fs-5">${error}p>
                <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-4">
                <form  id="formReg"  class="form-group" action="Usuarios" method="post"> 
                    <div class=" col-md-12 mx-auto ">
                        <input type="email"  name= "txtEmail" placeholder="Email" required="" class="form-control ms-1 mt-2">
                        <input type="email"  name= "txtEmail2" placeholder="Confirme Email" required="" class="form-control ms-1 mt-2">  
                        <div class="d-flex d-inline-block mt-4 mb-2">
                            <button class="btn boton" >Verificar</button><br>
                            <input type="hidden" value="6" name="opcion">
                            <a href="index.jsp" class="nav-link text-center">Volver</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>  
    </body>
</html>
