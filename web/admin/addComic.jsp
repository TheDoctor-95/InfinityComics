<%-- 
    Document   : addComic
    Created on : 11-may-2018, 9:03:42
    Author     : TheDoctor
--%>

<%@page import="entities.Coleccion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add collection</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Add comics</h1>

        <div id="collapse2" class="panel">
            <div class="panel-body">

                <form method="POST" action="addComic">
                    <div class="form-group">
                        <label for="nombre">Nombre: </label><input id="nombre" class="form-control" type="text" name="nombre"/>
                    </div>
                     <div class="form-group">
                         <label for="nombre">Number: </label><input id="nombre" class="form-control" type="number"  name="number" step="1"/>
                    </div>
                    <div class="form-group">
                        <label for="editorial">Price: </label><input id="editorial" class="form-control" type="number" min="0" name="precio" step="0.01"/>
                    </div>
                     <div class="form-group">
                        <label for="nombre">Url Portada </label><input id="nombre" class="form-control" type="text" name="url"/>
                    </div>
                     <div class="form-group">
                        <label for="nombre">Autor: </label><input id="nombre" class="form-control" type="text" name="autor"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Collecion</label>
                        <select id="tipo" class="form-control" name="tipo">

                            <option> -- Seleciona Colleccion --</option>
                            <%
                                List<Coleccion> colections = (List<Coleccion>) request.getAttribute("coleccion");

                                for (Coleccion c : colections) {
                            %>
                            <option value="<%=c.getId()%>"><%=c.getName()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <input type="submit" value="Añadir Comic" class="btn btn-primary btn-block"/>
                </form>
            </div>
        </div>

    </body>
</html>
