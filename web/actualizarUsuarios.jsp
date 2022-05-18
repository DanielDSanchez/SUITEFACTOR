<%-- 
    Document   : actualizarUsuarios
    Created on : 22/03/2022, 08:51:45 AM
    Author     : Sena
--%>
<%@include file="sesionesAlmacenista.jsp" %>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
        UsuarioVO usuVO = (UsuarioVO)request.getAttribute("usuarioConsultado");
        if(usuVO != null){
        
        %>
        
        <form action="Usuarios" method="post">
            <h1>Actualizar Usuarios</h1>
            <input type="text" name="txtId" value="<%=usuVO.getIdUsuarios()%> " required="" >
            <br>
            <input type="text" name="txtNombre" value="<%=usuVO.getNombre()%> "  required="">
            <br>
            <input type="text" name="txtDocumento" value="<%=usuVO.getDocumento()%> " required="">
            <br>
            <input type="text" name="txtTelefono" value="<%=usuVO.getTelefono()%> "  required="">
            <br>
            <input type="text" name="txtEmail" value="<%=usuVO.getEmail()%> "  required="">
            <br>
            <input type="text" name="txtDireccion" value="<%=usuVO.getDireccion()%> " required="">
            <br>
            <button id="Boton"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            <a href="consultarUsuarios.jsp">Volver</a><br>
            
        </form>
        
            <% }else{
request.getRequestDispatcher("consultarUsuarios.jsp").forward(request, response);

}%>
        
    </body>
</html>
