<%-- 
    Document   : registrarMateriasPrimas
    Created on : 30/03/2022, 11:50:44 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Registrar Materia Prima</title>
    </head>
    <body>
        <div class="col-md-3 justify-content-center mx-auto  caja border border-info mt-4">
            <h1 class="text-center fs-3 mt-2">Registrar<br> Materia Prima</h1>
            <div class="col-md-11 mx-auto mt-4 formulario mt-2">
                <form method ="post" action="MateriaPrima" class="form-group"> 
                    <div class="mx-auto justify-content-center">
                            <%if (request.getAttribute("error") != null) {%>
                            <div class="container-fluid d-inline-block d-flex mx-auto">
                                <img src="img/error.svg" height="100">
                                <p class="text-danger text-center fs-5 mt-5">${error}</p>
                            </div>
                            <%   } else {%>
                            <p class="text-success text-center fs-5">${mensajeExito}</p>
                            <%}%>
            </div>
                    <input type="text" name="txtNombre" class="form-control mt-2" required="" placeholder="Nombre">
                    <button class="btn boton mt-2 mb-3"> Registrar </button>
                    <input type="hidden" value="1" name="opcion">
                </form>
            </div>
        </div>
    </body>
</html>
