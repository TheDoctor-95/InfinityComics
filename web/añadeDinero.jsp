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
    </head>
    <body class="container-fluid">
        <%
            User e = (User) session.getAttribute("user");
            if (e != null) {
        %>
        <h1>Hello <%=e.getNombre()%></h1>
        

        <form method="POST" action="añadirDinero">
            <div class="form-group">
                <label for="username">Cuanto dinero quieres añadir?</label>
                <input id="añadirDinero" class="form-control" type="number" name="añadirDinero"/>
                <input type="submit" value="Añadir" class="btn btn-primary btn-block"/>
            </div>
        </form>

            
        
       <% } else {
        %><h1>esto no furula</h1>
        <%}%>
    </body>
</html>
