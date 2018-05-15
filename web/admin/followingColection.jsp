<%-- 
    Document   : followingColection
    Created on : 15-may-2018, 22:45:36
    Author     : TheDoctor
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Coleccion"%>
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
    <body>
       <h1>FOLLOW COLECTION</h1>
        <div>
            <div class="row">
                <%
                    List<Coleccion> list = (List<Coleccion>) request.getAttribute("coleccions");

                    if (list.isEmpty()) {
                %>
                NO HAY COMICS
                <%
                } else {
                %>
                
                    <%
                        for (Coleccion c : list) {
                    %>
                    <div class="col-xs-6" style="margin: 20px">
                        <form action="./followColeccion" method="POST">
                            <input type="hidden" name="idFollow" value="<%=c.getId() %>" />
                            <%=c.getName()%> - <%=c.getType() %>
                        </form>
                    </div>
                    <%
                        }

                    %>
                
                <%                    }


                %>
            </div>
    </body>
</html>
