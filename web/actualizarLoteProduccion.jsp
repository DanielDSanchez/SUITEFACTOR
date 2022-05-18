<%-- 
    Document   : actualizarLoteProduccion
    Created on : 24/03/2022, 08:24:57 AM
    Author     : Daniel
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloVO.OrdenDetallesVO"%>
<%@page import="ModeloDAO.OrdenDetallesDAO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@include file="navegacion.jsp" %>
<%@page import="ModeloVO.LoteProduccionVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/actualizarLoteProduccion.css" >
    </head>
    <body>
 
           <%
            LoteProduccionVO ltProducVO = (LoteProduccionVO)request.getAttribute("LoteProduccionConsultada");
            if (ltProducVO != null) {

        %>
        <div class="col-md-3 mx-auto mt-4 justify-content-center border border-info caja">
            <h1 class="text-center h1 mt-1">Actualizar<br> Lote Produccion</h1>
            <div class="col-md-10 mx-auto">    
                <form action="LoteProduccion" method="post" class="form-group">
                    <label>Id</label>
                    <input type="text" name="txtid_loteProduccion" value="<%=ltProducVO.getId_Lote_Produccion()%>" class="form-control">
                    <label>Id Usuarios</label>
                    <select name="txtId_Usuarios" class="form-select">
                        <option value="<%=ltProducVO.getId_Usuarios()%>"><%=ltProducVO.getId_Usuarios()%></option>
                        <%
                            UsuarioDAO usuDAO = new UsuarioDAO();
                            for (UsuarioVO usuVO : usuDAO.Listar()) {
                        %>
                        <option value="<%=usuVO.getIdUsuarios()%>"><%=usuVO.getNombre()%></option>
                        <%}%>
                    </select>
                    <label>Id Orden Detalles </label>
                    <select name="txtId_orden_detalles" class="form-select">
                        <option value="<%=ltProducVO.getId_orden_Detalles()%>"><%=ltProducVO.getId_orden_Detalles()%></option>
                        <%
                            OrdenDetallesDAO odDAO = new OrdenDetallesDAO();
                            for (OrdenDetallesVO odVO : odDAO.Listar()) {
                        %>
                        <option value="<%=odVO.getId_Orden_Detalles()%>"><%=odVO.getId_Orden_Detalles()%></option>
                        <%}%>
                    </select>
                    <label>Cantidad</label>
                    <input type="number" name="txtcantidad" placeholder="Cantidad" value="<%=ltProducVO.getCantidad()%>" class="form-control">
                    <label>Fecha de fabricacion</label>
                    <input type="date" name="txtfecha_Fabricacion" value="<%=ltProducVO.getFecha_Fabricacion()%>" class="form-control">
                    <div class="d-flex">
                        <button class="btn boton mt-2">Actualizar</button>
                        <input type="hidden" value="2" name="opcion">
                        <a href="consultarLoteProduccion.jsp" class="nav-item nav-link ms-5 mt-2">Volver</a><br>
                    </div>
                    <div class="">
                        <%
                            if (request.getAttribute("mensajeError") != null) {%>
                        ${mensajeError}

                        <%   } else {%>
                        ${mensajeExito}

                        <%}%>
                    </div>
                </form>
            </div>
        </div>


        <% } else {
                request.getRequestDispatcher("consultarLoteProduccion.jsp").forward(request, response);

            }%>
    </body>
</html>
