<%-- 
    Document   : consultarProducto
    Created on : 4/04/2022, 08:16:18 AM
    Author     : Sena
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page import="ModeloVO.ProductoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
        <title>Cosultar Producto</title>
    </head>
    <body>
        <h1 class="text-center">Productos</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            <div class="col-md-6 mx-auto me-3">
                <form  method="post" action="Producto" class="form-group"> 
                    <input type="text" name="txtId" class="form-control" placeholder="Id Producto">
                    <input type="hidden" value="4" name="opcion">
                    <button class="btn boton mt-2">Consultar</button>
                </form>
                <div class="mx-auto justify-content-center">
                    <%if (request.getAttribute("bien") != null) {%>
                    <p class="text-success text-center fs-5 mt-2">${bien}</p>
                    <%}%>
                </div>
            </div>
            <div class="col-md-6">
                <form action="Producto" method="post" class="form-group">
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
                <table class="table table-light table-hover table-striped text-center">

                    <tr>
                        <th>Id</th>
                        <th>Nombre Producto</th>

                    </tr>

                    <%
                        ProductoVO prodVO = new ProductoVO();
                        ProductoDAO prodDAO = new ProductoDAO();
                        ArrayList<ProductoVO> listaProductos = prodDAO.listarDos();
                        for (int i = 0; i < listaProductos.size(); i++) {

                            prodVO = listaProductos.get(i);

                    %>


                    <tr>
                        <td><%=prodVO.getIdProducto()%></td>
                        <td><%=prodVO.getNombre()%></td>

                        <td>
                            <form action="Producto" method="post">
                                <input type="hidden" name="txtEstado" value="1">
                                <input type="hidden" name="txtId" value="<%=prodVO.getIdProducto()%>">
                                <button class="boton btn">Activar</button>
                                <input type="hidden" value="5" name="opcion">
                            </form>
                        </td>
                        <td>
                            <form action="Producto" method="post">
                                
                                <input type="hidden" name="txtId" value="<%=prodVO.getIdProducto()%>">
                                <button class="boton btn">Eliminar</button>
                                <input type="hidden" value="6" name="opcion">
                            </form>
                        </td>

                    </tr>

                    <% }%>

                </table>
            </div>
        </div>
    </body>
</html>
