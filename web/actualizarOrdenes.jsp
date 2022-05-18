<%-- 
    Document   : actualizarOrdenes
    Created on : 23/03/2022, 08:48:09 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloVO.OrdenesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        OrdenesVO ordVO = (OrdenesVO)request.getAttribute("ordenConsultada");
        if(ordVO != null){
        
        %>
        
        <form action="Ordenes" method="post">
            <h1>Actualizar Ordenes</h1>
            <label>Id orden</label>
            <br>
            <input type="text" name="txtIdOrden" value="<%=ordVO.getId_Orden()%> " required="" >
            <br>
            <label>Id usuario</label>
            <br>
            <select name="txtUsu">
                <option value="<%=ordVO.getId_Usuarios()%>"><%=ordVO.getId_Usuarios()%></option>
            <%
                UsuarioDAO usuDAO = new UsuarioDAO();
                for(UsuarioVO usuVO:usuDAO.Listar()){
                
                %>
            
                
                <option value="<%=usuVO.getIdUsuarios()%>"><%=usuVO.getNombre()%></option>
                <%}%>
            </select>
            <br>
            <label>Fecha registro</label>
            <br>
            <input type="date" name="txtFechaRegistro" value="<%=ordVO.getFecha_registro()%>">
            <br>
            <label>Fecha Entrega</label>
            <br>
            <input type="date" name="txtFechaEntrega" value="<%=ordVO.getFecha_entrega()%>">
            <br>
            <button id="Boton"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarOrdenes.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarOrdenes.jsp").forward(request, response);

}%>
        
    </body>
</html>