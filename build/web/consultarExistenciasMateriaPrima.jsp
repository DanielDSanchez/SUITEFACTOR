<%-- 
    Document   : consultarExistenciasMateriaPrima
    Created on : 18/04/2022, 05:48:18 PM
    Author     : Juan Pablo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>
<%@page import="ModeloVO.MateriaPrimaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navegacion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/">
        <title>Consultar materias primas</title>
    </head>
    <body>
        <h1 class="text-center">Consultar<br> Existencias Materia Prima</h1>
        <div class="col-md-7 justify-content-center mx-auto mt-4 d-flex ">
            <div class="col-md-3 mx-auto justify-content-center">
                <form action="MateriaPrima" method="post" class="form-group">
                    <input type="hidden" value="2" name="txtreporte">
                    <button  class="boton btn " title="Reporte de Materia Prima">
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
        <div class="col-md-6 mx-auto justify-content-center mt-2">
            <table class="table table-light table-hover table-striped text-center">
                <tr>
                    <th>Id Materia Prima</th>
                    <th>Nombre</th>
                    <th>Existencias</th>

                </tr>

                <%                    MateriaPrimaVO matPriVO = new MateriaPrimaVO();
                    MateriaPrimaDAO matPriDAO = new MateriaPrimaDAO();
                    ArrayList<MateriaPrimaVO> listaMateriaPrima = matPriDAO.Listar();
                    for (int i = 0; i < listaMateriaPrima.size(); i++) {

                        matPriVO = listaMateriaPrima.get(i);
                %>


                <tr>
                    <td><%=matPriVO.getId_materia_Prima()%></td>
                    <td><%=matPriVO.getNombre()%></td>
                    <td><%=matPriVO.getActualizacion()%></td>
                </tr>
                <% }%>
            </table>
        </div>

    </body>
</html>

