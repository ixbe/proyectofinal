<%-- 
    Document   : login
    Created on : 8/11/2023, 07:52:06 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="cuadro">
        <h2>Iniciar Sesión</h2>
        <hr>
           <br><br>
        <form method="post" action="validarLogin.jsp">
        <table >
            <tr>
                <td> <label for="usuario">Usuario:</label></td>         
                <td> <input type="text" id="usuario" name="usuario" required><br></td>
            </tr>
            <tr>
                <td>  <label for="contrasenia">Contraseña:</label></td>
            
                <td> <br> <input type="password" id="contrasenia" name="contrasenia" required><br><br></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Iniciar Sesión" id="boton" width="100%"></td>
            </tr>
            
        </table>
 
        </form>
        </div>
    </body>
</html>
