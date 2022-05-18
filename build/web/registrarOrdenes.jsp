<%-- 
    Document   : registrarOrdenes
    Created on : 9/03/2022, 09:50:34 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Ordenes</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>

    <body>

        <div class="col-md-3 justify-content-center mx-auto caja border border-info mt-4">
            <h1 class="text-center fs-2 mt-2">Registrar Orden</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-3">
                <form method ="post" action="Ordenes" class="form-group"> 
                    <input type="hidden" value="<%=usuVO1.getIdUsuarios()%>" name="txtUsu">
                    <label>Fecha Registro</label>
                    <input type="date" name="txtFechaRegistro" class="form-control">
                    <label>Fecha Entrega</label>
                    <input type="date" name="txtFechaEntrega" class="form-control">
                    <div class="mt-3 mb-2">
                        <button class="btn boton"> Registrar </button>
                        <input type="hidden" value="1" name="opcion">
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>