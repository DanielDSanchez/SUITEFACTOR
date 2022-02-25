<%-- 
    Document   : Registrar
    Created on : 23-feb-2022, 23:14:51
    Author     : 1Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="col-md-4 mx-auto">
            <h1>Registrar Materia Prima</h1>
                <form class="form form-group mx-auto" action="ControladorMateriaPrima">
                    <label>ID</label><br>
                        <input type="number" name="idmt"><br>
                        
                    <label>Nombre</label><br>
                        <input type="Text" name="nombremt"><br>
                        
                    <label>ID - X</label><br>
                        <input type="number" name="idx"><br>
                        
                        <input class="btn bg-dark text-light mt-2" type="submit" name="accion" value="Agregar"> 
                    

                </form>
        </div>
    </body>
</html>
