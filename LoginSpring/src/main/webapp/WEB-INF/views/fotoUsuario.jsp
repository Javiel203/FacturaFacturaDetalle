<%@page import="java.util.Base64"%>
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
        <title>Foto de usuario</title>
    </head>
    <body>
        <h1>Foto del Usuario</h1>
        <% if (request.getAttribute("usuario") == null
             || ((UsuarioDTO) request.getAttribute("usuario")).getFoto() == null) { %>
        <h2>Usuario aún sin foto</h2>
        <% } else {%>
        <img src="<%= "data:image/jpeg;base64,"
         + Base64.getEncoder().encodeToString(((UsuarioDTO) request.getAttribute("usuario")).getFoto())%>" />
        <% }%>
        <br />
        <form method="post" action="fotoGrabar.do" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Selecciona foto: </td>
                    <td><input type="file" name="archivo"></td>
                </tr>
                <tr>
                </tr>
                <tr><td colspan="2" align="center">
                        <input type="submit" value="Subir foto en jpg"></td>
                </tr>
                
            </table>
            <input type="hidden" name="codigoUsuario"
                   value="<%= ((UsuarioDTO) request.getAttribute("usuario")).getUsuario()%>">
        </form>
        <a href="usuarioLista.do" class="btn btn-primary btn-lg active">Regresar</a>
    </body>
</html>