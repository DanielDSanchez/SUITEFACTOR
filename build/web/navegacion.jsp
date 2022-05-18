<%-- 
    Document   : navegacion
    Created on : 20/04/2022, 01:32:17 PM
    Author     : Juan Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        <link rel="icon" href="img/LogoFinal.svg" >
        <link rel="stylesheet" href="css/estilos.css">


    </head>
    <body class="row">

        <nav class="navbar navbar-light  col-md-4 text-light">
            <div class="container-fluid">
                <a class="navbar-brand text-light nav-link" href="menu.jsp">
                    <img src="img/LogoFinal.svg" height="55" class="d-inline-block align-text-top mt-2">
                </a>
            </div>
        </nav>
        <div class="col-md-4">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="mt-4 mx-auto " id="navbarNav">
                    <ul class="navbar-nav fs-4">
                        <li class="nav-item active ">
                            <a class="navbar-brand text-dark " href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item dropdown font-dark">
                            <a class="navbar-brand dark-link dropdown-toggle " href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Registrar
                            </a>
                            <ul class="dropdown-menu " >
                                <li><a class="dropdown-item font-dark" href="registrarMateriasPrimas.jsp">Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark" href="registrarProducto.jsp">Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="registrarLoteMateriaPrima.jsp">Lote Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark"  href="registrarLoteProduccion.jsp">Lote Produccion</a></li>
                                <li><a class="dropdown-item font-dark"  href="registrarOrdenes.jsp">Ordenes</a></li>
                                <li><a class="dropdown-item font-dark"  href="registrarOrdenDetalles.jsp">Orden Detalles</a></li>
                                <li><a class="dropdown-item font-dark"  href="registrarUsuario.jsp">Usuarios</a></li>
                                <li><a class="dropdown-item font-dark"  href="registrarDetallesProducto.jsp">Detalles Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="registrarRol.jsp">Rol</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown font-dark ">
                            <a class="navbar-brand dropdown-toggle " href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Consultar
                            </a>
                            <ul class="dropdown-menu " >
                                <li><a class="dropdown-item font-dark" href="consultarMateriaPrima.jsp">Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark" href="consultarExistenciasMateriaPrima.jsp">Existencias Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark" href="consultarProducto.jsp">Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="consultarLoteMateriaPrima.jsp">Lote Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarLoteProduccion.jsp">Lote Produccion</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarOrdenes.jsp">Ordenes</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarOrdenDetalles.jsp">Orden Detalles</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarUsuarios.jsp">Usuarios</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarDetallesProducto.jsp">Detalles Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="consultarRol.jsp">Rol</a></li>
                            </ul>
                        </li
                        <li class="nav-item dropdown font-dark ">
                            <a class="navbar-brand dropdown-toggle " href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Registros desactivados
                            </a>
                            <ul class="dropdown-menu " >
                                <li><a class="dropdown-item font-dark" href="eliminarMateriaPrima.jsp">Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark" href="eliminarProducto.jsp">Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="eliminarLoteMateriaPrima.jsp">Lote Materia Prima</a></li>
                                <li><a class="dropdown-item font-dark"  href="eliminarLoteProduccion.jsp">Lote Produccion</a></li>
                                <li><a class="dropdown-item font-dark"  href="eliminarOrdenes.jsp">Ordenes</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarOrdenDetalles.jsp">Orden Detalles</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarUsuarios.jsp">Usuarios</a></li>
                                <li><a class="dropdown-item font-dark"  href="consultarDetallesProducto.jsp">Detalles Producto</a></li>
                                <li><a class="dropdown-item font-dark" href="consultarRol.jsp">Rol</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="col-md-4 mt-3  justify-content-center d-flex">
            <form action="Sesiones" method="post">
                <button  class="btn boton mt-3">Cerrar sesion</button>
                <input type="hidden" value="1" name="opcion">
            </form>

        </div>

    </body>
</html>
