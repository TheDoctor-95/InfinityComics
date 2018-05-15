<%-- 
    Document   : addStockTienda
    Created on : 14-may-2018, 21:56:46
    Author     : TheDoctor
--%>

<%@page import="entities.Comic"%>
<%@page import="java.util.List"%>
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
        <h1>Add Stock</h1>
        <div>
            <div class="row">
                <%
                    List<Comic> list = (List<Comic>) request.getAttribute("comics");

                    if (list.isEmpty()) {
                %>
                NO HAY COMICS
                <%
                } else {
                %>

                <%
                    for (Comic c : list) {
                %>
                <div class="col-xs-6" style="margin: 20px">
                    <form action="./addStockTienda" method="POST">
                        <input type="hidden" name="idDelete" value="<%=c.getId()%>" />
                        <img src="<%=c.getUrlImg()%>" height="100px"/>

                        <%=c.getColeccion().getName()%> <%=c.getNumber()%> <%=c.getTitle()%><br />
                        <div class="form-group">
                            <label for="pwd">Cantidad: </label>
                            <input type="number" class="form-control" name="cantidad">
                        </div>
                        <input class="btn btn-block btn-success" type="submit"  value="Add" />
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
