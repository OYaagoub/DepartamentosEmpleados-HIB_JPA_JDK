<%--
    Document   : Head
    Created on : 12 Oct 2023, 12:43:57
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--<style><!%@include file="/WEB-INF/Static/css/style.css" %></style>-->
    <title>${title}</title>
</head>


    <body id="login" style="display: flex;flex-direction: column; align-items: center;justify-content: center">
        <h1>login</h1>
        <form method="POST" action="/login" style="display: flex;flex-direction: column; align-items: center;justify-content: center">
            <center>${error}</center>
            <input style="padding: 10px;border-radius: 10px;margin:10px" type="text" name="usuario" placeholder="Usuario (apilledo)" required>
            <input style="padding: 10px;border-radius: 10px;margin:10px"  type="text" name="pass" placeholder="Contraseña (id emp)" required>
            <input style="padding: 10px;border-radius: 10px;margin:10px"  type="submit" value="Iniciar session">
            
            
        </form>
        <a href="/departments">Volver al inicio</a>
    </body>
</html>
