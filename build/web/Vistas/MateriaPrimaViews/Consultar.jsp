
<%@page import="java.util.Iterator"%>
<%@page import="ModeloVO.MateriaPrima"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.MateriaPrimaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Consultar Materia Prima</title>
        <link  rel="icon"   href="Vistas/img/Logo (1).png" type="png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="Vistas/Stilos/EstilosRmt.css">
    </head>
   <body class="row" background="Vistas/img/WhatsApp Image 2021-11-18 at 6.24.21 PM.jpeg">
        <nav class="navbar navbar-light  col-md-6 text-light">
            <div class="container-fluid">
                <a class="L navbar-brand text-light nav-link" href="ControladorMateriaPrima?accion=index">
                    <img src="Vistas/img/Logo (1).png" alt="" width="60" height="60" class="d-inline-block align-text-top">
                     SUITEFACTOR   
                </a>
            </div>
        </nav>
        <div class="col-md-6 ">
            <nav class="navbar navbar-expand-lg navbar-light col-md-12 ">
                <div class="mx-auto" id="navbarNav">

                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item active">
                            <a class=" nav-link text-light " href="ControladorMateriaPrima?accion=index">Inicio</a>
                        </li>
                        <li class="nav-item active">
                            <a class=" nav-link text-light " href="ControladorMateriaPrima?accion=consultar">Materia Prima</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-light " href="">Producto</a>
                        </li>
                        <li class="nav-item active">
                            <a class=" nav-link text-light " href="">Contactenos</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
       <div class="col-md-4 mx-auto">
            <br>
            <div class="col-md-4">
                <a class="btn text-light mt-2" href="ControladorMateriaPrima?accion=registrar">Agregar</a>
            </div>
            <br>
            <table class="table table-dark table-bordered table-hover table-responsive">
                <thead >
                    <tr >
                        <th class=" text-center">Id</th>
                        <th class=" text-center">Nombre</th>
                        <th class=" text-center">Estado</th>
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
                <tbody >
                    <tr>
                        <td class=" text-center"><%= per.getId()%></td>
                        <td class=" text-center"><%= per.getNombre()%></td>
                        <td class=" text-center"><%= per.getEstado()%></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
