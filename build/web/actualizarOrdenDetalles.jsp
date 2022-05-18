<%-- 
    Document   : actualizarOrdenDetalles
    Created on : 30/03/2022, 11:27:26 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloDAO.OrdenDetallesDAO"%>
<%@page import="ModeloVO.DetallesProductoVO"%>
<%@page import="ModeloDAO.DetallesProductoDAO"%>
<%@page import="ModeloVO.OrdenesVO"%>
<%@page import="ModeloDAO.OrdenesDAO"%>
<%@page import="ModeloVO.OrdenDetallesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <%
            OrdenDetallesVO ordenDetallVO = (OrdenDetallesVO) request.getAttribute("OrdenDetallesConsultada");
            if (ordenDetallVO != null) {
        
        %>
        
        <form action="OrdenDetalles" method="post">
             <h1>Actualizar orden detalles</h1>
             <label>Id orden detalles </label>
             <br>
             <input type="text" name="txtIdOrdenDetalles" value="<%=ordenDetallVO.getId_Orden_Detalles()%>">
             <br>
             Id Orden
             <br>
             <select name="txtIdOrden">
                 <option value="<%=ordenDetallVO.getId_Orden()%>"><%=ordenDetallVO.getId_Orden()%></option>
                  <%
                OrdenesDAO ordDAO = new OrdenesDAO();
                for(OrdenesVO ordVO:ordDAO.listar()){
                
                %>
            
                <option value="<%=ordVO.getId_Orden()%>"><%=ordVO.getId_Orden()%></option>
                <%}%>
             </select>
                <br>
                Id Detalles de Producto<br>
                <select name="idDetallesProducto">
                    <option value="<%=ordenDetallVO.getId_Detalles_Producto()%>"><%=ordenDetallVO.getId_Detalles_Producto()%></option>
                    <%
                DetallesProductoDAO dpDAO = new DetallesProductoDAO();
                for(DetallesProductoVO dpVO:dpDAO.listar()){
                
                %>
            
                <option value="<%=dpVO.getId_Detalles_Producto()%>"><%=dpVO.getId_Detalles_Producto()%></option>
                <%}%>
                </select>
                <br>
                Cantidad Solicitada<br>
                <input type="number" name="txtcantidadSolicitada" value="<%=ordenDetallVO.getCantidadSolicitada()%>">
                <br><br>
                
            <button>Actualizar</button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarOrdenDetalles.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarOrdenDetalles.jsp").forward(request, response);

}%>
        
    </body>
</html>