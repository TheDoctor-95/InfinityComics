<%-- 
    Document   : final
    Created on : 3-may-2018, 22:50:50
    Author     : Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Infinity</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            if (status != null) {
        %>
        <h1><%= status%></h1>
        <%
            }

            if (session.getAttribute("user") != null) {
        %>
        <form action="menu.jsp">
            <input type="submit" value="MENU PRINCIPAL" class="btn btn-primary btn-block" />
        </form>
        <%
        } else {
        %>
        <form action="index.jsp">
            <input type="submit" value="HOME" class="btn btn-primary btn-block" />
        </form>
        <%
            }
        %>
    </body>
</html>
