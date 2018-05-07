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
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            if (status != null) {
        %>
        <h1><%= status %></h1>
        <%
            }
        %>
    </body>
</html>
