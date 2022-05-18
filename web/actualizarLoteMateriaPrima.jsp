<%-- 
    Document   : actualizarLoteMateriaPrima
    Created on : 25/04/2022, 05:12:08 PM
    Author     : Juan Pablo
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.MateriaPrimaVO"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>
<%@page import="ModeloVO.loteMateriaPrimaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 
           <%
            loteMateriaPrimaVO lmpVO = (loteMateriaPrimaVO)request.getAttribute("LoteMateriaPrimaConsultada");
            if (lmpVO != null) {

        %>
            <h1 class="text-center h1 mt-1">Actualizar<br> Lote Produccion</h1>
            <div class="col-md-10 mx-auto">    
                <form action="loteMateriaPrima" method="post" class="form-group">
                    <label>Id</label>
                    <br>
                    <input type="text" name="txtIdLoteMateriaPrima" value="<%=lmpVO.getId_loteMateria_Prima()%>" class="form-control">
                    <br>
                    <label>Id Materia Prima</label>
                    <br>
                    <select name="txtIdMateriaPrima" class="form-select">
                        <option value="<%=lmpVO.getId_Materia_Prima()%>"><%=lmpVO.getId_Materia_Prima()%></option>
                        <%
                            MateriaPrimaDAO mpDAO = new MateriaPrimaDAO();
                            for (MateriaPrimaVO mpVO : mpDAO.ListarDos()) {
                        %>
                        <option value="<%=mpVO.getId_materia_Prima()%>"><%=mpVO.getNombre()%></option>
                        <%}%>
                    </select>
                    <br>
                    <label>Cantidad </label>
                    <br>
                    <input name="txtCantidad" type="number" value="<%=lmpVO.getCantidad()%>">
                    <br>
                    <label>Observaciones</label>
                    <br>
                    <textarea name="txtObservaciones" value="<%=lmpVO.getObservaciones()%>" class="form-control"><%=lmpVO.getObservaciones()%></textarea>
                    <br>
                    <label>Fecha de ingreso</label>
                    <br>
                    <input type="date" name="txtFechaIngreso" value="<%=lmpVO.getFecha_ingreso()%>" class="form-control">
                    <br>
                     <label>Fecha de salida</label>
                    <br>
                    <input type="date" name="txtFechaSalida" value="<%=lmpVO.getFecha_salida()%>" class="form-control">
                    <br>
                    <div class="d-flex">
                        <button class="btn boton mt-2">Actualizar</button>
                        <input type="hidden" value="2" name="opcion">
                        <a href="consultarLoteMateriaPrima.jsp" class="nav-item nav-link ms-5 mt-2">Volver</a><br>
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
                request.getRequestDispatcher("consultarLoteMateriaPrima.jsp").forward(request, response);

            }%>
    </body>
</html>
