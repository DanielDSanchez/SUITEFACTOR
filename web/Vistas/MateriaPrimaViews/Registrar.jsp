<%-- 
    Document   : Registrar
    Created on : 23-feb-2022, 23:14:51
    Author     : 1Usuario
--%>

<%@page import="ModeloVO.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materia Prima</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="Vistas/Stilos/EstilosRmt.css">
        <link  rel="icon"   href="Vistas/img/Logo (1).png" type="png" />
    
    </head>
    <body class="row" background="Vistas/img/WhatsApp Image 2021-11-18 at 6.24.21 PM.jpeg">
        <nav class="navbar navbar-light  col-md-6 text-light">
            <div class="container-fluid">
                <a class="L navbar-brand text-light nav-link" href="RegistroOrden.html">
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
        <div class="Fondo1 col-md-4 mx-auto">


            <div class="col-md-12">

                <div class="col-md-12 mt-3">
                    <h1 class="Titulo text-center">Registrar Materia Prima</h1>
                </div>
                <form class="form form-group mx-auto" action="ControladorMateriaPrima">
                    <div class="mb-3">
                        <label class="form-label text-light "><b>Nombre Materia Prima</b></label>
                        <input type="text" class="in form-control text-light" name="nombremt">
                    </div>
                    <div class="mb-3">
                        <label class="form-label text-light"><b>Estado</b></label>
                        <select class="in form-select text-light" name="estado">
                            <option selected>Despliega las Opciones</option>
                            <option value="Activo">Activo</option>
                            <option value="Inactivo">Inactivo</option>
                        </select>
                      <%--   <% 
                         ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) request.getAttribute("listaU");
                        %>
                        /*<select class="in form-select text-light" name="usuarioId">
                            <option selected>Despliega las opciones</option>*
                            <%
                              for(Usuario u : listaUsuarios){ %>
                              
                              <option value="<%= u.getId_Usuarios()%>"><%= u.getNombre() %></option>
                              <%
                              }      
                            
                            %>                           
                        </select> --%>
                    </div>
                    <div class="col-md-6 mt-2 m">
                        <button type="submit" class="btn text-light" name="accion" value="Agregar"><b>Guardar</b></button>
                    </div>
                </form>    

            </div>
                


        </div>

    </body>
</html>
