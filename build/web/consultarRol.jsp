<%-- 
    Document   : consultarRol
    Created on : 28/04/2022, 12:58:13 PM
    Author     : Juan Pablo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="ModeloVO.RolVO"%>
<%@include file="navegacion.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-4 justify-content-center mx-auto mt-4">
            <h1 class="text-center">Rol</h1>
            <div class="col-md-6 mx-auto ">
                <form method="post" action="Rol" class="form-group">
                    <input type="text" name="txtId" placeholder="Id Rol" class="form-control">
                    <input type="hidden" value="4" name="opcion">
                    <button class="btn">Consultar</button>

                </form>
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
        </div>

        <div class="col-md-9 mx-auto justify-content-center mt-4">
            <div class="col-md-7 mx-auto justify-content-center">
                <table class="table table-light table-hover table-striped text-center">

                    <tr>
                        <th>Id</th>
                        <th>Tipo de rol</th>
                    </tr>
                    <%
                        RolVO RVO = new RolVO();
                        RolDAO RDAO = new RolDAO(RVO);

                        ArrayList<RolVO> listaRol = RDAO.listar();

                        for (int i = 0; i < listaRol.size(); i++) {

                            RVO = listaRol.get(i);

                    %>
                    <tr>
                        <td><%=RVO.getId_rol()%></td>
                        <td><%=RVO.getRoltipo()%></td>
                        
                         <td>
                            <form action="Rol" method="post">
                                <input type="hidden" name="txtEstado" value="0">
                                <input type="hidden" name="txtId" value="<%=RVO.getId_rol()%>">
                                <button class="boton btn">Desactivar</button>
                                <input type="hidden" value="3" name="opcion">
                            </form>
                        </td>
                    </tr>

                    <% }%>

                </table>

            </div>

        </div>
    </body>
</html>

