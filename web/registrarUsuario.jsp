<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Registrar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        
            <div class="col-md-5 mx-auto justify-content-center border-5 border border-info mt-3 caja">
                <div class="col-md-11 mx-auto justify-content-center mt-5">
                    <form   class="form-group" action="Usuarios" method="get" > 
                        <h1 class="text-center fs-2">Registrese para empezar</h1>
                        <h3 class="text-center fs-4">Ingrese sus datos</h3>
                        <div class="mx-auto justify-content-center">
                            <%if (request.getAttribute("error") != null) {%>
                            <div class="container-fluid d-inline-block d-flex mx-auto">                               
                                <img src="img/error.svg" height="100">
                                <p class="text-danger text-center fs-5 mt-5">${error}</p>
                            </div>
                            <%   } else {%>
                            <p class="text-success text-center fs-5">${Bien}</p>
                            <%}%>
                        </div>
                        <div class="d-flex  ">
                            <input type="text"  name= "txtNombre" placeholder="Nombres" required="" class="form-control ms-1  mt-2"  data-bs-toggle="tooltip" data-bs-placement="top" title="Tooltip on top">
                            <input type="text"  name= "txtDocumento" placeholder="Documento" required="" class=" form-control  ms-3 mt-2" >
                        </div>
                        <div class="d-flex  ">
                            <input type="text"  name= "txtTelefono" placeholder="Telefono" required="" class="form-control  ms-1  mt-2">
                            <input type="text"  name= "txtDireccion" placeholder="Direccion" required="" class="form-control ms-3 mt-2">
                        </div>
                        <div class="d-flex   ">
                            <input type="email"  name= "txtEmail" placeholder="Email" required="" class="form-control ms-1 mt-2">
                            <input type="email"  name= "txtEmail2" placeholder="Confirme Email" required="" class="form-control ms-3  mt-2">  
                        </div> 
                        <div class="d-flex input-group mt-2 mb-3">
                            <input name="txtContrasena" id="txtPassword" type="password" class="form-control"  placeholder="Contraseña" required=""   >
                            <button class="btn boton" type="button" id="botonOn" onclick="mostrarPassword()">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash-fill" viewBox="0 0 16 16"><path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/><path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/></svg>                        </button>
                        </div>
                        <div class="input-group mt-2 mb-3">
                            <input name="txtContrasena2" id="txtPassword2" type="password" class="form-control"  placeholder="Confirme Contraseña" required="" aria-label="Recipient's username"
                                   aria-describedby="button-addon2">
                            <button class="btn boton" type="button" id="botonOn2" onclick="mostrarPassword2()">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash-fill" viewBox="0 0 16 16"><path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/><path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/></svg>                        </button>
                        </div>

                        <div class="d-flex mt-4 mb-3">
                            <button class="btn boton" >Registrar</button><br>
                            <input type="hidden" value="1" name="opcion">
                            <a href="iniciarSesion.jsp" class="nav-link text-center">¿Ya tiene una cuenta?</a>
                        </div>

                    </form>
                </div>  
                <div class="mx-auto justify-content-center">
                    <%if (request.getAttribute("Verifique") != null) {%>
                    <p class="text-danger text-center fs-5">${Verifique}</p>
                    <%}%>
                </div>
            </div>




            <script>
                function mostrarPassword() {
                    var cambio = document.getElementById("txtPassword");
                    var uno = document.getElementById('botonOn');
                    if (cambio.type == "password") {
                        cambio.type = "text";
                        uno.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16"><path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/><path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/></svg>';
                    } else {
                        cambio.type = "password";
                        uno.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash-fill" viewBox="0 0 16 16"><path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/><path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/></svg>';

                    }
                }
                ;
                function mostrarPassword2() {
                    var cambio = document.getElementById("txtPassword2");
                    var uno = document.getElementById('botonOn2');
                    if (cambio.type == "password") {
                        cambio.type = "text";
                        uno.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16"><path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/><path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/></svg>';
                    } else {
                        cambio.type = "password";
                        uno.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash-fill" viewBox="0 0 16 16"><path d="m10.79 12.912-1.614-1.615a3.5 3.5 0 0 1-4.474-4.474l-2.06-2.06C.938 6.278 0 8 0 8s3 5.5 8 5.5a7.029 7.029 0 0 0 2.79-.588zM5.21 3.088A7.028 7.028 0 0 1 8 2.5c5 0 8 5.5 8 5.5s-.939 1.721-2.641 3.238l-2.062-2.062a3.5 3.5 0 0 0-4.474-4.474L5.21 3.089z"/><path d="M5.525 7.646a2.5 2.5 0 0 0 2.829 2.829l-2.83-2.829zm4.95.708-2.829-2.83a2.5 2.5 0 0 1 2.829 2.829zm3.171 6-12-12 .708-.708 12 12-.708.708z"/></svg>';

                    }
                }
                ;
            </script>

    </body>
</html>
