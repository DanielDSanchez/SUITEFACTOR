<%-- 
    Document   : actualizarProducto
    Created on : 4/04/2022, 08:34:25 AM
    Author     : Sena
--%>
<%@include file="sesionesJefeProduccion.jsp" %>
<%@page import="ModeloVO.ProductoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        ProductoVO proVO = (ProductoVO)request.getAttribute("productoConsultado");
        if(proVO != null){
        
        %>
        
        <form action="Producto" method="post">
            <h1>Actualizar Productos</h1>
            <label>Id producto</label>
            <br>
            <input type="text" name="txtId" value="<%=proVO.getIdProducto()%> " required="" >
            <br>
            <label>Nombre Producto</label>
            <br>
            <input type="text" name="txtNombre" value="<%=proVO.getNombre()%> "  required="">
            <br>
            <label>Estado</label>
            <br>
            <select name="txtEstado">
                <option value="<%=proVO.getEstado()%>"><%=proVO.getEstado()%></option>
                <option value="1">Activo</option>
                <option value="0">Inactivo</option>
            </select>
            <br>
            <button id="Boton"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarProducto.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarProducto.jsp").forward(request, response);

}%>
        
    </body>
</html>

