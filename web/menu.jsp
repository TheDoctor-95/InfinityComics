<%-- 
    Document   : menuAdmin
    Created on : 3-may-2018, 10:47:48
    Author     : pablourbano
--%>

<%@page import="entities.User"%>
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
    <body class="container-fluid">
        <%
            User e = (User) session.getAttribute("user");
            if (e != null) {
        %>
        <h1>Hello <%=e.getNombre()%></h1>
        <%
            if (e.getTipo().equals("tienda")) {%>

        <form method="POST" action="iniciarSesion">
            <div class="form-group">
                <input value="Añadir comic al inventario" id="anadirComic" class="form-control" type="submit" name="anadirComic"/>
            </div>
        </form>

        <%} else if (e.getTipo().equals("admin")) {%>
        <form method="POST" action="iniciarSesion">
            <div class="form-group">
                <input value="Añadir comic" id="anadirComic" class="form-control" type="submit" name="anadirComic"/>
            </div>
        </form>
        <form method="POST" action="iniciarSesion">
            <div class="form-group">
                <input value="Añadir coleccion" id="anadirComic" class="form-control" type="submit" name="anadirComic"/>
            </div>
        </form>
        <%} else {%>
        <form method="POST" action="iniciarSesion">
            <div class="form-group">
                <input value="Comprar comic" id="anadirComic" class="form-control" type="submit" name="anadirComic"/>
            </div>
        </form>
        <form method="POST" action="iniciarSesion">
            <div class="form-group">
                <input value="Seguir coleccion" id="anadirComic" class="form-control" type="submit" name="anadirComic"/>
            </div>
        </form>
        <%}%>

        <%} else {
        %><h1>esto no furula</h1>
        <%
            }%>
    </body>
</html>
