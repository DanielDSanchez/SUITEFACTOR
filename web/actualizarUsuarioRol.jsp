<%-- 
    Document   : actualizarUsuarioRol
    Created on : 01-may-2022, 16:37:49
    Author     : 1Usuario
--%>
<%@include file="sesionesAdmin.jsp" %>
<%@page import="ModeloVO.Usuario_rolVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Usuario_rolVO uRVO = (Usuario_rolVO) request.getAttribute("UsuarioRolConsultado");
            if (uRVO != null) {
        %>
        <div class="col-md-3 justify-content-center mx-auto caja border border-info mt-4">
            <h1 class="text-center fs-2 mt-2">Actualizar UsuarioRol</h1>
            <div class="mx-auto justify-content-center">
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
            <div class="col-md-10 mx-auto mt-4">
                <form action="UsuarioRol" method="post" class="form-group">
                    <label class="mt-2">Id</label>
                    <input type="text" name="txtId" value="<%=uRVO.getId_Rol()%> " required="" class="form-control" >
                    <label class="mt-2">Tipo de rol</label>
                    <input type="text" name="txtroltipo" value="<%=uRVO.getId_Usuarios()%>" required="" class="form-control">
                    <select class="form-select mt-2" name="txtEstado">
                        <option selected>Seleccion el Estado</option>
                        <option value="1">Activo</option>
                        <option value="0">Inactivo</option>
                    </select>
                    <div class="d-flex mt-3 mb-2">
                        <button class="btn boton"> Actualizar </button>
                    <input type="hidden" value="2" name="opcion">
                    <a href="consultarUsuarioRol.jsp" class="nav-item ms-3">Volver</a>
                    </div>
                    

                </form>

                <% } else {
                        request.getRequestDispatcher("consultarRol.jsp").forward(request, response);

                    }%>
            </div>
        </div>
</body>
</html>

