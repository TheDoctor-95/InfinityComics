<%-- 
    Document   : tiendaCiudad
    Created on : 15-may-2018, 15:41:20
    Author     : pablourbano
--%>

<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body class="container-fluid">


        <div>
            <div class="row">
                <%
                    List<User> list = (List<User>) request.getAttribute("tiendas");

                    if (list.isEmpty()) {
                %>
                NO HAY COMICS
                <%
                } else {
                %>

                <%
                    for (User c : list) {
                %>
                <div class="col-xs-6" style="margin: 20px">
                    <form action="comicsTienda" method="POST">
                        <div class="form-group">
                            <input type="hidden" name="usernameTienda" value="<%=c.getUsername() %>" />
                            <%=c.getNombre() %> 
                            <input value="Ver Comics" id="<%=c.getNombre()%>" class="form-control" type="submit" name="<%=c.getNombre()%>"/>
                        </div>
                    </form>
                </div>
                <%}%>

                <%}%>
            </div>
        </div>
    </body>
</html>
