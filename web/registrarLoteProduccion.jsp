<%-- 
    Document   : Registrar
    Created on : 10/03/2022, 08:21:00 AM
    Author     : Sena
--%>

<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.OrdenDetallesVO"%>
<%@page import="ModeloDAO.OrdenDetallesDAO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@include file="navegacion.jsp" %>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilos.css" >
    </head>

    <body>

        <div class="col-md-3 mx-auto mt-4 justify-content-center border border-info caja">
            <h1 class="text-center h1 mt-1">Registrar <br>Lote Produccion</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>

                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>

                <%}%>
            </div>
            <div class="col-md-10 mx-auto">
                <form action="LoteProduccion" method="post" class="form-group mt-5">
                    <input type="hidden" value="<%=usuVO1.getIdUsuarios()%>" name="txtId_Usuarios">
                <select name="txtId_orden_detalles" class="form-select mt-2">
                    <option>Seleccione Id orden detalles...</option>
                    <%
                        OrdenDetallesDAO odDAO = new OrdenDetallesDAO();
                        for (OrdenDetallesVO odVO : odDAO.Listar()) {
                    %>
                    <option value="<%=odVO.getId_Orden_Detalles()%>"><%=odVO.getId_Orden_Detalles()%></option>
                    <%}%>
                </select>
                <input type="number" name="txtcantidad" placeholder="Cantidad" class="form-control mt-2">

                <label class="ms-2">Fecha de fabricacion</label>

                <input type="date" name="txtfecha_Fabricacion" class="form-control mt-2">

                <div>
                    <button  class="boton btn mt-2">Registrar</button>
                </div>
                <input type="hidden" value="1" name="opcion">
                </form>
            </div>
    </div>
       
    </body>

</html>
