<%-- 
    Document   : consultarDetallesProducto
    Created on : 28/03/2022, 10:12:45 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.DetallesProductoDAO"%>
<%@page import="ModeloVO.DetallesProductoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>Detalles Producto</title>
    </head>
    <body>
        <div class="col-md-4 justify-content-center mx-auto mt-4">
            <h1 class="text-center">Detalles Producto</h1>
            <div class="col-md-5 mx-auto ">
                <form  method="post" action="DetallesProducto" class="form-group"> 
                    <input type="text" name="txtIdProducto" class="form-control" placeholder="Id Detalles Producto">
                    <input type="hidden" value="4" name="opcion" >
                    <button class="btn">Consultar</button>
                </form>
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
        </div>


        <div class="col-md-9 mx-auto justify-content-center mt-4">
                <table class="table table-light table-hover table-striped text-center">

                    <tr>
                        
                        <th>Id</th>
                        <th>IdProducto</th>
                        <th>Talla</th>
                        <th>Descripcion</th>
                    </tr>

                    <%
                        DetallesProductoVO detProVO = new DetallesProductoVO();
                        DetallesProductoDAO detProDAO = new DetallesProductoDAO();
                        ArrayList<DetallesProductoVO> listarDetallesProducto = detProDAO.listar();
                        for (int i = 0; i < listarDetallesProducto.size(); i++) {

                            detProVO = listarDetallesProducto.get(i);

                    %>


                    <tr>
                        <td><%=detProVO.getId_Detalles_Producto()%></td>
                        <td><%=detProVO.getId_Producto()%></td>
                        <td><%=detProVO.getTalla()%></td>
                        <td><%=detProVO.getDescripcion()%></td>
                        
                         <td>
                            <form action="DetallesProducto" method="post">
                                <input type="hidden" name="txtEstado" value="0">
                                <input type="hidden" name="txtIdDetallesProducto" value="<%=detProVO.getId_Detalles_Producto()%>">
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