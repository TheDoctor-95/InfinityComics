<%-- 
    Document   : index
    Created on : 08-may-2018, 9:30:45
    Author     : TheDoctor
--%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="DAO.InfinitiComicsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Infinity Comics</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <h1 style="text-align: center;">INFINITY COMICS</h2>
        <%
            try {

                File f = new File(request.getContextPath() + File.separator + "sql.txt");
                String[] sql = new String[2];

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();

                int lineNum = 0;
                while (line != null) {
                    if (lineNum < 2) {
                        sql[lineNum] = line;
                        lineNum++;
                    }
                    line = br.readLine();
                }
                
            

        %>

       
        <div class="panel-group" id="accordion">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                            Inicio Sesion</a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <form method="POST" action="iniciarSesion">
                            <div class="form-group">
                                <label for="username">Username</label><input id="username" class="form-control" type="text" name="username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label><input id="password" class="form-control" type="password" name="password"/>
                            </div>

                            <input type="submit" value="Iniciar Session" class="btn btn-primary btn-block"/>
                        </form>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                            Registro</a>
                    </h4>
                </div>
                <div id="collapse2" class="panel-collapse collapse">
                    <div class="panel-body">

                        <form method="POST" action="registro">
                            <div class="form-group">
                                <label for="nombre">Nombre</label><input id="nombre" class="form-control" type="text" name="nombre"/>
                            </div>
                            <div class="form-group">
                                <label for="username">Username</label><input id="username" class="form-control" type="text" name="username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label><input id="password" class="form-control" type="password" name="password"/>
                            </div>
                            <div class="form-group">
                                <label for="ciudad">Ciudad</label><input id="ciudad" class="form-control" type="text" name="ciudad"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Tipo</label>
                                <select id="tipo" class="form-control" name="tipo">
                                    <option value="tienda">Tienda</option>
                                    <option value="usuario">Usuario</option>
                                </select>
                            </div>

                            <input type="submit" value="Iniciar Session" class="btn btn-primary btn-block"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%            }
            catch (FileNotFoundException ex

            
            
        ) {
        %>
        <div class="panel-group" id="accordion">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                            INFO SQL</a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <form method="POST" action="startSQL">
                            <div class="form-group">
                                <label for="username">Username</label><input id="username" class="form-control" type="text" name="username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label><input id="password" class="form-control" type="password" name="password"/>
                            </div>

                            <input type="submit" value="SAVE" class="btn btn-primary btn-block"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>

</body>
</html>
