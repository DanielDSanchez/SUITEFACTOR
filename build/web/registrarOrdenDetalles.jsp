<%-- 
    Document   : registrarOrdenDetalles
    Created on : 30/03/2022, 10:39:11 AM
    Author     : Daniel
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloDAO.OrdenesDAO"%>
<%@page import="ModeloVO.DetallesProductoVO"%>
<%@page import="ModeloDAO.DetallesProductoDAO"%>
<%@page import="ModeloVO.OrdenesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div class="col-md-3 justify-content-center mx-auto caja border border-info mt-4">
            <h1 class="text-center fs-3 mt-2">Actualizar<br> Ordenes Detalles</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
            <div class="col-md-11 mx-auto mt-4 formulario">
                <form action="OrdenDetalles" method="post" class="form-group">
                    <select name="txtIdOrden" required="" class="form-select mt-2">
                        <option>Seleccione un IdOrden...</option>
                        <%
                            OrdenesDAO ordDAO = new OrdenesDAO();
                            for (OrdenesVO ordVO : ordDAO.listar()) {

                        %>

                        <option value="<%=ordVO.getId_Orden()%>"><%=ordVO.getId_Orden()%></option>

                        <%}%>
                    </select>
                    <select name="idDetallesProducto" required="" class="form-select mt-2">
                        <option>Seleccione IdDetalles de producto...</option>
                        <%
                            DetallesProductoDAO dpDAO = new DetallesProductoDAO();
                            for (DetallesProductoVO dpVO : dpDAO.listar()) {

                        %>
                        <option value="<%=dpVO.getId_Detalles_Producto()%>"><%=dpVO.getId_Detalles_Producto()%></option>
                        <%}%>
                    </select>
                    <input class="form-select mt-2" type="number" name="txtcantidadSolicitada" required="" placeholder="Cantida Solicitada">
                    <div class="col-md-12 mt-2 mb-3">
                        <button class="btn boton"> Registrar </button>
                        <input type="hidden" value="1" name="opcion">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>