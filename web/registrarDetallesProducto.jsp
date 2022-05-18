<%-- 
    Document   : registrarDetallesProducto
    Created on : 28/03/2022, 10:21:09 AM
    Author     : Sena
--%>

<%@page import="ModeloVO.ProductoVO"%>
<%@page import="ModeloDAO.ProductoDAO"%>

<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Detalles del Producto</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>

    <body>
        <div class="col-md-3 justify-content-center mx-auto caja border border-info mt-4">
            <h1 class="text-center fs-2 mt-2">Registrar<br> Detalles Producto</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>

                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>

                <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-4">
                <form method ="post" action="DetallesProducto" class="form-group mt-2"> 
                    <select name="txtIdProducto" class="form-select mt-2">
                        <option selected>Seleccione un Producto..</option>
                        <%
                            ProductoDAO proDAO = new ProductoDAO();
                            for (ProductoVO proVO : proDAO.listar()) {

                        %>
                        <option value="<%=proVO.getIdProducto()%>"><%=proVO.getNombre()%></option>
                        <%}%>
                    </select>
                     <input type="text" name="txtTalla" required="" placeholder="Talla" class="form-control mt-2">
                    <input type="text" name="txtDescripcion" required="" placeholder="Descripcion" class="form-control mt-2">
                   
                    <div class="mt-2 mb-3">
                        <button class="btn boton"> Registrar </button>
                        <input type="hidden" value="1" name="opcion">     
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>
