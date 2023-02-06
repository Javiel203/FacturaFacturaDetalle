<%-- 
    Document   : eliminarUsuario
    Created on : 5 feb. 2023, 19:36:42
    Author     : Javier
--%>

<%@page import="com.javiel.loginspring.model.UsuarioDTO"%>
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
        <title>Eliminar Usuario</title>
    </head>
    <body>
        <h1>Confirmar para eliminar usuario</h1>
        </br>
        
        <form action="usuarioEliminado.do" method="post">
        <a href="usuarioLista.do" class="btn btn-primary btn-lg active">Confirmar</a>     
        <input type="hidden" name="codigoUsuario"
                   value="<%= ((UsuarioDTO) request.getAttribute("usuario")).getUsuario()%>">
        </form>
    </body>
</html>
