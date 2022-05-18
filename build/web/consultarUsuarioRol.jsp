<%-- 
    Document   : consultarUsuarioRol
    Created on : 01-may-2022, 16:37:37
    Author     : 1Usuario
--%>

<%@page import="ModeloVO.RolVO"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioRolDAO"%>
<%@page import="ModeloVO.Usuario_rolVO"%>
<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1 class="text-center">UsuarioRol</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            <div class="col-md-6 mx-auto me-3">
                <label>Consultar Usuario</label>
                <form method="post" action="UsuarioRol" class="form-group">
                    <input type="text" name="txtIdRol" placeholder="Rol" class="form-control">
                    <input type="hidden" value="4" name="opcion">
                    <button class="boton btn mt-2">Consultar</button>
                </form>
                <div class="mx-auto justify-content-center">
                    <%if (request.getAttribute("bien") != null) {%>
                    <p class="text-success text-center fs-5 mt-2">${bien}</p>
                    <%}%>
                </div>
            </div>
            <div class="col-md-6">
                <label>Generar Reporte</label>
                <form action="UsuarioRol" method="post" class="form-group">
                    <select name="txtIdRol" class="form-select">
                        <option>Seleccione Rol</option>
                        <%
                            RolDAO rolDAO = new RolDAO();
                            for (RolVO rVO : rolDAO.listar()) {
                        %>
                        <option value="<%=rVO.getRoltipo()%>"><%=rVO.getRoltipo()%></option>
                        <%}%>
                        <option value="Todos">Todos</option>
                    </select>
                    <button class="boton btn mt-2">Generar Reporte
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                        <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
                        <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
                        </svg>
                    </button>
                    <input type="hidden" value="10" name="opcion">
                </form>
            </div>
        </div>
        <div class="col-md-9 mx-auto justify-content-center mt-4">
            <div class="col-md-7 mx-auto justify-content-center">
                <table class="table table-light table-hover table-striped text-center">
                    <tr>
                        <th>Rol</th>
                        <th>Usuario</th>

                    </tr>
                    <%
                        Usuario_rolVO uRVO = new Usuario_rolVO();
                        UsuarioRolDAO uRDAO = new UsuarioRolDAO(uRVO);

                        ArrayList<Usuario_rolVO> listaRol = uRDAO.listar();

                        for (int i = 0; i < listaRol.size(); i++) {

                            uRVO = listaRol.get(i);
                    %>
                    <tr>
                        <td><%=uRVO.getId_Rol()%></td>
                        <td><%=uRVO.getId_Usuarios()%></td>

                    </tr>
                    <% }%>
                </table>
            </div>
        </div>
    </body>
</html>


