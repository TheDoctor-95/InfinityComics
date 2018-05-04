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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User e = (User) session.getAttribute("user");
            if (e != null) {
        %>
        <h1>Hello <%=e.getNombre()%></h1>
        
        <%} else {
        %><h1>esto no furula</h1>
        <%
            }%>
    </body>
</html>
