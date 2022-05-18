<%-- 
    Document   : consultarLoteProduccion
    Created on : 24/03/2022, 08:25:13 AM
    Author     : Daniel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.LoteProduccionVO"%>
<%@page import="ModeloDAO.LoteProduccionDAO"%>
<%@page import="ModeloVO.LoteProduccionVO"%>
<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="text-center">Lote Produccion</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            <div class="col-md-4 mx-auto ">
                <form method="post" action="LoteProduccion" class="form-group"> 
                    <input type="text" name="txtid_loteProduccion" placeholder="Id" class="form-control d-flex">
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
                <form action="LoteProduccion" method="post" class="form-group">
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
        <div class="col-md-9 mx-auto justify-content-center mt-4">
            <table class="table table-light table-hover table-striped text-center">

                <tr>
                    <th>Id</th>
                    <th>Id Usuarios</th>
                    <th>Id orden Detalles</th>
                    <th>Cantidad</th>
                    <th>Fecha Fabricacion</th>


                </tr>
                <%
                    LoteProduccionVO ltProducVO = new LoteProduccionVO();
                    LoteProduccionDAO ltProducDAO = new LoteProduccionDAO(ltProducVO);

                    ArrayList<LoteProduccionVO> listaLoteProduccion = ltProducDAO.Listar();

                    for (int i = 0; i < listaLoteProduccion.size(); i++) {

                        ltProducVO = listaLoteProduccion.get(i);

                %>
                <tr>
                    <td><%=ltProducVO.getId_Lote_Produccion()%></td>
                    <td><%=ltProducVO.getId_Usuarios()%></td>
                    <td><%=ltProducVO.getId_orden_Detalles()%></td>
                    <td><%=ltProducVO.getCantidad()%></td>
                    <td><%=ltProducVO.getFecha_Fabricacion()%></td>

                    <td>
                        <form action="LoteProduccion" method="post">
                            <input type="hidden" name="txtEstado" value="0">
                            <input type="hidden" name="txtid_loteProduccion" value="<%=ltProducVO.getId_Lote_Produccion()%>">
                            <button class="btn boton">Desactivar</button>
                            <input type="hidden" value="3" name="opcion">
                        </form>
                    </td>
                </tr>

                <% }%>

            </table>
        </div>

    </body>
</html>
