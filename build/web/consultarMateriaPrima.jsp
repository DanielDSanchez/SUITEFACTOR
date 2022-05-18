<%-- 
    Document   : consultarMateriaPrima
    Created on : 30/03/2022, 11:51:35 AM
    Author     : Sena
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>
<%@page import="ModeloVO.MateriaPrimaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<%@include file="css-paginacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>Consultar materias primas</title>
    </head>
    <body>
        <h1 class="text-center">Materias Primas</h1>
        <div class="col-md-4 justify-content-center mx-auto mt-4 d-flex">
            <div class="col-md-4 mx-auto ms-3">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="buscar">
                        <i class="zmdi zmdi-search">Buscar</i>
                    </label>
                    
                    <div class="mdl-textfield__expandable-holder">
                        <input type="text" onkeyup="doSearch()" class="mdl-textfield__input"  id="buscar">
                        <label class="mdl-textfield__label"></label>
                    </div>
                     <form  method="post" action="MateriaPrima" class="form-group"> 
                    <input type="text" name="txtIdMateriaPrima" class="form-control" placeholder="Id Materia Prima">
                    <input type="hidden" value="4" name="opcion">
                    <button class="btn boton mt-2">Consultar</button>
                </form>
                </div>
                <%if (request.getAttribute("mensajeError") != null) {%>
                <p class="text-danger text-center fs-5">${mensajeError}</p>
                <%   } else {%>
                <p class="text-success text-center fs-5">${mensajeExito}</p>
                <%}%>
            </div>
            <div class="col-md-6">
                <form action="MateriaPrima" method="post" class="form-group">
                    <button  class="boton btn mt-3" title="Reporte de Producto">
                        Generar Reporte
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                        <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5z"/>
                        <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3z"/>
                        </svg>
                    </button>
                    <input type="hidden" value="10" name="opcion">
                </form>
            </div>
        </div>


        <div class="col-md-9 mx-auto  mt-4">
            <div class="col-md-7 mx-auto justify-content-center">
                <table id="datos" number-per-page="10" class="table table-light table-hover table-striped text-center">

                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Acciones</th>

                    </tr>

                    <%
                        MateriaPrimaVO matPriVO = new MateriaPrimaVO();
                        MateriaPrimaDAO matPriDAO = new MateriaPrimaDAO();
                        ArrayList<MateriaPrimaVO> listaMateriaPrima = matPriDAO.ListarDos();
                        for (int i = 0; i < listaMateriaPrima.size(); i++) {

                            matPriVO = listaMateriaPrima.get(i);

                    %>


                    <tr>
                        <td><%=matPriVO.getId_materia_Prima()%></td>
                        <td><%=matPriVO.getNombre()%></td>

                        <td>
                            <form action="MateriaPrima" method="post">
                                <input type="hidden" name="txtEstado" value="0">
                                <input type="hidden" name="txtIdMateriaPrima" value="<%=matPriVO.getId_materia_Prima()%>">
                                <button class="btn boton">Desactivar</button>
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
