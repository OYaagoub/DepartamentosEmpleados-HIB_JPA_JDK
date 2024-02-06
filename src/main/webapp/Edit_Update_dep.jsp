<%--
  Created by IntelliJ IDEA.
  User: oyaag
  Date: 08/01/2024
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo departamento</title>
    <style>
        body {
            margin: 0;
            font-family: sans-serif;
        }

        h1 {
            text-align: center;
            font-size: 24px;
        }

        form {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<center>${error}</center>
<c:if test="${action eq 'update'}">
    <h1>Update departamento</h1>
</c:if>
<c:if test="${action eq 'new'}">
    <h1>Nuevo departamento</h1>
</c:if>

<form method="post" action="/departments">
    <label for="deptno">Dept No:</label>
    <c:if test="${action eq 'update'}">
        <input type="hidden" id="deptno" name="deptno" value="${dep.deptno}" required>
    </c:if>
    <c:if test="${action eq 'new'}">
        <input type="text" id="deptno" name="deptno" value="${dep.deptno}" required>
    </c:if>

    <input type="hidden"  name="action" value="${action}"  required>
    <br>
    <label for="dnombre">Nombre del departamento:</label>
    <input type="text" id="dnombre" value="${dep.dnombre}" name="dnombre" required>
    <br>
    <label for="loc">Localización:</label>
    <input type="text" id="loc" value="${dep.loc}" name="loc" required>
    <br>
    <input type="submit" value="Guardar">
</form>
</body>
</html>
