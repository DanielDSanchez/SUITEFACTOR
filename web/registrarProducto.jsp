<%-- 
    Document   : registrarProducto
    Created on : 9/03/2022, 09:28:13 AM
    Author     : Andrex
--%>
<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Producto</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body class="">
        <div class="col-md-3 mx-auto justify-content-center border-5 border border-info mt-3 caja">
                <div class="col-md-11 mx-auto justify-content-center mt-5">
                    <h1 class="text-center fs-2 mt-2">Registrar Producto</h1>
                    <form  class="form-group" method="get" action="Producto">
                        <div class="mx-auto justify-content-center">
                            <%if (request.getAttribute("error") != null) {%>
                            <div class="container-fluid d-inline-block d-flex mx-auto">
                                <img src="img/error.svg" height="100">
                                <p class="text-danger text-center fs-5 mt-5">${error}</p>
                            </div>
                            <%   } else {%>
                            <p class="text-success text-center fs-5">${Bien}</p>
                            <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-4">
                    <input class="form-control" type="text" name="txtNombre" placeholder="Nombre" required="">
                    <br>
                    <div class="col-md-12 d-flex mt-2 mb-3">
                        <button class="btn boton"> Registrar </button>
                        <input type="hidden" value="1" name="opcion">
                    </div>
                        
                    </form>    
            </div>
        </div>
    </body>
</html>