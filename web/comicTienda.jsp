<%-- 
    Document   : comicTienda
    Created on : 15-may-2018, 15:24:31
    Author     : pablourbano
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Comic"%>
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
        <div>
            <div class="row">
                <%
                    List<Comic> list = (List<Comic>) request.getAttribute("comics");

                    if (list.isEmpty()) {
                %>
                <h2>NO HAY COMICS</h2>
                <%
                } else {
                %>

                <%
                    for (Comic c : list) {
                %>
                <div class="col-xs-6" style="margin: 20px">
                    <form action="./deleteComics" method="POST">
                        <input type="hidden" name="nombreComic" value="<%=c.getId()%>" />
                        <img src="<%=c.getUrlImg()%>" height="100px"/>
                        <%=c.getColeccion().getName()%> <%=c.getNumber()%> <%=c.getTitle()%><input class="btn btn-block btn-danger" type="submit"  value="Comprar" />
                    </form>
                </div>
                <%}%>

                <%}%>

            </div>
        </div>
    </body>
</html>
