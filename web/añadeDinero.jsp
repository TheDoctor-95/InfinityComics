<%-- 
    Document   : añadeDinero
    Created on : 14-may-2018, 21:41:34
    Author     : pablourbano
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

        <div>
            <form method="POST" action="anadirDinero">
                <div class="form-group">
                    <label for="dinero">Cuanto dinero quieres añadir?</label>
                    <input id="dinero" class="form-control" type="number" name="dinero"/>
                </div>
                <input type="submit" value="Añadir" class="btn btn-primary btn-block"/>
            </form>
        </div>



        <% } else {
        %><h1>esto no furula</h1>
        <%}%>
    </body>
</html>
