<%-- 
    Document   : registrarUsuarioRol
    Created on : 01-may-2022, 16:37:18
    Author     : 1Usuario
--%>
<%@include file="sesionesAdmin.jsp" %>
<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloDAO.UsuarioRolDAO"%>
<%@page import="ModeloVO.UsuarioVO"%>
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
            UsuarioVO usuVO = (UsuarioVO) request.getAttribute("uRoles");
            if (usuVO != null) {
        %>
        <div class=" col-md-3 mx-auto justify-content-center mt-5">
            <table class="table table-hover table-striped border-info border border-2">
                <tr>
                    <td>Id</td>
                    <td><%=usuVO.getIdUsuarios()%></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><%=usuVO.getNombre()%></td>
                </tr>
                <tr>
                    <td>Documento</td>
                    <td><%=usuVO.getDocumento()%></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><%=usuVO.getTelefono()%></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%=usuVO.getEmail()%></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><%=usuVO.getDireccion()%></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td><%=usuVO.getEstado()%></td>
                </tr>
            </table>
            <form action="UsuarioRol" method="post" class="form-group">
                <input type="hidden" value="<%=usuVO.getIdUsuarios()%>" name="txtIdUsu">
                <input type="hidden" value="<%=usuVO.getNombre()%>"  name= "txtNombre" class="form-control ms-1  mt-2" >
                <input type="hidden" value="<%=usuVO.getDocumento()%>" name= "txtDocumento"  class=" form-control  ms-3 mt-2" >
                <input type="hidden" value="<%=usuVO.getTelefono()%>" name= "txtTelefono"  class="form-control  ms-1  mt-2">
                <input type="hidden" value="<%=usuVO.getDireccion()%>" name= "txtDireccion"  class="form-control ms-3 mt-2">
                <input type="hidden" value="<%=usuVO.getEmail()%>" name= "txtEmail"  class="form-control ms-1 mt-2">
                <input type="hidden" value="<%=usuVO.getEstado()%>" name= "txtEstado"  class="form-control ms-1 mt-2">
                <input type="hidden" value="<%=usuVO.getContrasena()%>" name= "txtEstado"  class="form-control ms-1 mt-2">
                <select name="txtIdRol" class="form-select mt-2">
                    <option>Seleccione Rol</option>
                    <%
                        RolDAO rolDAO = new RolDAO();
                        for (RolVO rVO : rolDAO.listar()) {
                    %>
                    <option value="<%=rVO.getId_rol()%>"><%=rVO.getRoltipo()%></option>
                    <%}%>
                </select>
                <select  name="txtEstado" class="form-select mt-2">
                    <option>Estado</option>
                    <option value="1">
                        Activo
                    </option>
                    <option value="0">
                        Inactivo
                    </option>
                </select>


                <div class="d-flex mt-3 mb-2">
                    <button class="btn boton"> Guardar </button>
                    <input type="hidden" value="1" name="opcion">
                    <a href="consultarUsuarioRol.jsp" class="nav-item ms-3">Volver</a>
                </div>
            </form>
        </div>







        <% } else {
                request.getRequestDispatcher("consultarRol.jsp").forward(request, response);

            }%>
    </body>
</html>

