<%-- 
    Document   : registrarLoteMateriaPrima
    Created on : 9/03/2022, 09:06:15 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.MateriaPrimaVO"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>

<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Lote Materia Prima</title>
        <link rel="stylesheet" href="css/estilos.css">

    </head>
    <body>
        <div class="col-md-3 justify-content-center mx-auto caja border border-info mt-4">
            <h1 class="text-center fs-2 mt-2">Registrar<br> Lote Materia Prima</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>

                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>

                <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-4">
                <form class="Formulario" method = "post" action = "loteMateriaPrima" class="form-group mt-2" > 
                    <select name="txtIdMateriaPrima" class="form-select mt-2">
                        <option>Seleccione Id Materia Prima..</option>
                        <%
                            MateriaPrimaDAO matDAO = new MateriaPrimaDAO();
                            for (MateriaPrimaVO matVO : matDAO.ListarDos()) {

                        %>


                        <option value="<%=matVO.getId_materia_Prima()%>"><%=matVO.getNombre()%></option>
                        <%}%>
                    </select>
                    <input type="text" name="txtCantidad" placeholder="Cantidad" required="" class="form-control mt-2">
                    <label class="mt-2">Fecha de ingreso</label>
                    <input type="date" name="txtFechaIngreso" placeholder="Fecha de ingreso" required="" class=" mt-2 form-control">
                    <label class="mt-2">Fecha de salida</label>
                    <input type="date" name="txtFechaSalida" placeholder="Fecha de salida" required="" class=" mt-2 form-control">
                    <textarea name="txtObservaciones" placeholder="Observaciones" class="form-control mt-2"></textarea>
                    <div class="mt-2 mb-3">
                        <button class="btn boton"> Registrar</button>
                        <input type="hidden" value="1" name="opcion">
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>