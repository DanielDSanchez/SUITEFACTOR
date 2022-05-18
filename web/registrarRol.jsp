<%-- 
    Document   : registrarRol
    Created on : 28/04/2022, 12:53:12 PM
    Author     : Juan Pablo
--%>
<%@page import="ModeloVO.RolVO"%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-3 mx-auto justify-content-center border-5 border border-info mt-3 caja">
            <div class="col-md-11 mx-auto justify-content-center mt-5">
                <h1 class="text-center fs-2 mt-2">Registrar Rol</h1>
                <form method ="post" action="Rol" class="form-group mt-2"> 
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
                    <input type="text" name="txtroltipo" required="" placeholder="Tipo de rol" class="form-control mt-2">

                    <div class="mt-2 mb-3">
                        <button class="btn boton"> Registrar </button>
                        <input type="hidden" value="1" name="opcion">     
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>
