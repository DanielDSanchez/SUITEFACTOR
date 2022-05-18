<%-- 
    Document   : actualizarMateriaPrima
    Created on : 18/04/2022, 09:18:02 PM
    Author     : Juan Pablo
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.MateriaPrimaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        MateriaPrimaVO mpVO = (MateriaPrimaVO)request.getAttribute("MateriaPrimaConsultada");
        if(mpVO != null){
        
        %>
        
        <form action="MateriaPrima" method="post">
            <h1>Actualizar materia prima</h1>
            <label>Id materia prima</label>
            <br>
            <input type="text" name="txtIdMateriaPrima" value="<%=mpVO.getId_materia_Prima()%> " required="" >
            <br>
            <label>Nombre</label>
            <br>
            <input type="text" name="txtNombre" value="<%=mpVO.getNombre()%>" required="">
            <br>
           
            <button id="Boton"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarMateriaPrima.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarMateriaPrima.jsp").forward(request, response);

}%>
        
    </body>
</html>
