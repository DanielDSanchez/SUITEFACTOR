<%-- 
    Document   : consultarOrdenDetalles
    Created on : 30/03/2022, 11:06:16 AM
    Author     : Sena
--%>
<%@page import="ModeloDAO.DetallesProductoDAO"%>
<%@page import="ModeloDAO.OrdenesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.OrdenDetallesDAO"%>
<%@page import="ModeloVO.OrdenDetallesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<%@include file="css-paginacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="text-center">Orden Detalles</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            
            <div class="col-md-6 mx-auto ">
                <form method="post" action="OrdenDetalles" class="form-group">
                    <input type="text" name="txtIdOrdenDetalles" placeholder="Id Orden Detalles" class="form-control">
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
                <form action="OrdenDetalles" method="post" class="form-group">
                    <button  class="boton btn mt-5" title="Reporte de Producto">
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
            <div class="col-md-7 mx-auto justify-content-center">
                <table id="datos" number-per-page="10" class="table table-light table-hover table-striped text-center">

                    <tr>
                        <th>Id</th>
                        <th>Fecha registro --<br> Fecha Entrega</th>
                        <th>Id Detalles Producto(Nombre)</th>
                        <th>Cantidad Solicitada</th>
                    </tr>
                    <%
                        DetallesProductoDAO detProDAO = new DetallesProductoDAO();
                        OrdenDetallesVO OrdenDetallVO = new OrdenDetallesVO();
                        OrdenDetallesDAO OrdenDetallDAO = new OrdenDetallesDAO(OrdenDetallVO);
                        ArrayList<OrdenDetallesVO> listaOrdenDetalles = OrdenDetallDAO.Listar();

                        for (int i = 0; i < listaOrdenDetalles.size(); i++) {

                            OrdenDetallVO = listaOrdenDetalles.get(i);

                    %>
                    <tr>
                        <td><%=OrdenDetallVO.getId_Orden_Detalles()%></td>
                        <td><%=OrdenDetallVO.getId_Orden()%></td>
                        <td><%=OrdenDetallVO.getId_Detalles_Producto()%></td>
                        <td><%=OrdenDetallVO.getCantidadSolicitada()%></td>
                        
                        
                        <td>
                            <form action="OrdenDetalles" method="post">
                                <input type="hidden" name="txtEstado" value="0">
                                <input type="hidden" name="txtIdOrdenDetalles" value="<%=OrdenDetallVO.getId_Orden_Detalles()%>">
                                <button>Desactivar</button>
                                <input type="hidden" value="3" name="opcion">
                            </form>
                        </td>


                    </tr>

                    <% }%>

                </table>

            </div>

        </div>
    </body>
</html>
