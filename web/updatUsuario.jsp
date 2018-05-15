<%-- 
    Document   : updatUsuario
    Created on : 15-may-2018, 22:41:07
    Author     : pablourbano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="panel-body">

            <form method="POST" action="cambiarUsuario">
                <div class="form-group">
                    <label for="nombre">Nombre</label><input id="nombre" class="form-control" type="text" name="nombre"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label><input id="password" class="form-control" type="password" name="password"/>
                </div>
                <div class="form-group">
                    <label for="ciudad">Ciudad</label><input id="ciudad" class="form-control" type="text" name="ciudad"/>
                </div>
                
                <input type="submit" value="Modificar" class="btn btn-primary btn-block"/>
            </form>
        </div>
    </body>
</html>
