
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.MateriaPrima"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Consultar Materia Prima</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="col-md-6 mx-auto">
            <h1 class="text-center">Materia Prima</h1>
            
            <br>
            <br>
            <table class="table table-info table-bordered table-hover table-responsive">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">ID</th>
                    </tr>
                </thead>
                <%
                    MateriaPrimaDAO dao=new MateriaPrimaDAO();
                    List<MateriaPrima>list=dao.consultar();
                    Iterator<MateriaPrima>iter=list.iterator();
                    MateriaPrima per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getNombre()%></td>
                        <td><%= per.getIdUs()%></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
