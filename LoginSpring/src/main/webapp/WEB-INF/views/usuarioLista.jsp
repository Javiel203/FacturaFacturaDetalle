<%@page import="com.javiel.loginspring.model.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Mantenimiento de usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <br/>
        <% List<UsuarioDTO> lista = (List<UsuarioDTO>) request.getAttribute("lista"); %>
        <div class="table-responsive"> 
            <table class="table table-responsive table-sm table-dark table-striped tablebordered table-hover">
                <thead>
                    <tr class="info">
                        <th>Usuario</th>
                        <th>Clave</th>
                        <th>Nombre completo</th>
                        <th>Foto</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (UsuarioDTO usuario : lista) {%>
                    <tr>
                        <td><%= usuario.getUsuario()%></td>
                        <td><%= usuario.getClave()%></td>
                        <td><%= usuario.getNombreCompleto()%></td>
                        <td><a href="fotoMostrar.do?codigoUsuario=<%= usuario.getUsuario()%>">foto</a></td>
                        <td><a href="usuarioEliminado.do?codigoUsuario="<%= usuario.getUsuario()%>">Eliminar</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
        <a href="usuarioCrear.do" class="btn btn-primary btn-lg active">Crear Usuario</a>
    </body>
</html>
