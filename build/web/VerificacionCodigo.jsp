<%-- 
    Document   : VerificacionCodigo
    Created on : 30-abr-2022, 23:43:53
    Author     : 1Usuario
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%HttpSession buscarSesion = (HttpSession) request.getSession();
    UsuarioVO usuVO1 = null;
    if (buscarSesion.getAttribute("datosUsuarioRecuperarContrasena") == null) {
        request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
    } else {
        usuVO1 = (UsuarioVO) buscarSesion.getAttribute("datosUsuario");
    } %>
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
        <title>Verificacion de Codigo</title>
    </head>
    <body>
        <div class="col-md-3 mx-auto justify-content-center border-5 border border-info m caja">
            <div class="col-md-8 mx-auto justify-content-center mt-5">
                <form  class="form-group" action="Usuarios" method="post"> 
                    <h1 class="text-center fs-4 mb-4">Ingrese el Codigo</h1>
                    <div class="mx-auto justify-content-center">
                        <%if (request.getAttribute("envioCorreo") != null) {%>
                        <p class="text-success text-center fs-5">${envioCorreo}</p>
                        <%}%>
                    </div>
                    <div class="mx-auto justify-content-center">
                        <%if (request.getAttribute("error") != null) {%>
                        <div class="container-fluid d-inline-block d-flex mx-auto">
                            <img src="img/error.svg" height="100">
                            <p class="text-danger text-center fs-5 mt-5">${error}</p>
                        </div>
                        <%   }%>
                    </div>
                    <div class="col-md-12">
                        <input type="text"  name= "txtcodigo" placeholder="Codigo" required="" class="form-control ms-1 mt-2">   
                    </div> 
                    <div class="d-flex mt-4 mb-3">
                        <button class="btn boton" >Verificar</button><br>
                        <input type="hidden" value="7" name="opcion">
                        <a href="index.jsp" class="nav-link text-center">Volver</a>
                    </div>
                </form>
            </div>  
        </div>
    </body>
</html>
