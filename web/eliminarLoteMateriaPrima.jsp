<%-- 
    Document   : consultarLoteMateriaPrima
    Created on : 04-abr-2022, 20:52:14
    Author     : cesar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.loteMateriaPrimaDAO"%>
<%@page import="ModeloVO.loteMateriaPrimaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>Lote Materia Prima</title>
    </head>
    <body>
        <h1 class="text-center">Lote Materia Prima</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            <div class="col-md-6 mx-auto "> 
                <form  method="post" action="loteMateriaPrima" class="form-group"> 
                    <input type="text" name="txtIdLoteMateriaPrima" class="form-control" placeholder="Lote Materia Prima"><br>
                    <input type="hidden" value="4" name="opcion">
                    <button class="btn">Consultar</button>
                </form>
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
            <div class="col-md-6">
                <form action="loteMateriaPrima" method="post" class="form-group">
                    <button  class="boton btn mt-3" title="Reporte de Producto">
                        Generar Reporte
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                        <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
                        <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
                        </svg>
                    </button>
                    <input type="hidden" value="10" name="opcion">
                </form>
            </div>
        </div>    
        <div class="col-md-9 mx-auto justify-content-center mt-3">
            <table  class="table table-light table-hover table-striped text-center ">

                <tr>
                    <th>Id</th>
                    <th>Id Materia Prima</th>
                    <th>Cantidad</th>
                    <th>Observaciones</th>
                    <th>Fecha Ingreso</th>
                    <th>Fecha Salida</th>

                </tr>
                <%
                    loteMateriaPrimaVO ltMatPriVO = new loteMateriaPrimaVO();
                    loteMateriaPrimaDAO ltMatPriDAO = new loteMateriaPrimaDAO(ltMatPriVO);

                    ArrayList<loteMateriaPrimaVO> listaLoteMateriaPrima = ltMatPriDAO.ListarDos();

                    for (int i = 0; i < listaLoteMateriaPrima.size(); i++) {

                        ltMatPriVO = listaLoteMateriaPrima.get(i);

                %>
                <tr>
                    <td><%=ltMatPriVO.getId_loteMateria_Prima()%></td>
                    <td><%=ltMatPriVO.getId_Materia_Prima()%></td>
                    <td><%=ltMatPriVO.getCantidad()%></td>
                    <td><%=ltMatPriVO.getObservaciones()%></td>
                    <td><%=ltMatPriVO.getFecha_ingreso()%></td>
                    <td><%=ltMatPriVO.getFecha_salida()%></td>

                    <td>
                        <form action="loteMateriaPrima" method="post">
                            <input type="hidden" name="txtEstado" value="1">
                            <input type="hidden" name="txtIdLoteMateriaPrima" value="<%=ltMatPriVO.getId_loteMateria_Prima()%>">
                            <button class="btn boton">Activar</button>
                            <input type="hidden" value="5" name="opcion">
                        </form>
                    </td>
                    
                    <td>
                        <form action="loteMateriaPrima" method="post">
                            <input type="hidden" name="txtIdLoteMateriaPrima" value="<%=ltMatPriVO.getId_loteMateria_Prima()%>">
                            <button class="btn boton">Eliminar</button>
                            <input type="hidden" value="6" name="opcion">
                        </form>
                    </td>

                </tr>

                <% }%>

            </table>
        </div>


    </body>
</html>