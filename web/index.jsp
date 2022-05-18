<%-- 
    Document   : menu
    Created on : 3/03/2022, 09:40:36 PM
    Author     : Juan Pablo
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession buscarSesion = (HttpSession) request.getSession();
    UsuarioVO usuVO = new UsuarioVO();
    if (buscarSesion.getAttribute("datosUsuario") == null) {
        usuVO = null;
    } else {
        usuVO = (UsuarioVO) buscarSesion.getAttribute("datosUsuario");
    }%> 
<!DOCTYPE html>
<html>
 <body>
 <head>
      <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/menu.css">
        <title>Menu</title>
 </head>
    <header>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand d-flex col-md-3 mb-md-0" href="menu.jsp">
                        <img src="img/Logo.png"><br>
                  </a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-lg-auto">
                      <li class="nav-item">
                        <a class="nav-link" href="#">Acerca de</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">Contáctanos</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="consultarUsuarios.jsp">Consultas</a>
                      </li>
                      <% if (usuVO == null) {%>
                            <li class="nav-item active">
                                <a class="nav-link" aria-current="page" href="iniciarSesion.jsp">Iniciar Sesión</a>
                            </li>
                            <li class="nav-item2 active2">
                                <a class="nav-link" aria-current="page" href="registrarUsuario.jsp">Registro</a>
                            </li>

                        </ul>
                        <%} else {%>
                        <form action="Sesiones" method="post">
                            <button  class="btn b1">Cerrar sesion</button>
                            <input type="hidden" value="1" name="opcion">
                        </form>
                        <%}%>
                  </div>
                </div>
              </nav>
        </div>

    </header>

    <section class="banner">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <h2>El <span class="tituloIconos">gestor de insumos</span> ideal para tu día a día.</h2>
                    </div>
            </div>

        </div>
    </section>

    <div class="modulos">
        <div class="container marketing">
          <h2 class="tituloModulos">Acerca de SuiteFactor</h2><br>

        <div class="todoInfo">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Donec a diam lectus. Set sit amet ipsum mauris. Maecenas congue ligula as quam viverra nec consectetur ant hendrerit. Donec et mollis dolor. Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Donec a diam lectus. Set sit amet ipsum mauris. Maecenas congue ligula as quam viverra nec consectetur ant hendrerit.
        </div>

        </div>
    </div>

    <div class="modulos">
        <div class="container">
          <h2 class="tituloModulos"> Módulos de SuiteFactor</h2><br>
          <div class="listaIconos">
           <div class="tresIconos">
              <svg svg class="icono1-img" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" id="Layer_1" style="enable-background:new 0 0 50 50;" version="1.1" viewBox="0 0 50 50" xml:space="preserve">
            <g>
              <path class="st5" d="M2.91,24.2c2.09,0.84,4.36,1.32,6.75,1.32c9.95,0,18.01-8.06,18.01-18.01c0-2.25-0.43-4.4-1.19-6.38H2.91V24.2   z"/>
              <g>
                <path class="st6" d="M46.07,48.12H7.21c0.06-8.88,6.07-16.33,14.24-18.59l5.19,8.99l5.19-8.99C40,31.79,46.01,39.25,46.07,48.12z"/>
                <path class="st2" d="M39.33,16.2v-2.77l-3.97-0.75c-0.21-0.9-0.57-1.75-1.04-2.52l2.28-3.34l-1.96-1.96L31.3,7.14    c-0.77-0.47-1.62-0.83-2.53-1.04l-0.75-3.97h-2.77L24.51,6.1c-0.9,0.21-1.76,0.57-2.53,1.04l-3.34-2.28l-1.96,1.96l2.28,3.34    c-0.47,0.77-0.83,1.62-1.04,2.52l-3.97,0.75v2.77l3.97,0.75c0.21,0.9,0.57,1.75,1.04,2.52l-2.28,3.34l1.96,1.96l3.34-2.28    c0.77,0.47,1.62,0.83,2.52,1.05l0.75,3.97h2.77l0.75-3.97c0.9-0.21,1.75-0.57,2.52-1.05l3.34,2.28l1.96-1.96l-2.28-3.34    c0.47-0.77,0.83-1.62,1.04-2.52L39.33,16.2z M26.64,18.97c-2.3,0-4.16-1.86-4.16-4.16c0-2.3,1.86-4.16,4.16-4.16    s4.16,1.86,4.16,4.16C30.8,17.11,28.94,18.97,26.64,18.97z"/>
                <g>
                  <path class="st4" d="M32.3,28.81c-0.32-0.09-0.68,0.05-0.85,0.35l-4.54,7.86l-4.54-7.86c-0.17-0.3-0.52-0.44-0.85-0.35     C12.88,31.2,6.8,39.14,6.73,48.12c0,0.2,0.08,0.39,0.22,0.53c0.14,0.14,0.33,0.22,0.53,0.22h38.85c0.2,0,0.39-0.08,0.53-0.22     c0.14-0.14,0.22-0.33,0.22-0.53C47.02,39.14,40.94,31.2,32.3,28.81z M39.52,47.38v-3.76c0-0.41-0.34-0.75-0.75-0.75     s-0.75,0.34-0.75,0.75v3.76H15.8v-3.76c0-0.41-0.34-0.75-0.75-0.75s-0.75,0.34-0.75,0.75v3.76H8.25     c0.37-7.81,5.65-14.64,13.12-16.96l4.89,8.48c0.13,0.23,0.38,0.38,0.65,0.38s0.52-0.14,0.65-0.38l4.89-8.48     c7.46,2.31,12.74,9.15,13.11,16.95H39.52z"/>
                  <path class="st4" d="M14.08,16.94l3.5,0.66c0.19,0.64,0.44,1.25,0.76,1.84l-2.01,2.95c-0.2,0.3-0.17,0.7,0.09,0.95l1.96,1.96     c0.26,0.25,0.66,0.29,0.95,0.09l2.95-2.01c0.59,0.32,1.2,0.58,1.84,0.76l0.66,3.51c0.07,0.35,0.38,0.61,0.74,0.61h2.77     c0.36,0,0.67-0.26,0.74-0.61l0.66-3.51c0.64-0.19,1.25-0.44,1.84-0.76l2.95,2.01c0.3,0.2,0.7,0.17,0.95-0.09l1.96-1.96     c0.25-0.25,0.29-0.65,0.09-0.95l-2.01-2.95c0.32-0.59,0.58-1.2,0.76-1.84l3.5-0.66c0.35-0.07,0.61-0.38,0.61-0.74v-2.77     c0-0.36-0.26-0.67-0.61-0.74l-3.5-0.66c-0.19-0.64-0.44-1.25-0.76-1.84l2.01-2.94c0.2-0.3,0.17-0.7-0.09-0.95l-1.96-1.96     c-0.26-0.26-0.66-0.29-0.96-0.09l-2.94,2.02c-0.58-0.32-1.2-0.57-1.84-0.76l-0.66-3.51c-0.07-0.35-0.38-0.61-0.74-0.61h-2.77     c-0.36,0-0.67,0.26-0.74,0.61l-0.66,3.51c-0.64,0.19-1.26,0.44-1.84,0.76l-2.94-2.02c-0.3-0.2-0.7-0.17-0.96,0.09l-1.96,1.96     c-0.25,0.25-0.29,0.65-0.09,0.95l2.01,2.94c-0.32,0.59-0.58,1.2-0.76,1.84l-3.5,0.66c-0.35,0.07-0.61,0.38-0.61,0.74v2.77     C13.47,16.56,13.73,16.87,14.08,16.94z M14.97,14.05l3.35-0.63c0.29-0.05,0.52-0.28,0.59-0.56c0.19-0.81,0.51-1.58,0.95-2.3     c0.16-0.25,0.15-0.57-0.02-0.82l-1.92-2.82l1.08-1.08l2.82,1.93c0.25,0.17,0.56,0.17,0.82,0.02c0.71-0.44,1.49-0.76,2.31-0.95     c0.29-0.07,0.51-0.3,0.56-0.59l0.63-3.36h1.53l0.63,3.36c0.05,0.29,0.28,0.52,0.56,0.59c0.82,0.2,1.6,0.52,2.31,0.95     c0.25,0.16,0.57,0.15,0.82-0.02l2.82-1.93l1.08,1.08l-1.92,2.82c-0.17,0.24-0.17,0.56-0.02,0.82c0.44,0.72,0.76,1.49,0.95,2.3     c0.07,0.29,0.3,0.51,0.59,0.56l3.35,0.63v1.53l-3.35,0.63c-0.29,0.05-0.52,0.28-0.59,0.56c-0.19,0.81-0.51,1.59-0.95,2.3     c-0.16,0.25-0.15,0.57,0.02,0.82l1.93,2.83l-1.08,1.08l-2.83-1.93c-0.24-0.17-0.56-0.17-0.81-0.02c-0.72,0.44-1.49,0.76-2.3,0.95     c-0.29,0.07-0.51,0.3-0.56,0.59l-0.63,3.36h-1.53l-0.63-3.36c-0.05-0.29-0.28-0.52-0.56-0.59c-0.81-0.19-1.58-0.51-2.3-0.95     c-0.25-0.15-0.57-0.15-0.81,0.02l-2.83,1.93l-1.08-1.08l1.93-2.83c0.17-0.24,0.17-0.56,0.02-0.82c-0.44-0.71-0.76-1.49-0.95-2.3     c-0.07-0.29-0.3-0.51-0.59-0.56l-3.35-0.63V14.05z"/>
                  <path class="st4" d="M26.91,19.72c2.71,0,4.91-2.2,4.91-4.91s-2.2-4.91-4.91-4.91S22,12.11,22,14.82S24.21,19.72,26.91,19.72z      M26.91,11.41c1.88,0,3.41,1.53,3.41,3.41s-1.53,3.41-3.41,3.41s-3.41-1.53-3.41-3.41S25.03,11.41,26.91,11.41z"/>
                </g>
              </g>
            </g>
            </svg>
              <h3 class="tituloIconos"> Usuarios</h3>
            <div class="descripcionIconos">Keep your patients' health information safe with HIPAA-compliant medical forms.</div>
            </div>
             <div class="tresIconos"> 
      <svg svg class="icono1-img" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"viewBox="0 0 50 50" xml:space="preserve"> 
       <g>
        <path class="st9" d="M19.86,2.13c0,11.6,9.4,21,21,21c2.84,0,5.54-0.57,8.01-1.59V1.13H19.91C19.9,1.46,19.86,1.79,19.86,2.13z"/>
        <g>
          <g>
          <circle class="st3" cx="35.83" cy="36.08" r="12.04"/>
          <path class="st7" d="M35.83,45.12c-4.98,0-9.04-4.06-9.04-9.04s4.06-9.04,9.04-9.04c4.99,0,9.04,4.06,9.04,9.04     S40.82,45.12,35.83,45.12z"/>
          <path class="st6" d="M25.61,29.73c-1.16,1.85-1.82,4.02-1.82,6.36c0,2.34,0.66,4.51,1.82,6.36c0.25,0.42,0.53,0.81,0.84,1.19     c1.85,2.3,4.53,3.9,7.58,4.36c-0.24,0.09-0.5,0.13-0.78,0.13H4.18c-1.28,0-2.3-1.03-2.3-2.31V4.43c0-1.28,1.02-2.31,2.3-2.31     h29.08c1.28,0,2.31,1.03,2.31,2.31v19.62c-2.83,0.06-5.42,1.1-7.45,2.8C27.13,27.66,26.28,28.63,25.61,29.73z"/>
          <rect class="st2" height="8.16" width="27.75" x="4.84" y="5.09"/>
          <rect class="st1" height="6.98" width="6.98" x="4.84" y="17.05"/>
          <rect class="st1" height="6.98" width="6.98" x="15.23" y="17.05"/>
          <rect class="st1" height="6.98" width="6.98" x="25.61" y="17.05"/>
          <rect class="st5" height="6.98" width="6.98" x="4.84" y="26.85"/>
          <rect class="st5" height="6.98" width="6.98" x="15.23" y="26.85"/>
          <rect class="st5" height="6.98" width="6.98" x="4.84" y="36.65"/>
          <rect class="st5" height="6.98" width="6.98" x="15.23" y="36.65"/>
          </g>
          <g>
            <path class="st4" d="M36.31,23.32V4.43c0-1.68-1.37-3.06-3.06-3.06H4.18c-1.68,0-3.05,1.38-3.05,3.06v34.08     c0,0.42,0.33,0.75,0.75,0.75c0.41,0,0.75-0.33,0.75-0.75c0,0,0-0.01-0.01-0.01V4.43c0.01-0.87,0.69-1.56,1.56-1.56h27.24     c0.02,0,0.04,0.01,0.07,0h1.76c0.86,0,1.56,0.7,1.56,1.56v18.91c-0.5,0.04-0.99,0.1-1.47,0.2v-6.49c0-0.41-0.34-0.75-0.75-0.75     h-6.98c-0.41,0-0.75,0.34-0.75,0.75v6.98c0,0.41,0.34,0.75,0.75,0.75h4.26c-4.06,2.15-6.83,6.41-6.83,11.31     c0,4.89,2.76,9.14,6.79,11.29H4.18c-0.87,0-1.55-0.68-1.56-1.55v-3.31c0-0.41-0.33-0.75-0.74-0.75c-0.42,0-0.75,0.34-0.75,0.75     v3.31c0,1.68,1.37,3.05,3.05,3.05h29.07c0.19,0,0.36-0.07,0.49-0.19c0.68,0.11,1.38,0.19,2.1,0.19c7.05,0,12.79-5.74,12.79-12.79     C48.62,29.19,43.14,23.57,36.31,23.32z M26.36,17.8h5.48v5.48h-5.48V17.8z M35.83,47.37c-6.23,0-11.29-5.06-11.29-11.29     s5.06-11.29,11.29-11.29s11.29,5.06,11.29,11.29S42.06,47.37,35.83,47.37z"/>
            <path class="st4" d="M35.83,26.29c-5.4,0-9.79,4.39-9.79,9.79s4.39,9.79,9.79,9.79s9.79-4.39,9.79-9.79S41.23,26.29,35.83,26.29z      M35.83,44.37c-4.57,0-8.29-3.72-8.29-8.29s3.72-8.29,8.29-8.29s8.29,3.72,8.29,8.29S40.4,44.37,35.83,44.37z"/>
            <path class="st4" d="M35.83,32.26c0.85,0,1.54,0.69,1.54,1.53c0,0.41,0.34,0.75,0.75,0.75s0.75-0.34,0.75-0.75     c0-1.41-0.98-2.59-2.29-2.93v-0.53c0-0.41-0.34-0.75-0.75-0.75s-0.75,0.34-0.75,0.75v0.53c-1.31,0.34-2.28,1.52-2.28,2.93     c0,1.67,1.36,3.04,3.03,3.04c0.85,0,1.54,0.69,1.54,1.53c0,0.85-0.69,1.54-1.54,1.54c-0.85,0-1.53-0.69-1.53-1.54     c0-0.41-0.34-0.75-0.75-0.75s-0.75,0.34-0.75,0.75c0,1.41,0.97,2.59,2.28,2.93v0.53c0,0.41,0.34,0.75,0.75,0.75     s0.75-0.34,0.75-0.75V41.3c1.31-0.34,2.29-1.52,2.29-2.93c0-1.67-1.36-3.03-3.04-3.03c-0.85,0-1.53-0.69-1.53-1.54     C34.3,32.95,34.98,32.26,35.83,32.26z"/>
            <path class="st4" d="M1.88,41.26c0.41,0,0.74-0.34,0.74-0.75c0-0.41-0.33-0.75-0.74-0.75c-0.42,0-0.75,0.34-0.75,0.75     C1.13,40.92,1.46,41.26,1.88,41.26z"/>
            <path class="st4" d="M33.34,13.25V5.09c0-0.41-0.34-0.75-0.75-0.75H4.84c-0.41,0-0.75,0.34-0.75,0.75v8.16     c0,0.41,0.34,0.75,0.75,0.75h27.75C33,14,33.34,13.66,33.34,13.25z M31.84,12.5H5.59V5.84h26.25V12.5z"/>
            <path class="st4" d="M4.09,24.03c0,0.41,0.34,0.75,0.75,0.75h6.98c0.41,0,0.75-0.34,0.75-0.75v-6.98c0-0.41-0.34-0.75-0.75-0.75     H4.84c-0.41,0-0.75,0.34-0.75,0.75V24.03z M5.59,17.8h5.48v5.48H5.59V17.8z"/>
            <path class="st4" d="M4.09,24.03c0,0.41,0.34,0.75,0.75,0.75h6.98c0.41,0,0.75-0.34,0.75-0.75v-6.98c0-0.41-0.34-0.75-0.75-0.75     H4.84c-0.41,0-0.75,0.34-0.75,0.75V24.03z M5.59,17.8h5.48v5.48H5.59V17.8z"/>
            <path class="st4" d="M4.09,33.83c0,0.41,0.34,0.75,0.75,0.75h6.98c0.41,0,0.75-0.34,0.75-0.75v-6.98c0-0.41-0.34-0.75-0.75-0.75     H4.84c-0.41,0-0.75,0.34-0.75,0.75V33.83z M5.59,27.6h5.48v5.48H5.59V27.6z"/>
            <path class="st4" d="M22.95,26.85c0-0.41-0.34-0.75-0.75-0.75h-6.98c-0.41,0-0.75,0.34-0.75,0.75v6.98     c0,0.41,0.34,0.75,0.75,0.75h6.98c0.41,0,0.75-0.34,0.75-0.75V26.85z M21.45,33.08h-5.48V27.6h5.48V33.08z"/>
            <path class="st4" d="M4.09,43.63c0,0.41,0.34,0.75,0.75,0.75h6.98c0.41,0,0.75-0.34,0.75-0.75v-6.98c0-0.41-0.34-0.75-0.75-0.75     H4.84c-0.41,0-0.75,0.34-0.75,0.75V43.63z M5.59,37.4h5.48v5.48H5.59V37.4z"/>
            <path class="st4" d="M22.2,35.9h-6.98c-0.41,0-0.75,0.34-0.75,0.75v6.98c0,0.41,0.34,0.75,0.75,0.75h6.98     c0.41,0,0.75-0.34,0.75-0.75v-6.98C22.95,36.23,22.62,35.9,22.2,35.9z M21.45,42.88h-5.48V37.4h5.48V42.88z"/>
          </g>
        </g>
       </g>
      </svg>
        <h3 class="tituloIconos">Calculadora de insumos</h3>
            <div class="descripcionIconos">Create online patient intake and medical consent forms that patients can complete before their appointments.</div>
            </div>
      <div class="tresIconos">
        <svg svg class="icono1-img" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 50 50" xml:space="preserve">
        <g>
          <path class="st5" d="M16.07,13.34c-5.61,0-10.7,2.22-14.47,5.8v29.73h29.6c3.63-3.77,5.87-8.89,5.87-14.54   C37.07,22.74,27.67,13.34,16.07,13.34z"/>
          <g>
            <path class="st1" d="M36.04,11.78l3.66-9.4c-4.26-2.11-9.62,3.35-13.39,0l3.65,9.4h0.03c-5.75,2.44-10.04,11.4-10.04,17.58    c0,0.22,0.01,0.43,0.01,0.64V30l-0.19,6.08l13.16,4.51l12.87-8.73c0.18-0.73,0.28-1.56,0.28-2.5    C46.09,23.18,41.8,14.22,36.04,11.78z"/>
            <path class="st6" d="M47.47,33.53c-0.29-0.81-0.92-1.39-1.67-1.68c-0.74-0.29-1.61-0.3-2.39,0.03l-12.59,5.35h-0.01l-2.46,1.05    l0.93-1.12c0.03-0.06,0.06-0.12,0.08-0.18c0.62-1.52-0.11-3.23-1.62-3.83L19.96,30V30l-0.27-0.11c-1.65-0.67-3.5-0.65-5.14,0.04    l-6.89,2.93l3.91,9.22l3.2-1.36l10.08,4.08c1.05,0.43,2.24,0.42,3.29-0.03l17.72-7.52c0.75-0.32,1.29-0.91,1.58-1.61    C47.7,34.99,47.73,34.24,47.47,33.53z"/>
            <polygon class="st2" points="12.51,44.31 7.03,47.88 3.56,32.4 6.86,31 7.65,32.86 11.56,42.08   "/>
            <path d="M29.29,37.16c0.44,0.03,0.9,0.05,1.36,0.06c0.06,0,0.11,0,0.17,0.01h0.01"/>
            <g>
              <path class="st4" d="M48.18,33.27c-0.27-0.77-0.82-1.41-1.54-1.83c0.12-0.65,0.2-1.34,0.2-2.08c0-6.28-4.17-15.04-9.85-17.96     l3.4-8.75c0.14-0.36-0.02-0.77-0.37-0.94C37.78,0.59,35.4,1.3,33.1,1.98c-2.46,0.73-4.59,1.35-6.29-0.16     c-0.26-0.23-0.64-0.25-0.93-0.06c-0.28,0.2-0.4,0.56-0.27,0.89l3.4,8.76c-5.54,2.86-9.62,11.29-9.8,17.53     c-1.64-0.46-3.4-0.36-4.96,0.31l-6.2,2.63l-0.5-1.17c-0.16-0.38-0.6-0.56-0.98-0.4l-3.31,1.4c-0.33,0.14-0.52,0.5-0.44,0.85     L6.3,48.04c0.05,0.24,0.22,0.44,0.45,0.53c0.09,0.04,0.19,0.06,0.28,0.06c0.14,0,0.29-0.04,0.41-0.12l5.48-3.57     c0.3-0.2,0.42-0.59,0.28-0.92l-0.65-1.54l2.22-0.94l6.47,2.61c0.37,0.16,0.82-0.04,0.97-0.41c0.08-0.19,0.08-0.39,0-0.57     c-0.08-0.19-0.23-0.33-0.41-0.41l-6.75-2.73c-0.18-0.07-0.4-0.07-0.57,0.01l-2.52,1.06l-3.32-7.83l6.2-2.64     c1.43-0.61,3.09-0.64,4.57-0.04l0.19,0.08c0.03,0.01,0.05,0.02,0.08,0.03l7.79,3.15c0.83,0.33,1.37,1.13,1.37,2.02     c0,0.28-0.05,0.56-0.16,0.84c-0.01,0.01-0.08,0.17-0.14,0.33l-0.08,0.19c-0.03,0.08-0.07,0.16-0.1,0.23l-0.04,0.08     c-0.04,0-0.07-0.01-0.1,0c-0.31,0.06-0.64,0.05-0.95-0.03c-0.1-0.02-0.19-0.05-0.29-0.09l-7-2.05c-0.38-0.12-0.81,0.12-0.93,0.51     c-0.11,0.39,0.11,0.81,0.51,0.93c0.01,0,0.01,0,0.02,0l6.88,2.02c0.15,0.06,0.31,0.1,0.45,0.14c0.3,0.07,0.61,0.11,0.91,0.11     c0.23,0,0.45-0.02,0.68-0.06c0.16-0.03,0.29-0.12,0.4-0.24c0.12,0.01,0.25-0.01,0.36-0.06l1.84-0.79h0.02l12.59-5.35     c0.57-0.24,1.24-0.25,1.82-0.02c0.61,0.23,1.04,0.66,1.24,1.23c0.09,0.24,0.13,0.49,0.13,0.74c0,0.29-0.05,0.58-0.16,0.84     c-0.22,0.54-0.64,0.97-1.18,1.2l-17.72,7.52c-0.76,0.32-1.62,0.36-2.39,0.13c-0.39-0.11-0.82,0.12-0.94,0.51     c-0.05,0.19-0.03,0.39,0.06,0.57c0.1,0.17,0.25,0.3,0.44,0.36h0.01c0.47,0.14,0.95,0.21,1.44,0.21c0.68,0,1.34-0.14,1.97-0.4     l17.72-7.52c0.91-0.39,1.61-1.11,1.98-2.02c0.18-0.45,0.27-0.92,0.27-1.4C48.4,34.1,48.33,33.68,48.18,33.27z M7.53,46.66     l-3.1-13.81l2.04-0.86l5.11,12.04L7.53,46.66z M27.75,4.02c1.87,0.54,3.91-0.06,5.77-0.61c1.86-0.55,3.64-1.07,5.21-0.62     l-3.2,8.23h-5.05L27.75,4.02z M43.12,31.19l-12.86,5.46c0.05-0.26,0.08-0.52,0.08-0.79c0-1.51-0.91-2.85-2.31-3.41l-7.33-2.96     c0-0.05,0-0.09,0-0.14c0-5.88,4.13-14.46,9.47-16.83h5.7c5.34,2.36,9.47,10.94,9.47,16.83c0,0.56-0.05,1.08-0.13,1.58     C44.5,30.84,43.77,30.92,43.12,31.19z"/>
              <path class="st4" d="M23.65,43.5c-0.37-0.15-0.82,0.04-0.97,0.42c-0.16,0.38,0.03,0.82,0.41,0.97c0.09,0.04,0.18,0.06,0.28,0.06     c0.31,0,0.58-0.19,0.7-0.47C24.22,44.1,24.04,43.66,23.65,43.5z"/>
              <path class="st4" d="M33,19.22c1.25,0,2.27,1.02,2.27,2.27c0,0.41,0.34,0.75,0.75,0.75s0.75-0.34,0.75-0.75     c0-1.82-1.3-3.35-3.02-3.7v-0.88c0-0.41-0.34-0.75-0.75-0.75s-0.75,0.34-0.75,0.75v0.88c-1.72,0.35-3.02,1.87-3.02,3.7     c0,2.08,1.69,3.77,3.77,3.77c1.25,0,2.27,1.02,2.27,2.27s-1.02,2.27-2.27,2.27s-2.27-1.02-2.27-2.27c0-0.41-0.34-0.75-0.75-0.75     s-0.75,0.34-0.75,0.75c0,1.82,1.3,3.35,3.02,3.7v0.88c0,0.41,0.34,0.75,0.75,0.75s0.75-0.34,0.75-0.75v-0.88     c1.72-0.35,3.02-1.87,3.02-3.7c0-2.08-1.69-3.77-3.77-3.77c-1.25,0-2.27-1.02-2.27-2.27S31.75,19.22,33,19.22z"/>
            </g>
          </g>
        </g>
        </svg>
          <h3 class="tituloIconos">Gestión de insumos</h3>
            <div class="descripcionIconos">Automatically book new appointments in your calendar with our Google Calendar integration.</div>
            </div>
          </div>
        </div>
      </div>


 
      <div class="container marketing">
        <h2 class="tituloModulos"> Ventajas de SuiteFactor</h2><br>
      <div class="row featurette">
        <div class="informacion">
        <article>       
            <img src="img/gear1.svg" alt="" width="102px" height="102px" style="float: left;"><br>
            <div class="todoInfo">Collect documents, signatures, application fees, class registrations, course evaluations, and quiz responses.
            </div>
        </article> <br>
        <article>
            <img src="img/gear1.svg" alt="" width="102px" height="102px" style="float: left;"><br>
            <div class="todoInfo">Collect documents, signatures, application fees, class registrations, course evaluations, and quiz responses.
            </div>
          </article> <br>
          <article>
              <img src="img/gear1.svg" alt="" width="102px" height="102px" style="float: left;"><br>
            <div class="todoInfo">Collect documents, signatures, application fees, class registrations, course evaluations, and quiz responses.
            </div>
          </article> <br>
        </div>
        <div class="col-md-5 order-md-1">
            <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" src="img/Ventajas.svg">
        </div>
      </div>
  </div>

    </body>
</html>
