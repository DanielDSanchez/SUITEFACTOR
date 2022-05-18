<%-- 
    Document   : actualizarRol
    Created on : 28/04/2022, 01:04:42 PM
    Author     : Juan Pablo
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.RolVO"%>
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
        RolVO RVO = (RolVO)request.getAttribute("rolConsultado");
        if(RVO != null){
        
        %>
        
        <form action="Rol" method="post">
            <h1>Actualizar Rol</h1>
            <label>Id</label>
            <br>
            <input type="text" name="txtId" value="<%=RVO.getId_rol()%> " required="" >
            <br>
            <label>Tipo de rol</label>
            <br>
            <input type="text" name="txtroltipo" value="<%=RVO.getRoltipo()%>" required="">
            <br>
            <button id="Boton"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarRol.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarRol.jsp").forward(request, response);

}%>
        
    </body>
</html>
